package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Ledger01Repos {

    val logger: Logger = LoggerFactory.getLogger(Ledger01Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /** 统计 */
    fun stats(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select applicant as name, count(*) as value from journal01 group by applicant order by value desc
        """.trimIndent())
    }

    /** 查询 */
    fun filter(body: Map<String, Any>): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *
            from
                journal01
            where
                position(? in date) = 1
                and position(? in dept) = 1
                and position(? in applicant) = 1
        """.trimIndent(), body["date"], body["dept"], body["user"])
    }

    /** 列表 */
    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal01 order by id desc limit 200
        """.trimIndent())
    }

    /** 返还 */
    fun returnHandler(body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal01
            set
                return_by = ?,
                return_by_id = ?,
                return_date = now(),
                return_time = now()
            where
                id = ?
        """.trimIndent(), body["return_by"], body["return_by_id"], body["id"])
    }

    /** 所有待返还列表 */
    fun returnList(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                id, uuid,
                date, time, quantity, applicant, applicant_id, dept,
                borrow_date, borrow_time, borrow, borrow_id,
                remark
            from
                journal01
            where
                return_by_id = 0
            order by
                id desc
            limit 1000
        """.trimIndent())
    }

    /**
     * get
     */
    fun get(id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal01 where id = ? limit 1
        """.trimIndent(), id)
    }

    /** 新增申请 */
    fun save(body: Map<String, Any>) {
        jdbc!!.update("""
            insert into
                journal01
            set
                uuid = uuid(),
                date = now(),
                time = now(),
                quantity = ?,
                applicant = ?,
                dept = ?,
                borrow = ?,
                remark = ?
        """.trimIndent(), body["quantity"], body["applicant"], body["dept"], body["borrow"], body["remark"])
    }
}
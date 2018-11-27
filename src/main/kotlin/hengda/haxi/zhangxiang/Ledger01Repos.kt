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

    /**
     * 计数：待返还
     */
    fun returnQty(): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal01 where borrow_id != 0 and return_by_id = 0
        """.trimIndent())
    }

    /**
     * 计数：待发放
     */
    fun reviewQty(): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal01 where borrow_date <= '0001-01-01'
        """.trimIndent())
    }

    /**
     * 统计
     */
    fun stats(): List<Map<String, Any>> {
         return jdbc!!.queryForList("""
            select applicant as name, count(*) as value from journal01 group by applicant order by value desc
        """.trimIndent())
    }

    /**
     * 查询
     */
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

    /**
     * 列表
     */
    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal01 order by id desc limit 200
        """.trimIndent())
    }

    /**
     * 返还
     */
    fun returnHandler(body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal01
            set
                return_name = ?,
                return_by = ?,
                return_by_id = ?,
                return_date = now(),
                return_time = now(),
                remark = ?
            where
                id = ?
        """.trimIndent(), body["return_name"], body["return_by"], body["return_by_id"], body["remark"], body["id"])
    }

    /**
     * 指定用户待返还列表
     */
    fun returnListByUser(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal01 where applicant_id = ? and return_by_id != 0
        """.trimIndent(), id)
    }

    /**
     * 所有待返还列表
     */
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
                borrow_id != 0
                and return_by_id = 0
            order by
                id desc
            limit 1000
        """.trimIndent())
    }

    /**
     * 待发放列表
     */
    fun reviewList(): List<Map<String, Any>> {
         return jdbc!!.queryForList("""
            select
                j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
            from
                journal01 as j
            where
                borrow_date <= '0001-01-01'
        """.trimIndent())
    }

    /**
     * 借出人待发放列表
     */
    fun listByBorrower(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
            from
                journal01 as j
            where
                applicant_id = ?
                and borrow_id = 0
        """.trimIndent(), id)
    }

    /**
     * 发放
     */
    fun borrow(body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal01
            set
                borrow_date = now(),
                borrow_time = now(),
                borrow = ?,
                borrow_id = ?
            where
                id = ?
        """.trimIndent(), body["borrow"], body["borrowId"], body["id"])
    }

    /**
     * get
     */
    fun get(id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal01 where id = ? limit 1
        """.trimIndent(), id)
    }

    /**
     * 新增申请
     */
    fun save(body: Map<String, Any>) {
        jdbc!!.update("""
            insert into
                journal01
            set
                uuid = uuid(),
                date = now(),
                time = now(),
                quantity = ?,
                applicant_id = ?,
                applicant = ?,
                dept = ?,
                remark = ?
        """.trimIndent(), body["quantity"], body["applicantId"], body["applicant"], body["dept"], body["remark"])
    }
}
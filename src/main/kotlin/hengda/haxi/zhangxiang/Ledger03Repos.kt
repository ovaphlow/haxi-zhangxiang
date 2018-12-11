package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Ledger03Repos {

    val logger: Logger = LoggerFactory.getLogger(Ledger03Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun reviewHandler(body: Map<String, Any>) {
        jdbc!!.update("""
            update ledger03 set review_datime = now(), review = ?, review_by = ?, remark = ? where id = ?
        """.trimIndent(), body["review"], body["review_by"], body["remark"], body["id"])
    }

    fun listReview(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *,
                date_format(applicant_datime, '%Y-%m-%d %T') as applicant_datime_a,
                date_format(review_datime, '%Y-%m-%d %T') as review_datime_a
            from
                ledger03
            where
                review_by = ''
            order by
                id desc
            limit 200
        """.trimIndent())
    }

    fun get(id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from ledger03 where id = ? limit 1
        """.trimIndent(), id)
    }

    fun save(body: Map<String, Any>) {
        jdbc!!.update("""
            insert into
                ledger03 (
                    uuid, train, dept, applicant, count_p_zk, count_p_bm, remark
                )
                values (
                    uuid(), ?, ?, ?, ?, ?, ?
                )
        """.trimIndent(), body["train"], body["dept"], body["applicant"], body["count_p_zk"], body["count_p_bm"],
                body["remark"])
    }

    /* 列表 */
    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *,
                date_format(applicant_datime, '%Y-%m-%d %T') as applicant_datime_a,
                date_format(review_datime, '%Y-%m-%d %T') as review_datime_a
            from
                ledger03
            order by
                id desc
            limit 200
        """.trimIndent())
    }
}
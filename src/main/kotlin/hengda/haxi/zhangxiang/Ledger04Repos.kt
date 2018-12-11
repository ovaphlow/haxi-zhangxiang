package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Ledger04Repos {

    val logger: Logger = LoggerFactory.getLogger(Ledger04Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun update(id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update
                ledger04
            set
                review = ?,
                review_by = ?,
                remark = ?
            where
                id = ?
        """.trimIndent(), body["review"], body["review_by"], body["remark"], id)
    }

    fun get(id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                *,
                date_format(applicant_datime, '%Y-%m-%d %T') as applicant_datime_alt,
                date_format(review_datime, '%Y-%m-%d %T') as review_datime_alt
            from
                ledger04
            where
                id = ?
        """.trimIndent(), id)
    }

    fun listReview(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *,
                date_format(applicant_datime, '%Y-%m-%d %T') as applicant_datime_alt,
                date_format(review_datime, '%Y-%m-%d %T') as review_datime_alt
            from
                ledger04
            where
                review_by = ''
            limit 200
        """.trimIndent())
    }

    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *,
                date_format(applicant_datime, '%Y-%m-%d %T') as applicant_datime_alt,
                date_format(review_datime, '%Y-%m-%d %T') as review_datime_alt
            from
                ledger04
            order by
                id desc
            limit 200
        """.trimIndent())
    }

    fun save(body: Map<String, Any>) {
        jdbc!!.update("""
            insert into
                ledger04 (
                    uuid, dept, applicant, train, detail, remark
                )
                values (
                    uuid(), ?, ?, ?, ?, ?
                )
        """.trimIndent(), body["dept"], body["applicant"], body["train"], body["detail"], body["remark"])
    }
}
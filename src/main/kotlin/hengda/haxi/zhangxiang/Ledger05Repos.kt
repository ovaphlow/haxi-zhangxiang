package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Ledger05Repos {

    val logger: Logger = LoggerFactory.getLogger(Ledger05Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *
            from
                ledger05
            limit 200
        """.trimIndent())
    }
}
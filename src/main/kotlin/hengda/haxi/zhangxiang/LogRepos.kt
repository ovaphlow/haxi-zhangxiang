package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class LogRepos {
    val logger: Logger = LoggerFactory.getLogger(LogRepos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun save(user_id: Int, operation: String, row_id: Int) {
        jdbc!!.update("""
            insert into
                log (
                    uuid, user_id, operation, row_id
                )
                values (
                    uuid(), ?, ?, ?
                )
        """.trimIndent())
    }
}
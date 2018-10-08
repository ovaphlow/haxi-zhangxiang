package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Journal02Repos {
    val logger: Logger = LoggerFactory.getLogger(Journal02Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /**
     *
     */
}
package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

/**
 * 一体化作业申请单---退回
 */
@RestController
@RequestMapping("/api/journal02")
class Journal02RejectController {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @RequestMapping("/{id}/reject/p_jsy", method = [RequestMethod.PUT])
    fun p_jsy(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_jsy = '',
                    p_jsy_id = 0,
                    p_jsy_date = '1970-01-01',
                    p_jsy_time = '00:00:00',
                    reject = ?,
                    sign_p_jsy = ''
                where
                    id = ?
            """.trimIndent(), body["reject"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }
}
package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

/**
 * 一体化作业申请单
 */
@RestController
@RequestMapping("/api/journal02")
class Journal02RejectController {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /**
     * 驳回（通用）
     */
    @RequestMapping("/{id}/reject", method = [RequestMethod.PUT])
    fun reject(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    reject = ?,
                    reject_by = ?,
                    reject_by_id = ?
                where
                    id = ?
            """.trimIndent(), body["reject"], body["reject_by"], body["reject_by_id"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    // 驳回申请列表
    @RequestMapping("/reject/", method = [RequestMethod.GET])
    fun list(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02 where reject != '' order by id desc limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @RequestMapping("/{id}/reject/p_zbsz", method = [RequestMethod.PUT])
    fun p_zbsz(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
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
                    sign_p_jsy = '',
                    p_jsy_content = '',
                    p_jsy_bz = '',
                    p_jsy_qc = '',
                    sign_p_jsy_bz = null,
                    sign_p_jsy_qc = null,
                    p_dd = '',
                    p_dd_id = 0,
                    p_dd_date = '1970-01-01',
                    p_dd_time = '00:00:00',
                    sign_p_dd = null,
                    p_zbsz = '',
                    p_zbsz_id = 0,
                    p_zbsz_date = '1970-01-01',
                    p_zbsz_time = '00:00:00',
                    sign_p_zbsz = null,
                    reject = ?
                where
                    id = ?
            """.trimIndent(), body["reject"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @RequestMapping("/{id}/reject/p_dd", method = [RequestMethod.PUT])
    fun p_dd(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
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
                    sign_p_jsy = '',
                    p_jsy_content = '',
                    p_jsy_bz = '',
                    p_jsy_qc = '',
                    sign_p_jsy_bz = null,
                    sign_p_jsy_qc = null,
                    p_dd = '',
                    p_dd_id = 0,
                    p_dd_date = '1970-01-01',
                    p_dd_time = '00:00:00',
                    sign_p_dd = null
                where
                    id = ?
            """.trimIndent(), body["reject"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    // 质检驳回
    @RequestMapping("/{id}/reject/p_jsy_qc", method = [RequestMethod.PUT])
    fun p_jsy_qc(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
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
                    p_jsy_content = '',
                    p_jsy_bz = '',
                    p_jsy_qc = '',
                    reject = ?,
                    sign_p_jsy = '',
                    sign_p_jsy_bz = null,
                    sign_p_jsy_qc = null
            """.trimIndent(), body["reject"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    // 班组驳回
    @RequestMapping("/{id}/reject/p_jsy_bz", method = [RequestMethod.PUT])
    fun p_jsy_bz(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
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
                    p_jsy_content = '',
                    p_jsy_bz = '',
                    p_jsy_qc = '',
                    reject = ?,
                    sign_p_jsy = null,
                    sign_p_jsy_bz = null
            """.trimIndent(), body["reject"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp;
    }

    // 技术员驳回
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
                    sign_p_jsy = null
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

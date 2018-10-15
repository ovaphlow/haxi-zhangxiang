package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /**
     * 查询
     */
    @RequestMapping("/filter/", method = [RequestMethod.POST])
    fun filter(@RequestBody map: Map<String, Any>): MutableMap<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    position(? in dept) = 1
                    and position(? in group_sn) = 1
                    and concat(date_begin,
                    ' ',
                    time_begin) between concat(?, ' ', ?) and concat(?, ' ', ?)
                    and position(? in content) = 1
                    and position(? in content_detail) > 0
                    and position(? in p_yq_xdc) = 1
                    and position(? in p_yq_jcw) = 1
                    and reject = ''
                order by date_begin desc, time_begin desc
                limit 2000
            """.trimIndent(), map["dept"], map["group"], map["date_begin"], map["time_begin"],
                    map["date_end"], map["time_end"],
                    map["content"],map["content_detail"], map["p_xdc"], map["p_jcw"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度销记签字 */
    @RequestMapping("/{id}/verify/sign", method = [RequestMethod.PUT])
    fun updateVerifySign(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify = ? where id = ?
            """.trimIndent(), body["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度销记 */
    @RequestMapping("/verify/{id}", method = [RequestMethod.PUT])
    fun updateVerify(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    verify = ?,
                    verify_id = ?,
                    verify_date = now(),
                    verify_time = now(),
                    remark = ?,
                    sign_verify = ?
                where
                    id = ?
            """.trimIndent(), body["verify"], body["verify_id"], body["remark"], body["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 质检销记签字 */
    @RequestMapping("/{id}/verify/leader/qc", method = [RequestMethod.PUT])
    fun verifyLeaderQc(@PathVariable("id") id: Int, @RequestBody map: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader_qc = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderQc(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 班组销记签字 */
    @RequestMapping("/{id}/verify/leader/bz", method = [RequestMethod.PUT])
    fun updateVerifyLeaderBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader_bz = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderBz(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 作业负责人销记签字 */
    @RequestMapping("/{id}/verify/leader/sign", method = [RequestMethod.PUT])
    fun updateVerifyLeaderSign(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderSign(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 作业负责人销记 */
    @RequestMapping("/verify/leader/{id}", method = [RequestMethod.PUT])
    fun updateVerifyLeader(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    date_begin = ?,
                    time_begin = ?,
                    date_end = ?,
                    time_end = ?,
                    verify_report = ?,
                    verify_leader = ?,
                    verify_leader_id = ?,
                    verify_leader_date = ?,
                    verify_leader_time = ?,
                    remark = ?,
                    sign_verify_leader = ?
                where
                    id = ?
            """.trimIndent(), body["date_begin"], body["time_begin"], body["date_end"], body["time_end"],
                    body["verify_report"], body["verify_leader"], body["verify_leader_id"],
                    body["date_end"], body["time_end"], body["remark"], body["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeader(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度签字 */
    @RequestMapping("/{id}/dd", method = [RequestMethod.PUT])
    fun updateDD(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_dd = ?,
                    p_dd_id = ?,
                    p_dd_date = now(),
                    p_dd_time = now(),
                    sign_p_dd = ?
                where
                    id = ?
            """.trimIndent(), map["p_dd"], map["p_dd_id"], map["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 值班所长签字 */
    @RequestMapping("/{id}/zbsz", method = [RequestMethod.PUT])
    fun updateZBSZ(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_zbsz = ?,
                    p_zbsz_id = ?,
                    p_zbsz_date = now(),
                    p_zbsz_time = now(),
                    sign_p_zbsz = ?
                where
                    id = ?
            """.trimIndent(), map["p_zbsz"], map["p_zbsz_id"], map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateZBSZ(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 技术员后班组签字 */
    @RequestMapping("/{id}/jsy/bz", method = [RequestMethod.PUT])
    fun updateJsyBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_p_jsy_bz = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateJsyBz(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }
}

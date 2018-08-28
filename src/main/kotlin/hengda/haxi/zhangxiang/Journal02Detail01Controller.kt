package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/journal02")
class Journal02Detail01Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /* 子帐单01计数 */
    @RequestMapping("/{masterId}/01/qty", method = [RequestMethod.GET])
    fun detail01Quantity(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal02_01 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单01：质检 */
    @RequestMapping("/{masterId}/01/{id}/qc", method = [RequestMethod.PUT])
    fun update01Qc(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_01 set qc = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["qc"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单01：班组 */
    @RequestMapping("/{masterId}/01/{id}/p_bz", method = [RequestMethod.PUT])
    fun update01Pbz(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_01 set watcher = ?, watcher_group = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["watcher"], body["watcher_group"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 保存同一账单下所有01子帐单的表头 */
    @RequestMapping("/{masterId}/01/", method = [RequestMethod.PUT])
    fun update01(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02_01
                set
                    subject = ?,
                    approval_sn = ?,
                    train_sn = ?,
                    date = ?
                where
                    master_id = ?
            """.trimIndent(), map["subject"], map["approval_sn"], map["train_sn"], map["date"], masterId)
            /* map["id"] = masterId */
            /* mapper.update01(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单01：删除 */
    @RequestMapping("/{masterId}/01/{id}", method = [RequestMethod.DELETE])
    fun remove01(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                delete from journal02_01 where master_id = ? and id = ?
            """.trimIndent(), masterId, id)
            /* mapper.remove01(masterId, id) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单01：添加 */
    @RequestMapping("/{id}/01/", method = [RequestMethod.POST])
    fun save01(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                insert into
                    journal02_01
                set
                    uuid = uuid(),
                    master_id = ?,
                    subject = ?,
                    approval_sn = ?,
                    train_sn = ?,
                    date = ?,
                    carriage = ?,
                    carriage_subject = ?,
                    time_begin = ?,
                    time_end = ?,
                    result = ?,
                    report = ?,
                    dept = ?,
                    executor = ?,
                    remark = ?
            """.trimIndent(), id, map["subject"], map["approval_sn"], map["train_sn"], map["date"],
                    map["carriage"], map["carriage_subject"], map["time_begin"], map["time_end"],
                    map["result"], map["report"], map["dept"], map["executor"], map["remark"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单01列表 */
    @RequestMapping("/{id}/01/", method = [RequestMethod.GET])
    fun list01(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02_01 where master_id = ?
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }
}
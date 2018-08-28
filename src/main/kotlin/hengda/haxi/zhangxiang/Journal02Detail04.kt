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
class Journal02Detail04Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /**
     * 子帐单04：质检确认
     */
    @RequestMapping("/{masterId}/04/{id}/qc", method = [RequestMethod.PUT])
    fun update04Qc(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_04 set qc = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["qc"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单04：班组确认
     */
    @RequestMapping("/{masterId}/04/{id}/p_bz", method = [RequestMethod.PUT])
    fun update04Pbz(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_04 set watcher = ?, watcher_group = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["watcher"], body["watcher_group"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 保存同一账单下所有04子帐单的表头 */
    @RequestMapping("/{masterId}/04/", method = [RequestMethod.PUT])
    fun update04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02_04
                set
                    subject = ?,
                    software_version_new = ?,
                    software_version_old = ?,
                    approval_sn = ?,
                    train = ?,
                    date = ?
                where
                    master_id = ?
            """.trimIndent(), map["subject"], map["software_version_new"], map["software_version_old"],
                    map["approval_sn"], map["train"], map["date"], masterId)
            /* map["masterId"] = masterId */
            /* mapper.update04(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单04：删除 */
    @RequestMapping("/{masterId}/04/{id}", method = [RequestMethod.DELETE])
    fun remove04(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                delete from journal02_04 where master_id = ? and id = ?
            """.trimIndent(), masterId, id)
            /* mapper.remove04(masterId, id) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单04：添加 */
    @RequestMapping("/{masterId}/04/", method = [RequestMethod.POST])
    fun save04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                insert into
                    journal02_04
                set
                    uuid = uuid(),
                    master_id = ?,
                    subject = ?,
                    software_version_new = ?,
                    software_version_old = ?,
                    approval_sn = ?,
                    train = ?,
                    date = ?,
                    carriage = ?,
                    time_begin = ?,
                    time_end = ?,
                    dept = ?,
                    operator = ?,
                    remark = ?
            """.trimIndent(), masterId, map["subject"], map["software_version_new"], map["software_version_old"],
                    map["approval_sn"], map["train"], map["date"],
                    map["carriage"], map["time_begin"], map["time_end"], map["dept"], map["operator"], map["remark"])
            /* map["masterId"] = masterId */
            /* mapper.save04(map) */
            /* mapper.updateTag("加装改造（软件升级）记录单", masterId) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单04计数 */
    @RequestMapping("/{masterId}/04/qty", method = [RequestMethod.GET])
    fun detail04Quantity(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal02_04 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单04列表 */
    @RequestMapping("/{masterId}/04/", method = [RequestMethod.GET])
    fun list04(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02_04 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

}
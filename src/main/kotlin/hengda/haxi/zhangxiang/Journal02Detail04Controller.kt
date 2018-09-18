package hengda.haxi.zhangxiang

import hengda.haxi.zhangxiang.model.Journal02Detail04
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Detail04Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @Autowired
    private val service: Journal02Service? = null

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

    /**
     * 保存同一账单下所有04子帐单的表头
     * 20180918 停用
     */
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
    @PostMapping("/{masterId}/04/")
    fun save04(@PathVariable("masterId") masterId: Int, @RequestBody body: Journal02Detail04): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            body.master_id = masterId
            if (body.carriage_01 == true) service!!.save2Detail04("01", body)
            if (body.carriage_02 == true) service!!.save2Detail04("02", body)
            if (body.carriage_03 == true) service!!.save2Detail04("03", body)
            if (body.carriage_04 == true) service!!.save2Detail04("04", body)
            if (body.carriage_05 == true) service!!.save2Detail04("05", body)
            if (body.carriage_06 == true) service!!.save2Detail04("06", body)
            if (body.carriage_07 == true) service!!.save2Detail04("07", body)
            if (body.carriage_08 == true) service!!.save2Detail04("08", body)

            jdbc!!.update("""
                update
                    journal02
                set
                    time_begin = ?,
                    time_end = ?
                where
                    id = ?
                limit 1
            """.trimIndent(), body.time_begin, body.time_end, masterId)
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
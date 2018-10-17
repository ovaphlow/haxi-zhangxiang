package hengda.haxi.zhangxiang

import hengda.haxi.zhangxiang.model.Journal02Detail01
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Detail01Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Detail01Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @Autowired
    private val service: Journal02Service? = null

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

    @PutMapping("/detail/01/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02_01
                set
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
                    watcher = ?,
                    watcher_group = ?,
                    qc = ?,
                    remark = ?
                where
                    id = ?
            """.trimIndent(), body["subject"], body["approval_sn"], body["train_sn"], body["date"],
                    body["carriage"], body["carriage_subject"], body["time_begin"], body["time_end"],
                    body["result"], body["report"], body["dept"], body["executor"],
                    body["watcher"], body["watcher_group"], body["qc"], body["remark"], id)
            jdbc.update("""
                update
                    journal02
                set
                    time_begin = ?,
                    time_end = ?
                where
                    id = (select master_id from journal02_01 where id = ?)
                limit 1
            """.trimIndent(), body["time_begin"], body["time_end"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @GetMapping("/detail/01/{id}")
    fun get(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select * from journal02_01 where id = ? limit 1
            """.trimIndent(), id)
        } catch(e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单01：添加 */
    @RequestMapping("/{id}/01/", method = [RequestMethod.POST])
    fun save01(@PathVariable("id") id: Int, @RequestBody body: Journal02Detail01): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            body.master_id = id
            if (body.carriage_01 == true) service!!.save2Detail01("01", body)
            if (body.carriage_02 == true) service!!.save2Detail01("02", body)
            if (body.carriage_03 == true) service!!.save2Detail01("03", body)
            if (body.carriage_04 == true) service!!.save2Detail01("04", body)
            if (body.carriage_05 == true) service!!.save2Detail01("05", body)
            if (body.carriage_06 == true) service!!.save2Detail01("06", body)
            if (body.carriage_07 == true) service!!.save2Detail01("07", body)
            if (body.carriage_08 == true) service!!.save2Detail01("08", body)

            jdbc!!.update("""
                update
                    journal02
                set
                    time_begin = ?,
                    time_end = ?
                where
                    id = ?
                limit 1
            """.trimIndent(), body.time_begin, body.time_end, id)
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
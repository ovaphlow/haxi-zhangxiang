package hengda.haxi.zhangxiang

import hengda.haxi.zhangxiang.model.Journal02Detail02
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Detail02Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @Autowired
    private val service: Journal02Service? = null

    /* 子帐单02：值班干部确认 */
    @RequestMapping("/{masterId}/02/{id}/p_jsy", method = [RequestMethod.PUT])
    fun update02Pjsy(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_02 set duty_officer = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["duty_officer"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单02：质检确认
     */
    @RequestMapping("/{masterId}/02/{id}/qc", method = [RequestMethod.PUT])
    fun update02Qc(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_02 set p_bjgnsy = ?, qc = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["p_bjgnsy"], body["qc"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["messsage"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单02：班组确认
     */
    @RequestMapping("/{masterId}/02/{id}/p_bz", method = [RequestMethod.PUT])
    fun update02Pbz(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_02 set leader = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["leader"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单02：删除 */
    @RequestMapping("/{masterId}/02/{id}", method = [RequestMethod.DELETE])
    fun remove02(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                delete from journal02_02 where master_id = ? and id = ?
            """.trimIndent(), masterId, id)
            /* mapper.remove02(masterId, id) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    @PutMapping("/detail/02/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02_02
                set
                    name = ?,
                    train = ?,
                    carriage = ?,
                    position = ?,
                    date = ?,
                    time = ?,
                    reason = ?,
                    p_ljbs = ?,
                    p_gywj = ?,
                    component_sn_old = ?,
                    component_sn_new = ?,
                    p_bjaz = ?,
                    operator = ?,
                    leader = ?,
                    p_bjgnsy = ?,
                    qc = ?,
                    duty_officer = ?
                where
                    id = ?
            """.trimIndent(), body["name"], body["train"], body["carriage"], body["position"],
                    body["date"], body["time"], body["reason"],
                    body["p_ljbs"], body["p_gywj"], body["component_sn_old"], body["component_sn_new"],
                    body["p_bjaz"], body["operator"], body["leader"],
                    body["p_bjgnsy"], body["qc"], body["duty_officer"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @GetMapping("/detail/02/{id}")
    fun get(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select * from journal02_02 where id = ? limit 1
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单02：添加
     */
    @PostMapping("/{masterId}/02/")
    fun save02(@PathVariable("masterId") masterId: Int, @RequestBody body: Journal02Detail02): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            body.master_id = masterId
            if (body.carriage_01 == true) service!!.save2Detail02("01", body)
            if (body.carriage_02 == true) service!!.save2Detail02("02", body)
            if (body.carriage_03 == true) service!!.save2Detail02("03", body)
            if (body.carriage_04 == true) service!!.save2Detail02("04", body)
            if (body.carriage_05 == true) service!!.save2Detail02("05", body)
            if (body.carriage_06 == true) service!!.save2Detail02("06", body)
            if (body.carriage_07 == true) service!!.save2Detail02("07", body)
            if (body.carriage_08 == true) service!!.save2Detail02("08", body)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单02计数 */
    @RequestMapping("/{masterId}/02/qty", method = [RequestMethod.GET])
    fun detail02Quantity(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal02_02 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单02列表 */
    @RequestMapping("/{masterId}/02/", method = [RequestMethod.GET])
    fun list02(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02_02 where master_id = ?
            """.trimIndent(), masterId)
            /* resp["content"] = mapper.list02(masterId) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }
}
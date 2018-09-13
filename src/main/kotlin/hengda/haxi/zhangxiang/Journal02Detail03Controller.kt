package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Detail03Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /* 子帐单03：值班干部确认 */
    @RequestMapping("/{masterId}/03/{id}/p_jsy", method = [RequestMethod.PUT])
    fun update03Pjsy(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_03 set duty_officer = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["duty_officer"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单03：质检确认
     */
    @RequestMapping("/{masterId}/03/{id}/qc", method = [RequestMethod.PUT])
    fun update03Qc(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_03 set p_bjgnsy = ?, qc = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["p_bjgnsy"], body["qc"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 子帐单03：班组确认
     */
    @RequestMapping("/{masterId}/03/{id}/p_bz", method = [RequestMethod.PUT])
    fun update03Pbz(
            @PathVariable("masterId") masterId: Int,
            @PathVariable("id") id: Int,
            @RequestBody body: Map<String, Any>
    ): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02_03 set leader = ? where id = ? and master_id = ? limit 1
            """.trimIndent(), body["leader"], id, masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单03：删除 */
    @RequestMapping("/{masterId}/03/{id}", method = [RequestMethod.DELETE])
    fun remove03(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                delete from journal02_03 where master_id = ? and id = ?
            """.trimIndent(), masterId, id)
            /* mapper.remove03(masterId, id) */
            /* r["status"] = 200 */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 子帐单03计数 */
    @RequestMapping("/{masterId}/03/qty", method = [RequestMethod.GET])
    fun detail03Quantity(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal02_03 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单03列表 */
    @RequestMapping("/{masterId}/03/", method = [RequestMethod.GET])
    fun list03(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02_03 where master_id = ?
            """.trimIndent(), masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    @PutMapping("/detail/03/{id}")
    fun put(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02_03
                set
                    name = ?,
                    train = ?,
                    carriage = ?,
                    position = ?,
                    date = ?,
                    time = ?,
                    production_date = ?,
                    reason = ?,
                    p_gywj = ?,
                    p_ljbs = ?,
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
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @GetMapping("/detail/03/{id}")
    fun get(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select * from journal02_03 where id = ? limit 1
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 子帐单03：添加 */
    @RequestMapping("/{masterId}/03/", method = [RequestMethod.POST])
    fun save03(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                insert into
                    journal02_03
                set
                    uuid = uuid(),
                    master_id = ?,
                    name = ?,
                    train = ?,
                    carriage = ?,
                    position = ?,
                    date = ?,
                    time = ?,
                    production_date = ?,
                    reason = ?,
                    p_gywj = ?,
                    p_ljbs = ?,
                    component_sn_old = ?,
                    component_sn_new = ?,
                    p_bjaz = ?,
                    operator = ?
            """.trimIndent(), masterId, map["name"], map["train"], map["carriage"], map["position"],
                    map["date"], map["time"], map["production_date"], map["reason"],
                    map["p_gywj"], map["p_ljbs"], map["component_sn_old"], map["component_sn_new"],
                    map["p_bjaz"], map["operator"])
            /* map["masterId"] = masterId */
            /* mapper.save03(map) */
            // mapper.updateTag("关键配件更换记录表", masterId)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }
}
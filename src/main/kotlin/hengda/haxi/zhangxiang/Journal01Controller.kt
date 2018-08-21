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

/* todo: 移除MyBatis，加入Spring JDBC */

@RestController
@RequestMapping("/api/journal01")
class Journal01Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal01Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @Autowired
    lateinit var mapper: Journal01Mapper

    @RequestMapping("/todo/return", method = [RequestMethod.GET])
    fun todoReturn(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal01 where borrow_id != 0 and return_by_id = 0
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @RequestMapping("/todo/borrow", method = [RequestMethod.GET])
    fun todoBorrow(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select count(*) as qty from journal01 where borrow_date <= '0001-01-01'
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @RequestMapping("/stats", method = [RequestMethod.GET])
    fun stats(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select applicant as name, count(*) as value from journal01 group by applicant order by value desc
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 查询 */
    @RequestMapping("/filter", method = [RequestMethod.POST])
    fun filter(@RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.filter(map)
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal01
                where
                    position(? in date) = 1
                    and position(? in dept) = 1
                    and position(? in applicant) = 1
            """.trimIndent(), map["date"], map["dept"], map["user"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 列表 */
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun list(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.list()
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal01
                order by
                    id desc
                limit 1000
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 返还 */
    @RequestMapping("/return/{id}", method = arrayOf(RequestMethod.PUT))
    fun returnSubmit(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            map["id"] = id
//            mapper.returnSubmit(map)
            jdbc!!.update("""
                update
                    journal01
                set
                    return_name = ?,
                    return_by = ?,
                    return_by_id = ?,
                    return_date = now(),
                    return_time = now(),
                    remark = ?
                where
                    id = ?
            """.trimIndent(), map["return_name"], map["return_by"], map["return_by_id"], map["remark"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 普通用户未返还列表 */
    @RequestMapping("/return/user/{id}", method = arrayOf(RequestMethod.GET))
    fun listUserReturn(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.listUserReturn(id)
            resp["content"] = jdbc!!.queryForList("""
                select * from journal01 where applicant_id = ? and return_by_id != 0
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 待返还列表 */
    @RequestMapping("/return", method = arrayOf(RequestMethod.GET))
    fun listReturn(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.listReturn()
            resp["content"] = jdbc!!.queryForList("""
                select
                    id, uuid,
                    date, time, quantity, applicant, applicant_id, dept,
                    borrow_date, borrow_time, borrow, borrow_id,
                    remark
                from
                    journal01
                where
                    borrow_id != 0
                    and return_by_id = 0
                order by
                    id desc
                limit 1000
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 待发放列表
     * todo: 优化地址
     */
    @RequestMapping("/admin", method = arrayOf(RequestMethod.GET))
    fun listByAdmin(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.listByAdmin()
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
                from
                    journal01 as j
                where
                    borrow_date <= '0001-01-01'
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 借出人待发放列表 */
    @RequestMapping("/applicant/{id}", method = arrayOf(RequestMethod.GET))
    fun listByApplicant(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.listByApplicant(id)
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
                from
                    journal01 as j
                where
                    applicant_id = ?
                    and borrow_id = 0
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 发放 */
    @RequestMapping("/{id}/borrow", method = arrayOf(RequestMethod.PUT))
    fun borrow(@PathVariable("id") id: Int, @RequestBody map: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            mapper.borrow(map["borrow"].toString(), map["borrowId"].toString().toInt(), id)
            jdbc!!.update("""
                update
                    journal01
                set
                    borrow_date = now(),
                    borrow_time = now(),
                    borrow = ?,
                    borrow_id = ?
                where
                    id = ?
            """.trimIndent(), map["borrow"], map["borrowId"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 单条信息 */
    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun info(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            resp["content"] = mapper.info(id)
            resp["content"] = jdbc!!.queryForMap("""
                select * from journal01 where id = ?
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 新增申请 */
    @RequestMapping("/", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody map: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            mapper.save(map)
            jdbc!!.update("""
                insert into
                    journal01
                set
                    uuid = uuid(),
                    date = now(),
                    time = now(),
                    quantity = ?,
                    applicant_id = ?,
                    applicant = ?,
                    dept = ?,
                    remark = ?
            """.trimIndent(), map["quantity"], map["applicantId"], map["applicant"], map["dept"], map["remark"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }
}

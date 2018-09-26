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
@RequestMapping("/api/journal01")
class Journal01Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal01Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    @Autowired
    private val repos: Journal01Repos? = null

    @RequestMapping("/todo/return", method = [RequestMethod.GET])
    fun todoReturn(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = repos!!.returnQty()
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
            resp["content"] = repos!!.reviewQty()
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
            resp["content"] = repos!!.stats()
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 查询 */
    @RequestMapping("/filter", method = [RequestMethod.POST])
    fun filter(@RequestBody body: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = repos!!.filter(body)
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
            resp["content"] = repos!!.list()
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 返还 */
    @RequestMapping("/return/{id}", method = arrayOf(RequestMethod.PUT))
    fun returnSubmit(@PathVariable("id") id: Int, @RequestBody body: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            body["id"] = id
            repos!!.returnHandler(body)
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
            resp["content"] = repos!!.returnListByUser(id)
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
            resp["content"] = repos!!.returnList()
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
            resp["content"] = repos!!.reviewList()
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
            resp["content"] = repos!!.listByBorrower(id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 发放 */
    @RequestMapping("/{id}/borrow", method = arrayOf(RequestMethod.PUT))
    fun borrow(@PathVariable("id") id: Int, @RequestBody body: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            body["id"] = id
            repos!!.borrow(body)
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
            resp["content"] = repos!!.get(id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 新增申请 */
    @RequestMapping("/", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            repos!!.save(body)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }
}

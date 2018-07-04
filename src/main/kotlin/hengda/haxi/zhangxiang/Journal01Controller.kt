package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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
    lateinit var mapper: Journal01Mapper

    @RequestMapping("/filter", method = arrayOf(RequestMethod.POST))
    fun filter(@RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.filter(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun list(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.list()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/return/{id}", method = arrayOf(RequestMethod.PUT))
    fun returnSubmit(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            map["id"] = id
            mapper.returnSubmit(map)
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "服务器错误。"
        }
        return r
    }

    // 普通用户未返还列表
    @RequestMapping("/return/user/{id}", method = arrayOf(RequestMethod.GET))
    fun listUserReturn(@PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            r["content"] = mapper.listUserReturn(id)
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "服务器错误。"
        }
        return r
    }

    @RequestMapping("/return", method = arrayOf(RequestMethod.GET))
    fun listReturn(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listReturn()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/admin", method = arrayOf(RequestMethod.GET))
    fun listByAdmin(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listByAdmin()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/applicant/{id}", method = arrayOf(RequestMethod.GET))
    fun listByApplicant(@PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listByApplicant(id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/borrow", method = arrayOf(RequestMethod.PUT))
    fun borrow(@PathVariable("id") id: Int, @RequestBody map: Map<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.borrow(map["borrow"].toString(), map["borrowId"].toString().toInt(), id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun info(@PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.info(id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody map: Map<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.save(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }
}
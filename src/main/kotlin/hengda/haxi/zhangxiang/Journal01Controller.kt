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
    } catch(e: Exception) {
      logger.error("{}", e)
      r["message"] = "检索数据失败。"
    }
    return r
  }

  @RequestMapping("/", method = arrayOf(RequestMethod.GET))
  fun list(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.list()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
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

  @RequestMapping("/return", method = arrayOf(RequestMethod.GET))
  fun listReturn(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listReturn()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/admin", method = arrayOf(RequestMethod.GET))
  fun listByAdmin(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listByAdmin()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/applicant/{id}", method = arrayOf(RequestMethod.GET))
  fun listByApplicant(@PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listByApplicant(id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/{id}/borrow", method = arrayOf(RequestMethod.PUT))
  fun borrow(@PathVariable("id") id: Int, @RequestBody map: Map<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.borrow(map["borrow"].toString(), map["borrowId"].toString().toInt(), id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
  fun info(@PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.info(id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/", method = arrayOf(RequestMethod.POST))
  fun save(@RequestBody map: Map<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.save(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }
}
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
@RequestMapping("/api/journal02")
class Journal02Controller {

  val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

  @Autowired
  lateinit var mapper: Journal02Mapper

  @RequestMapping("/dd/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateDD(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateDD(map)
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/dd/", method = arrayOf(RequestMethod.GET))
  fun listDD(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listDD()
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/zbsz/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateZBSZ(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateZBSZ(map)
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "提交数据失败。"
    }
    return response
  }
}

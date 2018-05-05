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
@RequestMapping("/api/user")
class UserController {

  val logger: Logger = LoggerFactory.getLogger(UserController::class.java)

  @Autowired
  lateinit var mapper: UserMapper

  @RequestMapping("/dept/{id}", method = arrayOf(RequestMethod.GET))
  fun listUserByDept(@PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listUserByDept(id)
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
  fun login(@RequestBody map: Map<String, String>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.login(map)
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
  fun test(): String {
    logger.info("1123")
    return "hello w"
  }
}
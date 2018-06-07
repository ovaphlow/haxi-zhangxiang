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

  @RequestMapping("/stats", method = arrayOf(RequestMethod.GET))
  fun stats(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.stats()
      response["status"] = 200
    } catch (e: Exception) {
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/filter/", method = arrayOf(RequestMethod.POST))
  fun filter(@RequestBody map: Map<String, Any>): MutableMap<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.filter(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/verify/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateVerify(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateVerify(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/verify/", method = arrayOf(RequestMethod.GET))
  fun listVerify(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listVerify()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/verify/leader/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateVerifyLeader(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateVerifyLeader(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/verify/leader/", method = arrayOf(RequestMethod.GET))
  fun listVerifyLeader(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listVerifyLeader()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/dd/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateDD(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateDD(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
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
      logger.error("{}", e)
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
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/zbsz/", method = arrayOf(RequestMethod.GET))
  fun listZBSZ(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listZBSZ()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/qc/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateJsyQc(@PathVariable("id")id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateJsyQc(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/qc/{qc}", method = arrayOf(RequestMethod.GET))
  fun listJsyQc(@PathVariable("qc") qc: String): Map<String, Any> {
    logger.info(qc)
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listJsyQc(qc)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/bz/{bzId}", method = arrayOf(RequestMethod.PUT))
  fun updateJsyBz(@PathVariable("bzId") bzId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = bzId
      mapper.updateJsyBz(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/bz/{bz}", method = arrayOf(RequestMethod.GET))
  fun listJsyBz(@PathVariable("bz") bz: String): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listJsyBz(bz)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/{id}/content", method = arrayOf(RequestMethod.PUT))
  fun updateJSYContent(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "messsage" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateJSYContent(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/{id}", method = arrayOf(RequestMethod.PUT))
  fun updateJSY(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = id
      mapper.updateJSY(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/jsy/", method = arrayOf(RequestMethod.GET))
  fun listJSY(): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.listJSY()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
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

  @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
  fun get(@PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.get(id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.PUT))
  fun update04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["masterId"] = masterId
      mapper.update04(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/04/{id}", method = arrayOf(RequestMethod.DELETE))
  fun remove04(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.remove04(masterId, id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.POST))
  fun save04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["masterId"] = masterId
      mapper.save04(map)
      mapper.updateTag("加装改造（软件升级）记录单", masterId)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.GET))
  fun list04(@PathVariable("masterId") masterId: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.list04(masterId)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/03/{id}", method = arrayOf(RequestMethod.DELETE))
  fun remove03(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.remove03(masterId, id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/03/", method = arrayOf(RequestMethod.GET))
  fun list03(@PathVariable("masterId") masterId: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.list03(masterId)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/03/", method = arrayOf(RequestMethod.POST))
  fun save03(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["masterId"] = masterId
      mapper.save03(map)
      mapper.updateTag("关键配件更换记录表", masterId)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/02/{id}", method = arrayOf(RequestMethod.DELETE))
  fun remove02(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.remove02(masterId, id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/02/", method = arrayOf(RequestMethod.POST))
  fun save02(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var res: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["masterId"] = masterId
      mapper.save02(map)
      mapper.updateTag("一般配件更换记录表", masterId)
      res["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      res["message"] = "提交数据失败。"
    }
    return res
  }

  @RequestMapping("/{masterId}/02/", method = arrayOf(RequestMethod.GET))
  fun list02(@PathVariable("masterId") masterId: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.list02(masterId)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "检索数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/01/", method = arrayOf(RequestMethod.PUT))
  fun update01(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["id"] = masterId
      mapper.update01(map)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{masterId}/01/{id}", method = arrayOf(RequestMethod.DELETE))
  fun remove01(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      mapper.remove01(masterId, id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{id}/01/", method = arrayOf(RequestMethod.POST))
  fun save01(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      map["master_id"] = id
      mapper.save01(map)
      mapper.updateTag("一般部件普查记录单", id)
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }

  @RequestMapping("/{id}/01/", method = arrayOf(RequestMethod.GET))
  fun list01(@PathVariable("id") id: Int): Map<String, Any> {
    var response: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
    try {
      response["content"] = mapper.list01(id)
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
      response["content"] = mapper.lastId()
      response["status"] = 200
    } catch (e: Exception) {
      logger.error("{}", e)
      response["message"] = "提交数据失败。"
    }
    return response
  }
}

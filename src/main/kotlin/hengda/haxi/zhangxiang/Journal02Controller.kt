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
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.stats()
            r["status"] = 200
        } catch (e: Exception) {
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/filter/", method = arrayOf(RequestMethod.POST))
    fun filter(@RequestBody map: Map<String, Any>): MutableMap<String, Any> {
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

    @RequestMapping("/{id}/verify/sign", method = arrayOf(RequestMethod.PUT))
    fun updateVerifySign(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerifySign(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/{id}", method = arrayOf(RequestMethod.PUT))
    fun updateVerify(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerify(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/", method = arrayOf(RequestMethod.GET))
    fun listVerify(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listVerify()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/verify/leader/qc", method = arrayOf(RequestMethod.PUT))
    fun verifyLeaderQc(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerifyLeaderQc(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/leader/qc/{qc}", method = arrayOf(RequestMethod.GET))
    fun listVerifyLeaderQc(@PathVariable("qc") qc: String): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf(
                "content" to "",
                "message" to "",
                "status" to 500
        )
        try {
            r["content"] = mapper.listVerifyLeaderQc(qc)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/verify/leader/bz", method = arrayOf(RequestMethod.PUT))
    fun updateVerifyLeaderBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerifyLeaderBz(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/leader/bz/{bz}", method = arrayOf(RequestMethod.GET))
    fun listVerifyLeaderBz(@PathVariable("bz") bz: String): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listVerifyLeaderBz(bz)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/verify/leader/sign", method = arrayOf(RequestMethod.PUT))
    fun updateVerifyLeaderSign(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerifyLeaderSign(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/leader/{id}", method = arrayOf(RequestMethod.PUT))
    fun updateVerifyLeader(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateVerifyLeader(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/leader/{leader}", method = arrayOf(RequestMethod.GET))
    fun listVerifyByLeader(@PathVariable("leader") leader: String): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listVerifyByLeader(leader)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/verify/leader/", method = arrayOf(RequestMethod.GET))
    fun listVerifyLeader(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listVerifyLeader()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/dd", method = arrayOf(RequestMethod.PUT))
    fun updateDD(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateDD(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/dd/", method = arrayOf(RequestMethod.GET))
    fun listDD(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listDD()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/zbsz", method = arrayOf(RequestMethod.PUT))
    fun updateZBSZ(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateZBSZ(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/zbsz/", method = arrayOf(RequestMethod.GET))
    fun listZBSZ(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listZBSZ()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/jsy/qc", method = arrayOf(RequestMethod.PUT))
    fun updateJsyQc(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateJsyQc(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/jsy/qc/{qc}", method = arrayOf(RequestMethod.GET))
    fun listJsyQc(@PathVariable("qc") qc: String): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listJsyQc(qc)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/jsy/bz", method = arrayOf(RequestMethod.PUT))
    fun updateJsyBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        logger.info("{}", id)
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateJsyBz(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/jsy/bz/{bz}", method = arrayOf(RequestMethod.GET))
    fun listJsyBz(@PathVariable("bz") bz: String): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listJsyBz(bz)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/jsy/content", method = arrayOf(RequestMethod.PUT))
    fun updateJSYContent(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "messsage" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateJSYContent(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/jsy", method = arrayOf(RequestMethod.PUT))
    fun updateJSY(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = id
            mapper.updateJSY(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/jsy/", method = arrayOf(RequestMethod.GET))
    fun listJSY(): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.listJSY()
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

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun get(@PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.get(id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.PUT))
    fun update04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["masterId"] = masterId
            mapper.update04(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/04/{id}", method = arrayOf(RequestMethod.DELETE))
    fun remove04(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.remove04(masterId, id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.POST))
    fun save04(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["masterId"] = masterId
            mapper.save04(map)
            mapper.updateTag("加装改造（软件升级）记录单", masterId)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/04/", method = arrayOf(RequestMethod.GET))
    fun list04(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.list04(masterId)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/03/{id}", method = arrayOf(RequestMethod.DELETE))
    fun remove03(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.remove03(masterId, id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/03/", method = arrayOf(RequestMethod.GET))
    fun list03(@PathVariable("masterId") masterId: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.list03(masterId)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/03/", method = arrayOf(RequestMethod.POST))
    fun save03(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["masterId"] = masterId
            mapper.save03(map)
            mapper.updateTag("关键配件更换记录表", masterId)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/02/{id}", method = arrayOf(RequestMethod.DELETE))
    fun remove02(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.remove02(masterId, id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
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
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.list02(masterId)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "检索数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/01/", method = arrayOf(RequestMethod.PUT))
    fun update01(@PathVariable("masterId") masterId: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["id"] = masterId
            mapper.update01(map)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{masterId}/01/{id}", method = arrayOf(RequestMethod.DELETE))
    fun remove01(@PathVariable("masterId") masterId: Int, @PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            mapper.remove01(masterId, id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/01/", method = arrayOf(RequestMethod.POST))
    fun save01(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            map["master_id"] = id
            mapper.save01(map)
            mapper.updateTag("一般部件普查记录单", id)
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }

    @RequestMapping("/{id}/01/", method = arrayOf(RequestMethod.GET))
    fun list01(@PathVariable("id") id: Int): Map<String, Any> {
        var r: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            r["content"] = mapper.list01(id)
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
            r["content"] = mapper.lastId()
            r["status"] = 200
        } catch (e: Exception) {
            logger.error("{}", e)
            r["message"] = "提交数据失败。"
        }
        return r
    }
}

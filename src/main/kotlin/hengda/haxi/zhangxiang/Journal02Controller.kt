package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/journal02")
class Journal02Controller {

    val logger: Logger = LoggerFactory.getLogger(Journal02Controller::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /* 待处理任务计数：值班所长 */
    @RequestMapping(("/todo/p_zbsz"), method = [RequestMethod.GET])
    fun todoPzbsz(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02
                where
                    sign_p_dd is not null
                    and sign_p_zbsz is null
                    and reject = ''
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }


    /* 待处理任务计数：调度 */
    @RequestMapping("/todo/p_dd", method = [RequestMethod.GET])
    fun todoPdd(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            var qty = jdbc!!.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02 as j
                where
                    sign_p_dd is null
                    and sign_p_jsy is not null

                    and reject = ''
            """.trimIndent())
            var qty1 = jdbc.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02 as j
                where
                    sign_verify is null
                    and sign_verify_leader is not null
                    and (
                        ( p_jsy_content = '无要求' )
                        or ( sign_verify_leader_qc is not null )
                    )
                    and (
                        (
                            select
                                count(*)
                            from
                                journal02_02
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) = 0
                    )
                    and (
                        (
                            select
                                count(*)
                            from
                                journal02_03
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) = 0
                    )
                    and reject = ''
            """.trimIndent())
            resp["content"] = hashMapOf("qty" to qty["qty"], "qty1" to qty1["qty"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 待处理任务计数：质检 */
    @RequestMapping("/todo/qc/{qc}", method = [RequestMethod.GET])
    fun todoQc(@PathVariable("qc") qc: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
//            var qty = jdbc!!.queryForMap("""
//                select
//                    count(*) as qty
//                from
//                    journal02
//                where
//                    position('质检跟踪' in p_jsy_content) > 0
//                    and p_jsy_qc = ?
//                    and sign_p_jsy_bz is not null
//                    and sign_p_jsy_qc is null
//                    and reject = ''
//            """.trimIndent(), qc)
            var qty1 = jdbc!!.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02
                where
                    verify_leader_id > 0
                    and position('班组' in p_jsy_content) = 1
                    and sign_verify_leader_bz is not null
                    and sign_verify_leader_qc is null
                    and p_jsy_qc = ?
                    and reject = ''
            """.trimIndent(), qc)
//            resp["content"] = hashMapOf("qty" to qty["qty"], "qty1" to qty1["qty"])
            resp["content"] = hashMapOf("qty1" to qty1["qty"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 待处理任务计数：班组 */
    @RequestMapping("/todo/p_bz/{p_bz}", method = [RequestMethod.GET])
    fun todoPbz(@PathVariable("p_bz") p_bz: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            var qty = jdbc!!.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02
                where
                    position('班组' in p_jsy_content) > 0
                    and sign_p_zbsz is not null
                    and p_jsy_bz = ?
                    and sign_p_jsy_bz is null
                    and reject = ''
            """.trimIndent(), p_bz)
            var qty1 = jdbc.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02
                where
                    verify_leader_id > 0
                    and position('班组' in p_jsy_content) = 1
                    and sign_verify_leader_bz is null
                    and p_jsy_bz = ?
                    and reject = ''
            """.trimIndent(), p_bz)
            resp["content"] = hashMapOf("qty" to qty["qty"], "qty1" to qty1["qty"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    @RequestMapping("/todo/p_jsy", method = [RequestMethod.GET])
    fun todoPjsy(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            var qty = jdbc!!.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02 as j
                where
                    (
                        sign_p_jsy is null
                        or p_jsy_content = ''
                    )
                    and reject = ''
            """.trimIndent())
            var qty1 = jdbc.queryForMap("""
                select
                    count(*) as qty
                from
                    journal02 as j
                where
                    (
                        (
                            select
                                count(*)
                            from
                                journal02_02
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) > 0
                    ) or (
                        (
                            select
                                count(*)
                            from
                                journal02_03
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) > 0
                    )
                    and reject = ''
            """.trimIndent())
            resp["content"] = hashMapOf("qty" to qty["qty"], "qty1" to qty1["qty"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 按车组统计一体化作业数量 */
    @RequestMapping("/stats", method = [RequestMethod.GET])
    fun stats(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    group_sn as name, count(*) as value
                from
                    journal02
                group by
                    group_sn
            """.trimIndent())
        } catch (e: Exception) {
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 查询
     */
    @RequestMapping("/filter/", method = [RequestMethod.POST])
    fun filter(@RequestBody map: Map<String, Any>): MutableMap<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    position(? in dept) = 1
                    and position(? in group_sn) = 1
                    and concat(date_begin,
                    ' ',
                    time_begin) between concat(?, ' ', ?) and concat(?, ' ', ?)
                    and position(? in content) = 1
                    and position(? in content_detail) > 0
                    and position(? in p_yq_xdc) = 1
                    and position(? in p_yq_jcw) = 1
                    and reject = ''
                order by date_begin desc, time_begin desc
                limit 200
            """.trimIndent(), map["dept"], map["group"], map["date_begin"], map["time_begin"],
                    map["date_end"], map["time_end"],
                    map["content"],map["content_detail"], map["p_xdc"], map["p_jcw"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度销记签字 */
    @RequestMapping("/{id}/verify/sign", method = [RequestMethod.PUT])
    fun updateVerifySign(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify = ? where id = ?
            """.trimIndent(), body["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度销记 */
    @RequestMapping("/verify/{id}", method = [RequestMethod.PUT])
    fun updateVerify(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    verify = ?,
                    verify_id = ?,
                    verify_date = now(),
                    verify_time = now(),
                    remark = ?,
                    sign_verify = ?
                where
                    id = ?
            """.trimIndent(), body["verify"], body["verify_id"], body["remark"], body["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 调度销记列表
     */
    @RequestMapping("/verify/", method = [RequestMethod.GET])
    fun listVerify(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*,
                    (
                        select
                            count(*)
                        from
                            journal02_02
                        where
                            qc != ''
                            and duty_officer = ''
                            and master_id = j.id
                    ) as qty_verify_p_jsy_02,
                    (
                        select
                            count(*)
                        from
                            journal02_03
                        where
                            qc != ''
                            and duty_officer = ''
                            and master_id = j.id )
                    as qty_verify_p_jsy_03
                from
                    journal02 as j
                where
                    sign_verify is null
                    and sign_verify_leader is not null
                    and (
                        ( p_jsy_content = '无要求' )
                        or ( sign_verify_leader_qc is not null)
                    )
                    and (
                        (
                            select
                                count(*)
                            from
                                journal02_02
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) = 0
                    )
                    and (
                        (
                            select
                                count(*)
                            from
                                journal02_03
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) = 0
                    )
                    and reject = ''
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 技术员销记列表 */
    @RequestMapping("/verify/p_jsy", method = [RequestMethod.GET])
    fun verifyPjsy(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*,
                    (
                    select
                        count(*)
                    from
                        journal02_02
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_02,
                    (
                    select
                        count(*)
                    from
                        journal02_03
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_03
                from
                    journal02 as j
                where
                    (
                        (
                            select
                                count(*)
                            from
                                journal02_02
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) > 0
                    ) or (
                        (
                            select
                                count(*)
                            from
                                journal02_03
                            where
                                qc != '' and duty_officer = '' and master_id = j.id
                        ) > 0
                    )
                    and reject = ''
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 质检销记签字 */
    @RequestMapping("/{id}/verify/leader/qc", method = [RequestMethod.PUT])
    fun verifyLeaderQc(@PathVariable("id") id: Int, @RequestBody map: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader_qc = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderQc(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 质检销记列表 */
    @RequestMapping("/verify/leader/qc/{qc}", method = [RequestMethod.GET])
    fun listVerifyLeaderQc(@PathVariable("qc") qc: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    verify_leader_id > 0
                    and position('班组' in p_jsy_content) = 1
                    and sign_verify_leader_bz is not null
                    and sign_verify_leader_qc is null
                    and p_jsy_qc = ?
                    and reject = ''
            """.trimIndent(), qc)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 班组销记签字 */
    @RequestMapping("/{id}/verify/leader/bz", method = [RequestMethod.PUT])
    fun updateVerifyLeaderBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader_bz = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderBz(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 班组销记列表 */
    @RequestMapping("/verify/leader/bz/{bz}", method = [RequestMethod.GET])
    fun listVerifyLeaderBz(@PathVariable("bz") bz: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    verify_leader_id > 0
                    and position('班组' in p_jsy_content) = 1
                    and sign_verify_leader_bz is null
                    and p_jsy_bz = ?
                    and reject = ''
            """.trimIndent(), bz)
            /* resp["content"] = mapper.listVerifyLeaderBz(bz) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 作业负责人销记签字 */
    @RequestMapping("/{id}/verify/leader/sign", method = [RequestMethod.PUT])
    fun updateVerifyLeaderSign(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_verify_leader = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeaderSign(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 作业负责人销记 */
    @RequestMapping("/verify/leader/{id}", method = [RequestMethod.PUT])
    fun updateVerifyLeader(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    date_begin = ?,
                    time_begin = ?,
                    date_end = ?,
                    time_end = ?,
                    verify_report = ?,
                    verify_leader = ?,
                    verify_leader_id = ?,
                    verify_leader_date = ?,
                    verify_leader_time = ?,
                    remark = ?,
                    sign_verify_leader = ?
                where
                    id = ?
            """.trimIndent(), body["date_begin"], body["time_begin"], body["date_end"], body["time_end"],
                    body["verify_report"], body["verify_leader"], body["verify_leader_id"],
                    body["date_end"], body["time_end"], body["remark"], body["sign"], id)
            /* map["id"] = id */
            /* mapper.updateVerifyLeader(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 作业负责人销记列表 */
    @RequestMapping("/verify/leader/{id}", method = [RequestMethod.GET])
    fun listVerifyByLeader(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    leader_id = ?
                    and sign_p_zbsz is not null
                    and (
                        ( p_jsy_content = '无要求' )
                        or (
                            p_jsy_content != '无要求'
                            and sign_p_jsy_bz is not null
                        )
                    )
                    and sign_verify_leader is null
                    and reject = ''
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 调度签字 */
    @RequestMapping("/{id}/dd", method = [RequestMethod.PUT])
    fun updateDD(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_dd = ?,
                    p_dd_id = ?,
                    p_dd_date = now(),
                    p_dd_time = now(),
                    sign_p_dd = ?
                where
                    id = ?
            """.trimIndent(), map["p_dd"], map["p_dd_id"], map["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 调度确认列表 */
    @RequestMapping("/dd/", method = [RequestMethod.GET])
    fun listDD(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*
                from
                    journal02 as j
                where
                    sign_p_dd is null
                    and sign_p_jsy is not null
                    and reject = ''
                limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 值班所长签字 */
    @RequestMapping("/{id}/zbsz", method = [RequestMethod.PUT])
    fun updateZBSZ(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_zbsz = ?,
                    p_zbsz_id = ?,
                    p_zbsz_date = now(),
                    p_zbsz_time = now(),
                    sign_p_zbsz = ?
                where
                    id = ?
            """.trimIndent(), map["p_zbsz"], map["p_zbsz_id"], map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateZBSZ(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 值班所长确认 */
    @RequestMapping("/zbsz/", method = [RequestMethod.GET])
    fun listZBSZ(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    sign_p_dd is not null
                    and sign_p_zbsz is null
                    and reject = ''
                limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 质检签字
     * 20180912 停用
     */
    @RequestMapping("/{id}/jsy/qc", method = [RequestMethod.PUT])
    fun updateJsyQc(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update journal02 set sign_p_jsy_qc = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateJsyQc(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 技术员后质检确认列表
     * 20180912 停用
     */
    @RequestMapping("/jsy/qc/{qc}", method = [RequestMethod.GET])
    fun listJsyQc(@PathVariable("qc") qc: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    position('质检跟踪' in p_jsy_content) > 0
                    and p_jsy_qc = ?
                    and sign_p_jsy_bz is not null
                    and sign_p_jsy_qc is null
                    and reject = ''
            """.trimIndent(), qc)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 技术员后班组签字 */
    @RequestMapping("/{id}/jsy/bz", method = [RequestMethod.PUT])
    fun updateJsyBz(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update journal02 set sign_p_jsy_bz = ? where id = ?
            """.trimIndent(), map["sign"], id)
            /* map["id"] = id */
            /* mapper.updateJsyBz(map) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 技术员后班组确认列表 */
    @RequestMapping("/jsy/bz/{bz}", method = [RequestMethod.GET])
    fun listJsyBz(@PathVariable("bz") bz: String): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    position('班组' in p_jsy_content) > 0
                    and sign_p_zbsz is not null
                    and p_jsy_bz = ?
                    and sign_p_jsy_bz is null
                    and reject = ''
            """.trimIndent(), bz)
            /* resp["content"] = mapper.listJsyBz(bz) */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 技术员签字 */
    @RequestMapping("/{id}/jsy", method = [RequestMethod.PUT])
    fun updateJSY(@PathVariable("id") id: Int, @RequestBody map: MutableMap<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "", "status" to 500)
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    p_jsy = ?,
                    p_jsy_id = ?,
                    p_jsy_date = now(),
                    p_jsy_time = now(),
                    p_jsy_content = ?,
                    p_jsy_bz = ?,
                    p_jsy_qc = ?,
                    sign_p_jsy = ?
                where
                    id = ?
            """.trimIndent(), map["p_jsy"], map["p_jsy_id"].toString().toInt(),
            map["p_jsy_content"], map["p_jsy_bz"], map["p_jsy_qc"], map["sign"], id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /* 技术员确认列表 */
    @RequestMapping("/jsy/", method = [RequestMethod.GET])
    fun listJSY(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*
                from
                    journal02 as j
                where
                    (sign_p_jsy is null or p_jsy_content = '')
                    and reject = ''
                limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 指定用户审核或销记的申请单
     * 未测试
     */
    @GetMapping("/filter/user/{id}/flow")
    fun filterByUserFlow(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *,
                    timestampdiff(second, concat(date_end, ' ', time_end), now()) as diff
                from
                    journal02 as j
                where
                    (
                        p_jsy_id = ?
                        or p_dd_id = ?
                        or p_zbsz_id = ?
                        or verify_id = ?
                    )
                    and leader_id != ?
                order by diff desc
                limit 200
            """.trimIndent(), id, id, id, id, id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 指定用户申请单
     */
    @RequestMapping("/filter/user/{id}", method = [RequestMethod.GET])
    fun filterByUser(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select * from journal02 where leader_id = ? order by id desc limit 200
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 查询已完成申请单
     */
    @PostMapping("/filter/fin")
    fun filterFin(@RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*,
                    (
                    select
                        count(*)
                    from
                        journal02_02
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_02,
                    (
                    select
                        count(*)
                    from
                        journal02_03
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_03,
                    timestampdiff(second, concat(date_end, ' ', time_end), now()) as diff
                from
                    journal02 as j
                where
                    sign_verify is not null
                    and position(? in dept) > 0
                    and position(? in group_sn) > 0
                    and concat(date_begin,
                    ' ',
                    time_begin) between concat(?, ' ', ?) and concat(?, ' ', ?)
                order by
                    diff
                limit 200
            """.trimIndent(), body["dept"], body["train"], body["date_begin"], body["time_begin"],
                    body["date_end"], body["time_end"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 查询未完成申请单
     * 20180917 停用
     */
    @RequestMapping("/filter/notcomplete", method = [RequestMethod.POST])
    fun filterNotComplete(@RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    *
                from
                    journal02
                where
                    verify_id = 0
                    and sign_verify is null
                    and position(? in dept) = 1
                    and position(? in group_sn) = 1
                    and position(? in date_begin) = 1
                    and reject = ''
                order by date_begin
                limit 200
            """.trimIndent(), body["dept"], body["group"], body["date"])
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 首页置顶显示
     * 报警列表
     * 未测试
     */
    @GetMapping("/warning")
    fun warning(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*,
                    timestampdiff(second, concat(date_end, ' ', time_end), now()) as diff
                from
                    journal02 as j
                where
                    reject = ''
                    and timestampdiff(second, concat(date_end, ' ', time_end), now()) > 0
                    and sign_verify_leader is null
                order by
                    diff desc
                limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 首页显示列表
     * 默认只显示非报警状态的未完成项目
     * 包括检查值班干部带处理申请单计数和超期时间
     * 未测试
     */
    @GetMapping("/")
    fun list(): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForList("""
                select
                    j.*,
                    (
                    select
                        count(*)
                    from
                        journal02_02
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_02,
                    (
                    select
                        count(*)
                    from
                        journal02_03
                    where
                        qc != ''
                        and duty_officer = ''
                        and master_id = j.id ) as qty_verify_p_jsy_03,
                    timestampdiff(second, concat(date_end, ' ', time_end), now()) as diff
                from
                    journal02 as j
                where
                    reject = ''
                    and (
                        timestampdiff(second, concat(date_end, ' ', time_end), now()) < 0
                        or sign_verify_leader is not null
                    )
                    and sign_verify is null
                order by
                    diff desc
                limit 200
            """.trimIndent())
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /**
     * 删除申请单，包括子单
     * 物理删除
     */
    @RequestMapping("/{id}", method = [RequestMethod.DELETE])
    fun remove(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                delete from journal02 where id = ?
            """.trimIndent(), id)
            jdbc.update("""
                delete from journal02_01 where master_id = ?
            """.trimIndent(), id)
            jdbc.update("""
                delete from journal02_02 where master_id = ?
            """.trimIndent(), id)
            jdbc.update("""
                delete from journal02_03 where master_id = ?
            """.trimIndent(), id)
            jdbc.update("""
                delete from journal02_04 where master_id = ?
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 申请单信息 */
    @RequestMapping("/{id}", method = [RequestMethod.GET])
    fun get(@PathVariable("id") id: Int): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            resp["content"] = jdbc!!.queryForMap("""
                select
                    *,
                    (
                        select
                            count(*)
                        from
                            journal02_02
                        where
                            qc != ''
                            and duty_officer = ''
                            and master_id = j.id
                    ) as qty_verify_p_jsy_02,
                    (
                        select
                            count(*)
                        from
                            journal02_03
                        where
                            qc != ''
                            and duty_officer = ''
                            and master_id = j.id
                    ) as qty_verify_p_jsy_03
                from
                    journal02 as j
                where
                    id = ?
            """.trimIndent(), id)
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }

    /**
     * 修改申请单
     */
    @RequestMapping("/{id}", method = [RequestMethod.PUT])
    fun update(@PathVariable("id") id: Int, @RequestBody body: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                update
                    journal02
                set
                    applicant = ?,
                    applicant_phone = ?,
                    leader = ?,
                    leader_phone = ?,
                    dept = ?,
                    group_sn = ?,
                    date_begin = ?,
                    time_begin = ?,
                    date_end = ?,
                    time_end = ?,
                    content = ?,
                    content_detail = ?,
                    p_yq_xdc = ?,
                    p_yq_jcw = ?,
                    p_yq_zydd = ?,
                    p_yq_qt = ?,
                    reject = ''
                where
                    id = ?
            """.trimIndent(), body["applicant"], body["applicantPhone"], body["leader"],
                    body["leaderPhone"], body["dept"], body["groupSN"],
                    body["dateBegin"], body["timeBegin"], body["dateEnd"], body["timeEnd"],
                    body["content"], body["content_detail"],
                    body["p_yq_xdc"], body["p_yq_jcw"], body["p_yq_zydd"], body["p_yq_qt"],
                    id)
        } catch (e: Exception) {
            resp["message"] = "服务器错误"
        }
        return resp
    }

    /* 添加申请单 */
    @RequestMapping("/", method = [RequestMethod.POST])
    fun save(@RequestBody map: Map<String, Any>): Map<String, Any> {
        var resp: MutableMap<String, Any> = hashMapOf("content" to "", "message" to "")
        try {
            jdbc!!.update("""
                insert into
                    journal02
                set
                    uuid = uuid(),
                    applicant = ?,
                    applicant_phone = ?,
                    leader = ?,
                    leader_id = ?,
                    leader_phone = ?,
                    dept = ?,
                    group_sn = ?,
                    date_begin = ?,
                    time_begin = ?,
                    date_end = ?,
                    time_end = ?,
                    content = ?,
                    content_detail = ?,
                    p_yq_xdc = ?,
                    p_yq_jcw = ?,
                    p_yq_zydd = ?,
                    p_yq_qt = ?
            """.trimIndent(), map["applicant"], map["applicantPhone"], map["leader"], map["leaderId"].toString().toInt(),
                    map["leaderPhone"], map["dept"], map["groupSN"],
                    map["dateBegin"], map["timeBegin"], map["dateEnd"], map["timeEnd"],
                    map["content"], map["content_detail"],
                    map["p_yq_xdc"], map["p_yq_jcw"], map["p_yq_zydd"], map["p_yq_qt"])
            resp["content"] = jdbc.queryForMap("""
                select last_insert_id() as last_id
            """.trimIndent())
            /* mapper.save(map) */
            /* resp["content"] = mapper.lastId() */
        } catch (e: Exception) {
            logger.error("{}", e)
            resp["message"] = "服务器错误。"
        }
        return resp
    }
}

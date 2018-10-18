package hengda.haxi.zhangxiang

import hengda.haxi.zhangxiang.model.Journal02Detail01
import hengda.haxi.zhangxiang.model.Journal02Detail02
import hengda.haxi.zhangxiang.model.Journal02Detail03
import hengda.haxi.zhangxiang.model.Journal02Detail04
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class Journal02Service {

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun save2Detail04(carriage: String, body: Journal02Detail04) {
        jdbc!!.update("""
            insert into
                journal02_04
            set
                uuid = uuid(),
                master_id = ?,
                subject = ?,
                software_version_new = ?,
                software_version_old = ?,
                approval_sn = ?,
                train = ?,
                date = ?,
                carriage = ?,
                time_begin = ?,
                time_end = ?,
                dept = ?,
                operator = ?,
                remark = ?
        """.trimIndent(), body.master_id, body.subject, body.software_version_new, body.software_version_old,
                body.approval_sn, body.train, body.date, carriage, body.time_begin, body.time_end,
                body.dept, body.operator, body.remark)
    }

    fun save2Detail03(carriage: String, body: Journal02Detail03) {
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
        """.trimIndent(), body.master_id, body.name, body.train, carriage, body.position, body.date, body.time,
                body.production_date, body.reason, body.p_gywj, body.p_ljbs,
                body.component_sn_old, body.component_sn_new, body.p_bjaz, body.operator)
    }

    fun save2Detail02(carriage: String, body: Journal02Detail02) {
        jdbc!!.update("""
            insert into
                journal02_02
            set
                uuid = uuid(),
                master_id = ?,
                name = ?,
                train = ?,
                carriage = ?,
                position = ?,
                date = ?,
                time = ?,
                reason = ?,
                p_gywj = ?,
                p_ljbs = ?,
                component_sn_old = ?,
                component_sn_new = ?,
                p_bjaz = ?,
                operator = ?
        """.trimIndent(), body.master_id, body.name, body.train, carriage, body.position, body.date, body.time,
                body.reason, body.p_gywj, body.p_ljbs, body.component_sn_old, body.component_sn_new,
                body.p_bjaz, body.operator)
    }
}
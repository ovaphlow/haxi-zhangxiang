package hengda.haxi.zhangxiang

import hengda.haxi.zhangxiang.model.Journal02Detail01
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class Journal02Service {

    @Autowired
    private val jdbc: JdbcTemplate? = null

    fun save2Detail01(carriage: String, body: Journal02Detail01) {
        jdbc!!.update("""
            insert into
                journal02_01
            set
                uuid = uuid(),
                master_id = ?,
                subject = ?,
                approval_sn = ?,
                train_sn = ?,
                date = ?,
                carriage = ?,
                carriage_subject = ?,
                time_begin = ?,
                time_end = ?,
                result = ?,
                report = ?,
                dept = ?,
                executor = ?,
                remark = ?
        """.trimIndent(), body.master_id, body.subject, body.approval_sn, body.train_sn, body.date,
                carriage, body.carriage_subject, body.time_begin, body.time_end,
                body.result, body.report, body.dept, body.executor, body.remark)
    }
}
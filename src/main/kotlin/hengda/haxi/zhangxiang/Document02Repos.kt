package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Document02Repos {

    val logger: Logger = LoggerFactory.getLogger(Document02Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /**
     * 检查供电状态是否冲突
     */
    fun checkPower(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                id, applicant, applicant_phone, dept, group_sn, content, content_detail, p_yq_xdc, p_yq_jcw
            from
                journal02
            where
                group_sn = (select group_sn from journal02 where id = ? limit 1)
                and id != ?
                and sign_p_jsy is not null
                and sign_p_zbsz is null
                and p_yq_xdc != (select p_yq_xdc from journal02 where id = ? limit 1)
                and p_yq_jcw != (select p_yq_jcw from journal02 where id = ? limit 1)
        """.trimIndent(), id, id, id, id)
    }
}
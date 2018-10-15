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
     * 一般配件和关键配件的更换记录单销记时触发
     * 检修工长销记列表
     */
    fun verifyPgz(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *
            from
                journal02
            where
                sign_verify_leader_bz is not null
                and sign_verify_leader_qc is null
                and (
                    (
                        select count(*) from journal02_02 where leader = ''
                    ) > 0
                    or (
                        select count(*) from journal02_03 where leader = ''
                    ) > 0
                )
        """.trimIndent())
    }

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
                -- and sign_p_zbsz is null
                and sign_verify_leader is null
                and p_yq_xdc != (select p_yq_xdc from journal02 where id = ? limit 1)
                and p_yq_jcw != (select p_yq_jcw from journal02 where id = ? limit 1)
        """.trimIndent(), id, id, id, id)
    }

    /**
     * 首页置顶显示 报警列表
     */
    fun listWarning(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 首页显示列表
     * 默认只显示非报警状态的未完成项目
     * 包括检查值班干部带处理申请单计数和超期时间
     */
    fun list(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 删除申请单
     */
    fun remove(id: Int) {
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
    }

    /**
     * 申请单信息
     */
    fun get(id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 修改申请
     */
    fun update(body: Map<String, Any>) {
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
            body["p_yq_xdc"], body["p_yq_jcw"], body["p_yq_zydd"], body["p_yq_qt"], body["id"])
    }

    /**
     * 提交申请
     */
    fun save(body: Map<String, Any>) {
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
        """.trimIndent(), body["applicant"], body["applicantPhone"], body["leader"],
            body["leaderId"].toString().toInt(),
            body["leaderPhone"], body["dept"], body["groupSN"],
            body["dateBegin"], body["timeBegin"], body["dateEnd"], body["timeEnd"],
            body["content"], body["content_detail"],
            body["p_yq_xdc"], body["p_yq_jcw"], body["p_yq_zydd"], body["p_yq_qt"])
    }
}
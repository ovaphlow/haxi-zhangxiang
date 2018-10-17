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
     * 待处理任务数量：值班所长（approve）
     */
    fun todoPzbszApprove(): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                count(*) as qty
            from
                journal02
            where
                sign_p_dd is not null
                and sign_p_zbsz is null
                and reject = ''
        """.trimIndent())
    }

    /**
     * 待处理任务数量：调度（review）
     */
    fun todoPddReview(): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 待处理任务数量：调度（approve）
     */
    fun todoPddApprove(): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                count(*) as qty
            from
                journal02 as j
            where
                sign_p_dd is null
                and sign_p_jsy is not null

                and reject = ''
        """.trimIndent())
    }

    /**
     * 待处理任务数量：质检（review）
     */
    fun todoQcReview(qc: String): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                count(*) as qty1
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
    }

    /**
     * 待处理任务数量：工长（review）
     */
    fun todoPgzReview(p_bz: String): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                count(*) as qty
            from
                journal02
            where
                p_jsy_bz = ?
                and sign_verify_leader_bz is not null
                and (
                    (
                        select count(*) from journal02_02 where leader = ''
                    ) > 0
                    or (
                        select count(*) from journal02_03 where leader = ''
                    ) > 0
                )
                and (
                    (
                        position('质检' in p_jsy_content) > 0
                        and sign_verify_leader_qc is null
                    )
                    or (
                        position('质检' in p_jsy_content) = 0
                        and sign_verify is null
                    )
                )
        """.trimIndent(), p_bz)
    }

    /**
     * 待处理任务数量：班组（review）
     */
    fun todoPbzReview(p_bz: String): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 待处理任务数量：班组（approve）
     */
    fun todoPbzApprove(p_bz: String): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 待处理数量：技术员（review）
     */
    fun todoPjsyReview(): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 待处理数量：技术员（approve）
     */
    fun todoPjsyApprove(): Map<String, Any> {
        return jdbc!!.queryForMap("""
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
    }

    /**
     * 按车组统计作业数量
     */
    fun stats(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select group_sn as name, count(*) as value from journal02 group by group_sn
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
     * 调度销记
     */
    fun submitReviewPdd(body: Map<String, Any>) {
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
        """.trimIndent(), body["verify"], body["verify_id"], body["remark"], body["sign"], body["id"])
    }

    /**
     * 调度销记列表
     */
    fun listReviewPdd(): List<Map<String, Any>> {
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
    }

    /**
     * 技术员销记列表
     */
    fun listReviewPjsy(): List<Map<String, Any>> {
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
    }

    /**
     * 质检销记
     */
    fun submitReviewQc(body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02 set sign_verify_leader_qc = ? where id = ?
        """.trimIndent(), body["sign"], body["id"])
    }

    /**
     * 质检销记列表
     */
    fun listReviewQc(qc: String): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 子帐单03 工长销记
     */
    fun submitReviewPgz03(body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_03 set leader = ? where id = ? and master_id = ?
        """.trimIndent(), body["leader"], body["id"], body["master_id"])
    }

    /**
     * 子帐单02 工长销记
     */
    fun submitReviewPgz02(body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_02 set leader = ? where id = ? and master_id = ?
        """.trimIndent(), body["leader"], body["id"], body["master_id"])
    }

    /**
     * 一般配件和关键配件的更换记录单销记时触发
     * 检修工长销记列表
     */
    fun listReviewPgz(p_bz: String): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                *
            from
                journal02
            where
                p_jsy_bz = ?
                and sign_verify_leader_bz is not null
                and (
                    (
                        select count(*) from journal02_02 where leader = ''
                    ) > 0
                    or (
                        select count(*) from journal02_03 where leader = ''
                    ) > 0
                )
                and (
                    (
                        position('质检' in p_jsy_content) > 0
                        and sign_verify_leader_qc is null
                    )
                    or (
                        position('质检' in p_jsy_content) = 0
                        and sign_verify is null
                    )
                )
        """.trimIndent(), p_bz)
    }

    /**
     * 班组销记签字
     */
    fun submitReviewPbz(body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02 set sign_verify_leader_bz = ? where id = ?
        """.trimIndent(), body["sign"], body["id"])
    }

    /**
     * 班组销记列表
     */
    fun listReviewPbz(p_bz: String): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
        """.trimIndent(), p_bz)
    }

    /**
     * 作业负责人销记
     */
    fun submitReviewApplicant(body: Map<String, Any>) {
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
                body["date_end"], body["time_end"], body["remark"], body["sign"], body["id"])
    }

    /**
     * 作业负责人销记列表
     */
    fun listReviewApplicant(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 值班所长确认
     */
    fun submitApprovePzbsz(body: Map<String, Any>) {
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
        """.trimIndent(), body["p_zbsz"], body["p_zbsz_id"], body["sign"], body["id"])
    }

    /**
     * 值班所长确认列表
     */
    fun listApprovePzbsz(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 调度确认
     */
    fun submitApprovePdd(body: Map<String, Any>) {
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
        """.trimIndent(), body["p_dd"], body["p_dd_id"], body["sign"], body["id"])
    }

    /**
     * 调度确认列表
     */
    fun listApprovePdd(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 班组确认
     */
    fun submitApprovePbz(body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02 set sign_p_jsy_bz = ? where id = ?
        """.trimIndent(), body["sign"], body["id"])
    }

    /**
     * 班组确认列表
     */
    fun listApprovePbz(p_bz: String): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
        """.trimIndent(), p_bz)
    }

    /**
     * 技术员签字
     */
    fun submitApprovePjsy(body: Map<String, Any>) {
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
        """.trimIndent(), body["p_jsy"], body["p_jsy_id"].toString().toInt(),
            body["p_jsy_content"], body["p_jsy_bz"], body["p_jsy_qc"], body["sign"], body["id"])
    }

    /**
     * 技术员确认列表
     */
    fun listApprovePjsy(): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select
                j.*
            from
                journal02 as j
            where
                (sign_p_jsy is null or p_jsy_content = '')
                and reject = ''
            limit 200
        """.trimIndent())
    }

    /**
     * 查询
     */
    fun filter(body: Map<String, Any>): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
            limit 2000
        """.trimIndent(), body["dept"], body["group"], body["date_begin"], body["time_begin"],
            body["date_end"], body["time_end"],
            body["content"], body["content_detail"], body["p_xdc"], body["p_jcw"])
    }

    /**
     * 指定用户审核或销记的申请单
     */
    fun filterByUserFlow(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
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
    }

    /**
     * 指定用户申请单
     */
    fun filterByUser(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal02 where leader_id = ? order by id desc limit 200
        """.trimIndent(), id)
    }

    /**
     * 查询已完成申请单
     */
    fun filterFin(body: Map<String, Any>): List<Map<String, Any>> {
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
                ) as qty_verify_p_jsy_03,
                -- 工长待办，？？？
                (
                    select count(*) from journal02_02 where master_id = j.id and leader = ''
                ) as qty_review_p_gz_02,
                (
                    select count(*) from journal02_03 where master_id = j.id and leader = ''
                ) as qty_review_p_gz_03,
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
                ) as qty_verify_p_jsy_03,
                (
                    select count(*) from journal02_02 where master_id = j.id and leader = ''
                ) as qty_review_p_gz_02,
                (
                    select count(*) from journal02_03 where master_id = j.id and leader = ''
                ) as qty_review_p_gz_03
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
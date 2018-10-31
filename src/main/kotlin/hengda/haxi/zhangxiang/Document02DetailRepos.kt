package hengda.haxi.zhangxiang

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

//一体化作业申请 子单
@Repository
class Document02DetailRepos {

    val logger: Logger = LoggerFactory.getLogger(Document02Repos::class.java)

    @Autowired
    private val jdbc: JdbcTemplate? = null

    /* 子单 计数 */
    fun qty(master_id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select
                content,
                (select count(*) from journal02_01 where master_id = ?) as qty_01,
                (select count(*) from journal02_02 where master_id = ?) as qty_02,
                (select count(*) from journal02_03 where master_id = ?) as qty_03,
                (select count(*) from journal02_04 where master_id = ?) as qty_04
            from
                journal02
            where
                id = ?
            limit 1
        """.trimIndent(), master_id, master_id, master_id, master_id, master_id)
    }

    /* 04子单 计数 */
    fun qty04(master_id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal02_04 where master_id = ?
        """.trimIndent(), master_id)
    }

    /* 03子单 计数 */
    fun qty03(master_id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal02_03 where master_id = ?
        """.trimIndent(), master_id)
    }

    /* 02子单 计数 */
    fun qty02(master_id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal02_02 where master_id = ?
        """.trimIndent(), master_id)
    }

    /* 01子单 计数 */
    fun qty01(master_id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select count(*) as qty from journal02_01 where master_id = ?
        """.trimIndent(), master_id)
    }

    /* 03子单 值班干部销记 */
    fun review03Pjsy(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_03 set duty_officer = ? where id = ? and master_id = ? limit 1
        """.trimIndent(), body["duty_officer"], id, master_id)
    }

    /* 02子单 值班干部销记 */
    fun review02Pjsy(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_02 set duty_officer = ? where id = ? and master_id = ?
        """.trimIndent(), body["duty_officer"], id, master_id)
    }

    /* 04子单 质检销记 */
    fun review04Qc(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_04 set qc = ? where id = ? and master_id = ?
        """.trimIndent(), body["qc"], id, master_id)
    }

    /* 03子单 质检销记 */
    fun review03Qc(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_03 set p_bjgnsy = ?, qc = ? where id = ? and master_id = ?
        """.trimIndent(), body["p_bjgnsy"], body["qc"], id, master_id)
    }

    /* 02子单 质检销记 */
    fun review02Qc(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_02 set p_bjgnsy = ?, qc = ? where id = ? and master_id = ?
        """.trimIndent(), body["p_bjgnsy"], body["qc"], id, master_id)
    }

    /* 质检销记 */
    fun review01Qc(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_01 set qc = ? where id = ? and master_id = ?
        """.trimIndent(), body["qc"], id, master_id)
    }

    /* 04子单 班组销记 */
    fun review04Pbz(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_04 set watcher = ?, watcher_group = ? where id = ? and master_id = ?
        """.trimIndent(), body["watcher"], body["watcher_group"], id, master_id)
    }

    /* 班组销记 */
    fun review01Pbz(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02_01 set watcher = ?, watcher_group = ? where id = ? and master_id = ?
        """.trimIndent(), body["watcher"], body["watcher_group"], id, master_id)
    }

    /* 04子单 删除 */
    fun remove04(master_id: Int, id: Int) {
        jdbc!!.update("""
            delete from journal02_04 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 03子单 删除 */
    fun remove03(master_id: Int, id: Int) {
        jdbc!!.update("""
            delete from journal02_03 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 02子单 删除 */
    fun remove02(master_id: Int, id: Int) {
        jdbc!!.update("""
            delete from journal02_02 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 删除子单 */
    fun remove01(master_id: Int, id: Int) {
        jdbc!!.update("""
            delete from journal02_01 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 04子单 修改 */
    fun update04(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal02_04
            set
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
                watcher = ?,
                watcher_group = ?,
                qc = ?,
                remark = ?
            where
                id = ?
                and master_id = ?
        """.trimIndent(), body["subject"], body["software_version_new"], body["software_version_old"],
                body["approval_sn"], body["train"], body["date"], body["carriage"], body["time_begin"],
                body["time_end"], body["dept"], body["operator"], body["watcher"], body["watcher_group"],
                body["qc"], body["remark"], id, master_id)
    }

    /* 03子单 修改 */
    fun update03(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal02_03
            set
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
                operator = ?,
                leader = ?,
                p_bjgnsy = ?,
                qc = ?,
                duty_officer = ?
            where
                id = ?
                and master_id = ?
        """.trimIndent(), body["name"], body["train"], body["carriage"], body["position"], body["date"],
                body["time"], body["production_date"], body["reason"], body["p_gywj"], body["p_ljbs"],
                body["component_sn_old"], body["component_sn_new"], body["p_bjaz"], body["operator"],
                body["leader"], body["p_bjgnsy"], body["qc"], body["duty_officer"], id, master_id)
    }

    /* 02子单 修改 */
    fun update02(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal02_02
            set
                name = ?,
                train = ?,
                carriage = ?,
                position = ?,
                date = ?,
                time = ?,
                reason = ?,
                p_ljbs = ?,
                p_gywj = ?,
                component_sn_old = ?,
                component_sn_new = ?,
                p_bjaz = ?,
                operator = ?,
                leader = ?,
                p_bjgnsy = ?,
                qc = ?,
                duty_officer = ?
            where
                id = ?
        """.trimIndent(), body["name"], body["train"], body["carriage"], body["position"],
                body["date"], body["time"], body["reason"],
                body["p_ljbs"], body["p_gywj"], body["component_sn_old"], body["component_sn_new"],
                body["p_bjaz"], body["operator"], body["leader"],
                body["p_bjgnsy"], body["qc"], body["duty_officer"], id)
    }

    /* 修改子单 */
    fun update01(master_id: Int, id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update
                journal02_01
            set
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
                watcher = ?,
                watcher_group = ?,
                qc = ?,
                remark = ?
            where
                id = ?
                and master_id = ?
        """.trimIndent(), body["subject"], body["approval_sn"], body["train_sn"], body["date"],
            body["carriage"], body["carriage_subject"], body["time_begin"], body["time_end"],
            body["result"], body["report"], body["dept"], body["executor"],
            body["watcher"], body["watcher_group"], body["qc"], body["remark"], id, master_id)
        /*
        修改子单后是否同步修改申请单？？？
        jdbc.update("""
            update
                journal02
            set
                time_begin = ?,
                time_end = ?
            where
                id = ?
        """.trimIndent(), body["time_begin"], body["time_end"], master_id)
        */
    }

    /* 04子单 信息 */
    fun get04(master_id: Int, id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal02_04 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 03子单 信息 */
    fun get03(master_id: Int, id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal02_03 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 02子单信息 */
    fun get02(master_id: Int, id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal02_02 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 01子单信息 */
    fun get01(master_id: Int, id: Int): Map<String, Any> {
        return jdbc!!.queryForMap("""
            select * from journal02_01 where id = ? and master_id = ?
        """.trimIndent(), id, master_id)
    }

    /* 子单添加后修改时间 */
    fun updateMasterTime(master_id: Int, body: Map<String, Any>) {
        jdbc!!.update("""
            update journal02 set time_begin = ?, time_end = ? where id = ?
        """.trimIndent(), body["time_begin"], body["time_end"], master_id)
    }

    /* 04子单 添加 */
    fun save04(master_id: Int, carriage: String, body: Map<String, Any>) {
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
        """.trimIndent(), master_id, body["subject"], body["software_version_new"], body["software_version_old"],
                body["approval_sn"], body["train"], body["date"], carriage, body["time_begin"], body["time_end"],
                body["dept"], body["operator"], body["remark"])
    }

    /* 03子单 添加 */
    fun save03(master_id: Int, carriage: String, body: Map<String, Any>) {
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
        """.trimIndent(), master_id, body["name"], body["train"], carriage, body["position"],
                body["date"], body["time"], body["production_date"], body["reason"], body["p_gywj"], body["p_ljbs"],
                body["component_sn_old"], body["component_sn_new"], body["p_bjaz"], body["operator"])
    }

    /* 02子单 添加 */
    fun save02(master_id: Int, carriage: String, body: Map<String, Any>) {
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
        """.trimIndent(), master_id, body["name"], body["train"], carriage, body["position"], body["date"],
                body["time"], body["reason"], body["p_gywj"], body["p_ljbs"],
                body["component_sn_old"], body["component_sn_new"], body["p_bjaz"], body["operator"])
    }

    /* 01子单 添加 */
    fun save01(master_id: Int, carriage: String, body: Map<String, Any>) {
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
        """.trimIndent(), master_id, body["subject"], body["approval_sn"], body["train_sn"], body["date"],
                carriage, body["carriage_subject"], body["time_begin"], body["time_end"],
                body["result"], body["report"], body["dept"], body["executor"], body["remark"])
    }

    /* 04子单列表 */
    fun list04(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal02_04 where master_id = ?
        """.trimIndent(), id)
    }

    /* 03子单列表 */
    fun list03(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal02_03 where master_id = ?
        """.trimIndent(), id)
    }

    /* 02子单列表 */
    fun list02(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal02_02 where master_id = ?
        """.trimIndent(), id)
    }

    /* 01子单列表 */
    fun list01(id: Int): List<Map<String, Any>> {
        return jdbc!!.queryForList("""
            select * from journal02_01 where master_id = ?
        """.trimIndent(), id)
    }
}
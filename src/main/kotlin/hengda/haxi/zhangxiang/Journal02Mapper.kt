package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal02Mapper {

    /* 废弃 */
    /* @Update("""
        update journal02 set tag = #{tag} where id = #{id}
    """)
    fun updateTag(@Param("tag") tag: String, @Param("id") id: Int) */

    /* 查询 */
    /* @Select("""
    select
        *
    from
        journal02
    where
        position(#{dept} in dept) > 0
        and position(#{group_sn} in group_sn) > 0
        and position(#{date_begin} in date_begin) > 0
    limit 1000
    """)
    fun filter(map: Map<String, Any>): List<Map<String, Any>> */

    /* 调度销记签字 */
    /* @Update("""
        update journal02 set sign_verify = #{sign} where id = #{id}
    """)
    fun updateVerifySign(map: Map<String, Any>) */

    /* 调度销记 */
    /* @Update("""
        update
            journal02
        set
            verify = #{verify},
            verify_id = #{verify_id},
            verify_date = now(),
            verify_time = now(),
            remark = #{remark}
        where
            id = #{id}
      """)
    fun updateVerify(map: Map<String, Any>) */

    /* 保存同一账单下所有子帐单04的表头 */
    /* @Update("""
        update
            journal02_04
        set
            subject = #{subject},
            software_version_new = #{software_version_new},
            software_version_old = #{software_version_old},
            approval_sn = #{approval_sn},
            train = #{train},
            date = #{date}
        where
            master_id = #{masterId}
    """)
    fun update04(map: Map<String, Any>) */

    /* 子帐单04：删除 */
    /* @Delete("""
        delete from journal02_04 where master_id = #{masterId} and id = #{id}
    """)
    fun remove04(@Param("masterId") masterId: Int, @Param("id") id: Int) */

    /* 子帐单04：添加 */
    /* @Insert("""
        insert into
            journal02_04
        set
            uuid = uuid(),
            master_id = #{masterId},
            subject = #{subject},
            software_version_new = #{software_version_new},
            software_version_old = #{software_version_old},
            approval_sn = #{approval_sn},
            train = #{train},
            date = #{date},
            carriage = #{carriage},
            time_begin = #{time_begin},
            time_end = #{time_end},
            dept = #{dept},
            operator = #{operator},
            remark = #{remark}
      """)
    fun save04(map: Map<String, Any>) */

    /* 子帐单03：删除 */
    /* @Delete("""
        delete from journal02_03 where master_id = #{masterId} and id = #{id}
    """)
    fun remove03(@Param("masterId") masterId: Int, @Param("id") id: Int) */

    /* 子帐单03：添加 */
    /* @Insert("""
        insert into
            journal02_03
        set
            master_id = #{masterId},
            name = #{name},
            train = #{train},
            carriage = #{carriage},
            position = #{position},
            date = #{date},
            time = #{time},
            production_date = #{production_date},
            reason = #{reason},
            p_gywj = #{p_gywj},
            p_ljbs = #{p_ljbs},
            component_sn_old = #{component_sn_old},
            component_sn_new = #{component_sn_new},
            p_bjaz = #{p_bjaz},
            operator = #{operator},
            leader = #{leader}
      """)
    fun save03(map: Map<String, Any>) */

    /* 子帐单02：删除 */
    /* @Delete("""
        delete from journal02_02 where master_id = #{masterId} and id = #{id}
    """)
    fun remove02(@Param("masterId") masterId: Int, @Param("id") id: Int) */

    /* 子帐单02：添加 */
    /* @Insert("""
        insert into
            journal02_02
        set
            master_id = #{masterId},
            name = #{name},
            train = #{train},
            carriage = #{carriage},
            position = #{position},
            date = #{date},
            time = #{time},
            reason = #{reason},
            p_gywj = #{p_gywj},
            p_ljbs = #{p_ljbs},
            component_sn_old = #{component_sn_old},
            component_sn_new = #{component_sn_new},
            p_bjaz = #{p_bjaz},
            operator = #{operator},
            leader = #{leader}
    """)
    fun save02(map: Map<String, Any>) */

    /* 保存同一账单下所有子帐单的表头 */
    /* @Update("""
        update
            journal02_01
        set
            subject = #{subject},
            approval_sn = #{approval_sn},
            train_sn = #{train_sn},
            date = #{date}
        where
            master_id = #{id}
    """)
    fun update01(map: Map<String, Any>) */

    /* 子帐单01：删除 */
    /* @Delete("""
        delete from journal02_01 where master_id = #{masterId} and id = #{id}
    """)
    fun remove01(@Param("masterId") masterId: Int, @Param("id") id: Int) */

    /* 子帐单01：添加 */
    /* @Insert("""
        insert into
            journal02_01
        set
            uuid = uuid(),
            master_id = #{master_id},
            subject = #{subject},
            approval_sn = #{approval_sn},
            train_sn = #{train_sn},
            date = #{date},
            carriage = #{carriage},
            carriage_subject = #{carriage_subject},
            time_begin = #{time_begin},
            time_end = #{time_end},
            result = #{result},
            report = #{report},
            dept = #{dept},
            executor = #{executor},
            remark = #{remark}
    """)
    fun save01(map: Map<String, Any>) */

    /* 质检销记签字 */
    /* @Update("""
        update journal02 set sign_verify_leader_qc = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderQc(map: Map<String, Any>) */

    /* 质检销记列表 */
    /* @Select("""
        select
            *
        from
            journal02
        where
            verify_leader_id > 0
            and position('班组' in p_jsy_content) = 1
            and sign_verify_leader_bz is not null
            and sign_verify_leader_qc is null
            and p_jsy_qc = #{qc}
    """)
    fun listVerifyLeaderQc(@Param("qc") qc: String): List<Map<String, Any>> */

    /* 班组销记签字 */
    /* @Update("""
        update journal02 set sign_verify_leader_bz = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderBz(map: Map<String, Any>) */

    /* 作业负责人销记签字 */
    /* @Update("""
        update journal02 set sign_verify_leader = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderSign(map: Map<String, Any>) */

    /* 作业负责人销记 */
    /* @Update("""
        update
            journal02
        set
            verify_report = #{verify_report},
            verify_leader = #{verify_leader},
            verify_leader_id = #{verify_leader_id},
            verify_leader_date = #{verify_leader_date},
            verify_leader_time = #{verify_leader_time},
            remark = #{remark}
        where
            id = #{id}
    """)
    fun updateVerifyLeader(map: Map<String, Any>) */

    /* todo: 检查是否有用 */
    /* @Select("""
        select * from journal02 where verify_leader_id = 0 and p_dd_id != 0
    """)
    fun listVerifyLeader(): List<Map<String, Any>> */

    /* 调度签字 */
    /* @Update("""
        update
            journal02
        set
            p_dd = #{p_dd},
            p_dd_id = #{p_dd_id},
            p_dd_date = now(),
            p_dd_time = now(),
            sign_p_dd = #{sign}
        where
            id = #{id}
    """)
    fun updateDD(map: Map<String, Any>) */

    /* 值班所长签字 */
    /* @Update("""
        update
            journal02
        set
            p_zbsz = #{p_zbsz},
            p_zbsz_id = #{p_zbsz_id},
            p_zbsz_date = now(),
            p_zbsz_time = now(),
            sign_p_zbsz = #{sign}
        where
            id = #{id}
      """)
    fun updateZBSZ(map: Map<String, Any>) */

    /* 技术员后质检签字 */
    /* @Update("""
        update journal02 set sign_p_jsy_qc = #{sign} where id = #{id}
    """)
    fun updateJsyQc(map: Map<String, Any>) */

    /* 技术员后班组签字 */
    /* @Update("""
        update journal02 set sign_p_jsy_bz = #{sign} where id = #{id}
    """)
    fun updateJsyBz(map: Map<String, Any>) */

    /* 技术员设定 */
    /* @Update("""
        update
            journal02
        set
            p_jsy_content = #{p_jsy_content},
            p_jsy_bz = #{p_jsy_bz},
            p_jsy_qc = #{p_jsy_qc}
        where
            id = #{id}
      """)
    fun updateJSYContent(map: Map<String, Any>) */

    /* @Select("""
        select last_insert_id() as last_id
    """)
    fun lastId(): Map<String, Any> */
}

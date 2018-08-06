package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal02Mapper {

    @Update("""
        update journal02 set tag = #{tag} where id = #{id}
    """)
    fun updateTag(@Param("tag") tag: String, @Param("id") id: Int)

    @Select("""
        select
            group_sn as name, count(*) as value
        from
            journal02
        group by
            group_sn
    """)
    fun stats(): List<Map<String, Any>>

    @Select("""
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
    fun filter(map: Map<String, Any>): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_verify = #{sign} where id = #{id}
    """)
    fun updateVerifySign(map: Map<String, Any>)

    @Update("""
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
    fun updateVerify(map: Map<String, Any>)

    /**
     * 调度销记列表
     */
    @Select("""
        select
            *
        from
            journal02
        where
            sign_verify is null
            and sign_verify_leader is not null
            and (
                ( p_jsy_content = '同意' )
                or ( sign_verify_leader_qc is not null )
            )
    """)
    fun listVerify(): List<Map<String, Any>>

    @Update("""
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
    fun update04(map: Map<String, Any>)

    @Delete("""
        delete from journal02_04 where master_id = #{masterId} and id = #{id}
    """)
    fun remove04(@Param("masterId") masterId: Int, @Param("id") id: Int)

    @Insert("""
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
    fun save04(map: Map<String, Any>)

    @Select("""
        select * from journal02_04 where master_id = #{masterId}
    """)
    fun list04(@Param("masterId") id: Int): List<Map<String, Any>>

    @Delete("""
        delete from journal02_03 where master_id = #{masterId} and id = #{id}
    """)
    fun remove03(@Param("masterId") masterId: Int, @Param("id") id: Int)

    @Insert("""
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
    fun save03(map: Map<String, Any>)

    @Select("""
        select * from journal02_03 where master_id = #{masterId}
    """)
    fun list03(@Param("masterId") masterId: Int): List<Map<String, Any>>

    @Delete("""
        delete from journal02_02 where master_id = #{masterId} and id = #{id}
    """)
    fun remove02(@Param("masterId") masterId: Int, @Param("id") id: Int)

    @Insert("""
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
    fun save02(map: Map<String, Any>)

    @Select("""
        select * from journal02_02 where master_id = #{masterId}
    """)
    fun list02(@Param("masterId") masterId: Int): List<Map<String, Any>>

    @Update("""
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
    fun update01(map: Map<String, Any>)

    @Delete("""
        delete from journal02_01 where master_id = #{masterId} and id = #{id}
    """)
    fun remove01(@Param("masterId") masterId: Int, @Param("id") id: Int)

    @Insert("""
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
    fun save01(map: Map<String, Any>)

    @Select("""
        select * from journal02_01 where master_id = #{id}
    """)
    fun list01(@Param("id") id: Int): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_verify_leader_qc = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderQc(map: Map<String, Any>)

    @Select("""
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
    fun listVerifyLeaderQc(@Param("qc") qc: String): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_verify_leader_bz = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderBz(map: Map<String, Any>)

    @Select("""
        select
            *
        from
            journal02
        where
            verify_leader_id > 0
            and position('班组' in p_jsy_content) = 1
            and sign_verify_leader_bz is null
            and p_jsy_bz = #{bz}
    """)
    fun listVerifyLeaderBz(@Param("bz") bz: String): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_verify_leader = #{sign} where id = #{id}
    """)
    fun updateVerifyLeaderSign(map: Map<String, Any>)

    @Update("""
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
    fun updateVerifyLeader(map: Map<String, Any>)

    @Select("""
        select * from journal02 where sign_p_dd is not null and applicant_id = #{id} and sign_verify_leader is null
    """)
    fun listVerifyByLeader(@Param("id") id: Int): List<Map<String, Any>>

    @Select("""
        select * from journal02 where verify_leader_id = 0 and p_dd_id != 0
    """)
    fun listVerifyLeader(): List<Map<String, Any>>

    @Update("""
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
    fun updateDD(map: Map<String, Any>)

    @Select("""
        select * from journal02 where p_dd_id = 0 and p_zbsz_id != 0 limit 1000
    """)
    fun listDD(): List<Map<String, Any>>

    @Update("""
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
    fun updateZBSZ(map: Map<String, Any>)

    @Select("""
        select
            j.*
        from
            journal02 as j
        where
            p_zbsz_id = 0
            and sign_p_jsy is not null
            and p_jsy_content != ''
            and (
                (p_jsy_content = '同意')
                or (position('班组跟踪' in p_jsy_content) = 1 and sign_p_jsy_bz is not null)
                or (position('质检跟踪' in p_jsy_content) > 0 and sign_p_jsy_qc is not null)
            )
        limit 1000
    """)
    fun listZBSZ(): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_p_jsy_qc = #{sign} where id = #{id}
    """)
    fun updateJsyQc(map: Map<String, Any>)

    @Select("""
        select
            *
        from
            journal02
        where
            position('质检跟踪' in p_jsy_content) > 0
            and p_jsy_qc = #{qc}
            and sign_p_jsy_bz is not null
            and sign_p_jsy_qc is null
    """)
    fun listJsyQc(@Param("qc") qc: String): List<Map<String, Any>>

    @Update("""
        update journal02 set sign_p_jsy_bz = #{sign} where id = #{id}
    """)
    fun updateJsyBz(map: Map<String, Any>)

    @Select("""
        select
            *
        from
            journal02
        where
            position('班组' in p_jsy_content) > 0
            and p_jsy_bz = #{bz}
            and sign_p_jsy_bz is null
            and p_jsy_id > 0
    """)
    fun listJsyBz(@Param("bz") bz: String): List<Map<String, Any>>

    @Update("""
        update
            journal02
        set
            p_jsy_content = #{p_jsy_content},
            p_jsy_bz = #{p_jsy_bz},
            p_jsy_qc = #{p_jsy_qc}
        where
            id = #{id}
      """)
    fun updateJSYContent(map: Map<String, Any>)

    @Update("""
        update
            journal02
        set
            p_jsy = #{p_jsy},
            p_jsy_id = #{p_jsy_id},
            p_jsy_date = now(),
            p_jsy_time = now(),
            sign_p_jsy = #{sign}
        where
            id = #{id}
    """)
    fun updateJSY(map: Map<String, Any>)

    @Select("""
        select j.* from journal02 as j where p_jsy_id = 0 or p_jsy_content = '' limit 1000
    """)
    fun listJSY(): List<Map<String, Any>>

    @Select("""
        select j.* from journal02 as j order by id desc limit 1000
    """)
    fun list(): List<Map<String, Any>>

    @Select("""
        select
            *,
            date_format(date_begin, '%Y年%m月%d日') as date_begin_alt,
            date_format(time_begin, '%k时%i分') as time_begin_alt,
            date_format(date_end, '%Y年%m月%d日') as date_end_alt,
            date_format(time_end, '%k时%i分') as time_end_alt
        from
            journal02
        where
            id = #{id}
    """)
    fun get(@Param("id") id: Int): Map<String, Any>

    @Select("""
        select last_insert_Id() as last_id
    """)
    fun lastId(): Map<String, Any>

    @Insert("""
        insert into
            journal02
        set
            uuid = uuid(),
            applicant = #{applicant},
            applicant_id = #{applicantId},
            applicant_phone = #{applicantPhone},
            leader = #{leader},
            leader_phone = #{leaderPhone},
            dept = #{dept},
            group_sn = #{groupSN},
            date_begin = #{dateBegin},
            time_begin = #{timeBegin},
            date_end = #{dateEnd},
            time_end = #{timeEnd},
            content = #{content},
            content_detail = #{content_detail},
            p_yq_xdc = #{p_yq_xdc},
            p_yq_jcw = #{p_yq_jcw},
            p_yq_zydd = #{p_yq_zydd},
            p_yq_qt = #{p_yq_qt}
      """)
    fun save(map: Map<String, Any>)
}
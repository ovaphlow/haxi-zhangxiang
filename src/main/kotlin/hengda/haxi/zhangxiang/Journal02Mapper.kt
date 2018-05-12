package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal02Mapper {

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

  @Select("""
    select * from journal02 where verify_id = 0 and verify_leader_id != 0
  """)
  fun listVerify(): List<Map<String, Any>>

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
      p_dd_time = now()
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
      p_zbsz_time = now()
    where
      id = #{id}
  """)
  fun updateZBSZ(map: Map<String, Any>)

  @Select("""
    select j.* from journal02 as j where p_zbsz_id = 0 and p_jsy_id != 0 limit 1000
  """)
  fun listZBSZ(): List<Map<String, Any>>

  @Update("""
    update
      journal02
    set
      p_jsy = #{p_jsy},
      p_jsy_id = #{p_jsy_id},
      p_jsy_date = now(),
      p_jsy_time = now()
    where
      id = #{id}
  """)
  fun updateJSY(map: Map<String, Any>)

  @Select("""
    select j.* from journal02 as j where p_jsy_id = 0 limit 1000
  """)
  fun listJSY(): List<Map<String, Any>>

  @Select("""
    select j.* from journal02 as j order by id desc limit 1000
  """)
  fun list(): List<Map<String, Any>>

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
      watcher = #{watcher},
      watcher_group = #{watcher_group},
      qc = #{qc},
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
      leader = #{leader},
      p_bjgnsy = #{p_bjgnsy},
      qc = #{qc},
      duty_officer = #{duty_officer}
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
      leader = #{leader},
      p_bjgnsy = #{p_bjgnsy},
      qc = #{qc},
      duty_officer = #{duty_officer}
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
      watcher = #{watcher},
      watcher_group = #{watcher_group},
      qc = #{qc},
      remark = #{remark}
  """)
  fun save01(map: Map<String, Any>)

  @Select("""
    select * from journal02_01 where master_id = #{id}
  """)
  fun list01(@Param("id") id: Int): List<Map<String, Any>>

  @Select("""
    select * from journal02 where id = #{id}
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
      p_yq_xdc = #{p_yq_xdc},
      p_yq_jcw = #{p_yq_jcw},
      p_yq_zydd = #{p_yq_zydd},
      p_yq_qt = #{p_yq_qt}
  """)
  fun save(map: Map<String, Any>)
}
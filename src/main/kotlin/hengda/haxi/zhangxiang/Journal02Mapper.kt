package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal02Mapper {

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
    select
      *
    from
      journal02
    where
      p_dd_id = 0
      and p_zbsz_id != 0
    limit 1000
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
    select
      j.*
    from
      journal02 as j
    where
      p_zbsz_id = 0
      and p_jsy_id != 0
    limit 1000
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
    select
      j.*
    from
      journal02 as j
    where
      p_jsy_id = 0
    limit 1000
  """)
  fun listJSY(): List<Map<String, Any>>

  @Select("""
    select
      j.*
    from
      journal02 as j
    order by
      id desc
    limit 1000
  """)
  fun list(): List<Map<String, Any>>

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
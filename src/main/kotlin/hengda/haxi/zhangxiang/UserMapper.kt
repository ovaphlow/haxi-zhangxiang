package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

  @Select("""
    select
      id, uuid, name, phone
    from
      user
    where
      dept_id = #{id}
  """)
  fun listUserByDept(@Param("id") id: Int): List<Map<String, Any>>

  @Select("""
    select
      u.id, u.uuid, username, u.name, d.name as dept, d.id as dept_id, u.phone,
      auth_01, auth_p_jsy, auth_p_zbsz, auth_p_dd
    from
      user as u
      left join dept as d
        on d.id = u.dept_id
    where
      username = #{account}
      and password = #{password}
  """)
  fun login(map: Map<String, Any>): List<Map<String, Any>>
}
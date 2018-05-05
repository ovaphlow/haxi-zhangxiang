package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal01Mapper {

  @Select("""
    select
      id, uuid,
      date, time, quantity, applicant, applicant_id, dept,
      borrow_date, borrow_time, borrow, borrow_id,
      remark
    from
      journal01
    order by
      id desc
    limit
      1000
  """)
  fun filter(): List<Map<String, Any>>

  @Select("""
    select
      id, uuid,
      date, time, quantity, applicant, applicant_id, dept,
      borrow_date, borrow_time, borrow, borrow_id,
      remark
    from
      journal01
    where
      borrow_id != 0
      and return_id = 0
    order by
      id desc
    limit
      1000
  """)
  fun listReturn(): List<Map<String, Any>>

  @Select("""
    select
      j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
    from
      journal01 as j
    where
      borrow_date <= '0001-01-01'
  """)
  fun listByAdmin(): List<Map<String, Any>>

  @Select("""
    select
      j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
    from
      journal01 as j
    where
      applicant_id = #{id}
  """)
  fun listByApplicant(@Param("id") id: Int): List<Map<String, Any>>

  @Update("""
    update
      journal01
    set
      borrow_date = now(),
      borrow_time = now(),
      borrow = #{borrow},
      borrow_id = #{borrowId}
    where
      id = #{id}
  """)
  fun borrow(@Param("borrow") borrow: String, @Param("borrowId") borrowId: Int, @Param("id") id: Int)

  @Select("""
    select
      id, uuid,
      date, time, quantity, applicant, applicant_id, dept,
      borrow_date, borrow_time, borrow, borrow_id,
      `return`, return_id, return_by, return_by_id, return_date, return_time,
      remark
    from
      journal01
    where
      id = #{id}
  """)
  fun info(@Param("id") id: Int): Map<String, Any>

  @Insert("""
    insert into
      journal01
    set
      uuid = uuid(),
      date = now(),
      time = now(),
      quantity = #{quantity},
      applicant_id = #{applicantId},
      applicant = #{applicant},
      dept = #{dept},
      remark = #{remark}
  """)
  fun save(map: Map<String, Any>)
}
package hengda.haxi.zhangxiang

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface Journal01Mapper {

//    @Select("""
//        select
//            *
//        from
//            journal01
//        where
//            position(#{date} in date) = 1
//            and position(#{dept} in dept) = 1
//            and position(#{user} in applicant) = 1
//    """)
//    fun filter(map: Map<String, Any>): List<Map<String, Any>>

//    @Select("""
//        select
//            *
//        from
//            journal01
//        order by
//            id desc
//        limit 1000
//    """)
//    fun list(): List<Map<String, Any>>

//    @Update("""
//        update
//            journal01
//        set
//            return_name = #{return_name},
//            return_by = #{return_by},
//            return_by_id = #{return_by_id},
//            return_date = now(),
//            return_time = now(),
//            remark = #{remark}
//        where
//            id = #{id}
//    """)
//    fun returnSubmit(map: Map<String, Any>)

    // 普通用户未返还列表
//    @Select("""
//        select * from journal01 where applicant_id = #{id} and return_by_id != 0
//    """)
//    fun listUserReturn(@Param("id") id: Int): List<Map<String, Any>>

//    @Select("""
//        select
//            id, uuid,
//            date, time, quantity, applicant, applicant_id, dept,
//            borrow_date, borrow_time, borrow, borrow_id,
//            remark
//        from
//            journal01
//        where
//            borrow_id != 0
//            and return_by_id = 0
//        order by
//            id desc
//        limit 1000
//    """)
//    fun listReturn(): List<Map<String, Any>>

//    @Select("""
//        select
//            j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
//        from
//            journal01 as j
//        where
//            borrow_date <= '0001-01-01'
//    """)
//    fun listByAdmin(): List<Map<String, Any>>

//    @Select("""
//        select
//            j.id, j.uuid, date, time, quantity, applicant_id, applicant, dept
//        from
//            journal01 as j
//        where
//            applicant_id = #{id}
//            and borrow_id = 0
//    """)
//    fun listByApplicant(@Param("id") id: Int): List<Map<String, Any>>

//    @Update("""
//        update
//            journal01
//        set
//            borrow_date = now(),
//            borrow_time = now(),
//            borrow = #{borrow},
//            borrow_id = #{borrowId}
//        where
//            id = #{id}
//    """)
//    fun borrow(@Param("borrow") borrow: String, @Param("borrowId") borrowId: Int, @Param("id") id: Int)

//    @Select("""
//        select * from journal01 where id = #{id}
//    """)
//    fun info(@Param("id") id: Int): Map<String, Any>

//    @Insert("""
//        insert into
//            journal01
//        set
//            uuid = uuid(),
//            date = now(),
//            time = now(),
//            quantity = #{quantity},
//            applicant_id = #{applicantId},
//            applicant = #{applicant},
//            dept = #{dept},
//            remark = #{remark}
//    """)
//    fun save(map: Map<String, Any>)
}
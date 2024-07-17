package com.hospital.mapper;

import com.hospital.pojo.Bills;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface BillsMapper {

    @Select("select * from bills where patient_id=#{patid}")
    List<Bills> getMyBill(@Param("patid")String patid) throws SQLException;

    @Select("select max(bill_id) from bills")
    String getBillMax() throws SQLException;

    @Insert("insert into bills(bill_id,patient_id,doctor_id,bill_date,bill_price,bill_state,bill_type) values(#{bnum},#{integer},#{docid},#{billdate},#{price},#{i},#{type})")
    void createBill(@Param("bnum")int bnum, @Param("integer")Integer integer, @Param("docid")Integer docid, @Param("billdate")String billdate, @Param("price")Integer price,@Param("i")int i, @Param("type")String type);
}

package com.hospital.mapper;

import com.hospital.pojo.Doctors;
import com.hospital.pojo.HaoByDepart;
import com.hospital.pojo.Schedules;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface SchedulesMapper {
    List<Schedules> getScheduleList(@Param("did")String did, @Param("date")String date) throws SQLException;

    @Insert("insert into doctor_schedule(schedule_id,doctor_id,date,shift_time,department_id) values (#{sid},#{i},#{sdate},#{shift},#{did})")
    boolean addSchedule(@Param("sid")int sid,@Param("i")int i,@Param("did")int did, @Param("sdate")String sdate,@Param("shift")String shift) throws SQLException;

    @Select("select max(schedule_id) from doctor_schedule")
    String getScheduleIdMax() throws SQLException;

    @Delete("delete from doctor_schedule where schedule_id=#{sid}")
    void deleteById(@Param("sid")String sid) throws SQLException;

    @Select("select * from doctor_schedule where schedule_id=#{sid}")
    Schedules getScheduleById(Integer sid) throws SQLException;

    @Update("update doctor_schedule set visit_count=#{nums},is_available=#{wstate} where schedule_id=#{sid}")
    void updateSchedule(@Param("sid")String sid, @Param("nums")int nums, @Param("wstate")int wstate) throws SQLException;

    List<HaoByDepart> getScheduleListById(@Param("pid")String pid, @Param("cid")String cid,@Param("date")String date) throws SQLException;

    @Select("select * from doctor_schedule where department_id=#{departmentId} and date=#{date} and shift_time=#{time} order by visit_count desc limit 1")
    Schedules getMostHaoByDid(@Param("departmentId")Integer departmentId,@Param("date")String date,@Param("time")String time) throws SQLException;

    @Update("update doctor_schedule set visit_count=visit_count-1 where schedule_id=#{sid}")
    void deductCount(int sid) throws SQLException;
}

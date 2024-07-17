package com.hospital.mapper;

import com.hospital.pojo.Appointments;
import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.pojo.ConsultationsForPat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentsMapper {

    @Select("select max(appointment_id) from appointments")
    String getAppMax() throws SQLException;

    @Insert("insert into appointments(appointment_id,patient_id,doctor_id,appointment_date,appointment_time,status) values (#{aid},#{patid},#{doctorId},#{date},#{shiftTime},#{booked})")
    void addApp(@Param("aid")int aid,@Param("patid")int patid, @Param("doctorId")int doctorId, @Param("date")String date, @Param("shiftTime")String shiftTime, @Param("booked")String booked) throws SQLException;

    List<Appointments> getMyAppointment(@Param("patid")int patid) throws SQLException;

    @Update("update appointments set status='cancelled' where appointment_id=#{aid}")
    void cancelAppById(@Param("aid")String aid) throws SQLException;

    List<AppointmentsForDoc> getAppointmentList(@Param("docid")int docid) throws SQLException;

    @Update("update appointments set status='completed' where appointment_id=#{aid}")
    void completeApp(@Param("aid")String aid) throws SQLException;

    AppointmentsForDoc getAppForDocById(@Param("aid")String aid) throws SQLException;

    List<AppointmentsForDoc> getAppByState(@Param("state")String state,@Param("docid")String docid) throws SQLException;

}

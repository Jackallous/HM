package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Schedules;

import java.util.List;

public interface ScheduleService {
    PageInfo getScheduleList(String page, String did, String date);

    boolean addSchedule(String did, String sdate, List<Integer> departDocIdList);

    boolean deleteById(String sid);

    Schedules getScheduleById(String sid);

    boolean updateSchedule(String sid, String nums, String workstate);

    PageInfo getScheduleListById(String page, String pid, String cid,String date);

    Schedules getMostHaoByDid(Integer departmentId,String date,String time);

    boolean deductCount(Schedules schedules);

//    boolean addSchedule(String did, String sdate, List<Integer> departDocIdList);
}

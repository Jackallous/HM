package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.mapper.ProfessionalTitlesMapper;
import com.hospital.mapper.SchedulesMapper;
import com.hospital.pojo.Doctors;
import com.hospital.pojo.HaoByDepart;
import com.hospital.pojo.Schedules;
import com.hospital.service.DoctorService;
import com.hospital.service.ScheduleService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public PageInfo getScheduleList(String page, String did, String date) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<Schedules> slist = schedulesMapper.getScheduleList(did,date);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(slist);
            System.out.println("pageinfo"+pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean addSchedule(String did, String sdate, List<Integer> departDocIdList) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
//            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
//            String jobnumber = doctorsMapper.getJobNumberMax();
//            int jobNum = Integer.parseInt(jobnumber);
//            for(int i = 0;i<Integer.parseInt(num);i++) {
//                doctorsMapper.addDoctor(cid,++jobNum);
//            }
            //获取一个该科室下所属的医生的id列表,did一定不为空
//            List<Integer> departDocIdList = doctorService.getDepartDocIdList(Integer.valueOf(did));
            String sids = schedulesMapper.getScheduleIdMax();
            int sid = Integer.parseInt(sids);
            for (Integer i : departDocIdList) {

                schedulesMapper.addSchedule(++sid,i,Integer.valueOf(did),sdate,"上午");
                schedulesMapper.addSchedule(++sid,i,Integer.valueOf(did),sdate,"下午");

            }
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public boolean deleteById(String sid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            schedulesMapper.deleteById(sid);
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public Schedules getScheduleById(String sid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            Schedules schedule = schedulesMapper.getScheduleById(Integer.valueOf(sid));
            return schedule;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean updateSchedule(String sid, String nums, String workstate) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            if(nums != null && !"".equals(nums)){
                schedulesMapper.updateSchedule(sid,Integer.parseInt(nums),Integer.parseInt(workstate));
            }else{
                schedulesMapper.updateSchedule(sid,0,Integer.parseInt(workstate));
            }
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    //根据父科室id查询其子科室排号和科室的链接，并按照二级科室分组查询并计算每组visitcount的和
    @Override
    public PageInfo getScheduleListById(String page, String pid,String cid, String date) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<HaoByDepart> hlist = schedulesMapper.getScheduleListById(pid,cid,date);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(hlist);
            System.out.println("pageinfo"+pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public Schedules getMostHaoByDid(Integer departmentId,String date,String time) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            Schedules schedule = schedulesMapper.getMostHaoByDid(departmentId,date,time);
            return schedule;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean deductCount(Schedules schedules) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            int cnt = schedules.getVisitCount();
            int sid = schedules.getScheduleId();
            if(cnt > 0){
                schedulesMapper.deductCount(sid);
            }
            else{
                return false;
            }
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public PageInfo getScheduleListByDoc(String page, String pid, String cid, String date, String docname) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            SchedulesMapper schedulesMapper = sqlSession.getMapper(SchedulesMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<Schedules> slist = schedulesMapper.getScheduleListByDoc(pid,cid,date,docname);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(slist);
            System.out.println("pageinfo"+pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}


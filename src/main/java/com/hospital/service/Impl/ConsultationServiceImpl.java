package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.AppointmentsMapper;
import com.hospital.mapper.ConsultationsMapper;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.pojo.Consultations;
import com.hospital.pojo.ConsultationsForPat;
import com.hospital.service.ConsultationService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class ConsultationServiceImpl implements ConsultationService {

    @Override
    public boolean createConsultation(String patid, String docid, String adate, String hosregis, String hosif, String advice) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            ConsultationsMapper consultationsMapper = sqlSession.getMapper(ConsultationsMapper.class);
            String number = consultationsMapper.getIdMax();
            int Num = Integer.parseInt(number);
            System.out.println(patid+docid+adate+hosregis+hosif);
            consultationsMapper.createConsultation(++Num,Integer.valueOf(patid),Integer.valueOf(docid),adate,Integer.valueOf(hosregis),Integer.valueOf(hosif),advice);
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
    public PageInfo getMyConsultation(String page, String patid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            ConsultationsMapper consultationsMapper = sqlSession.getMapper(ConsultationsMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<ConsultationsForPat> clist = consultationsMapper.getMyConsultation(patid);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(clist);
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

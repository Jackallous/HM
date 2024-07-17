package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.AppointmentsMapper;
import com.hospital.mapper.BillsMapper;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.mapper.PatientsMapper;
import com.hospital.pojo.Bills;
import com.hospital.pojo.Doctors;
import com.hospital.service.BillService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class BillServiceImpl implements BillService {


    @Override
    public PageInfo getMyBill(String page, String patid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BillsMapper billsMapper = sqlSession.getMapper(BillsMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<Bills> blist = billsMapper.getMyBill(patid);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(blist);
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
    public boolean createBill(String patid, Integer docid, String billdate, Integer price, String type) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            BillsMapper billsMapper = sqlSession.getMapper(BillsMapper.class);
            String billnum = billsMapper.getBillMax();
            int bnum = Integer.parseInt(billnum);
            billsMapper.createBill(++bnum,Integer.valueOf(patid),docid,billdate,price,0,type);
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
    public Integer getPriceById(String billid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BillsMapper billsMapper = sqlSession.getMapper(BillsMapper.class);
            Integer balance = billsMapper.getPriceById(billid);
            return balance;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean payBill(String billid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            BillsMapper billsMapper = sqlSession.getMapper(BillsMapper.class);
            billsMapper.payBill(billid);
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


}

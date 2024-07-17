package com.hospital.service.Impl;

import com.hospital.mapper.ConsultationsMapper;
import com.hospital.mapper.HospitalizationsMapper;
import com.hospital.service.HospitalizationService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class HospitalizationServiceImpl implements HospitalizationService {

    @Override
    public boolean createHospitalization(String patid, String room, String fee, String pay, String insure, String hospitalstatus) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            HospitalizationsMapper hospitalizationsMapper = sqlSession.getMapper(HospitalizationsMapper.class);
            String number = hospitalizationsMapper.getIdMax();
            int Num = Integer.parseInt(number);
            hospitalizationsMapper.createHospitalization(++Num,Integer.valueOf(patid),room,fee,pay,Integer.valueOf(insure),hospitalstatus);
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

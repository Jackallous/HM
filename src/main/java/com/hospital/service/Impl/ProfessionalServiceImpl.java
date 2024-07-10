package com.hospital.service.Impl;

import com.hospital.mapper.ProfessionalTitlesMapper;
import com.hospital.pojo.ProfessionalTitles;
import com.hospital.service.ProfessionalService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProfessionalServiceImpl implements ProfessionalService {



    @Override
    public List<ProfessionalTitles> getProfessionalTitlesList() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            ProfessionalTitlesMapper professionalTitlesMapper = sqlSession.getMapper(ProfessionalTitlesMapper.class);
            return professionalTitlesMapper.getProfessionalTitlesList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}

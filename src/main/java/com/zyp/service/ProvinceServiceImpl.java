package com.zyp.service;

import com.zyp.dao.ProvinceDAO;
import com.zyp.entity.Province;
import com.zyp.util.MybatisUtil;

import java.util.List;

public class ProvinceServiceImpl implements  ProvinceService{
    @Override
    public List<Province> showProvinces() {
        ProvinceDAO provinceDAO = MybatisUtil.getSqlSession().getMapper(ProvinceDAO.class);
        List<Province> provinces = provinceDAO.selectAllProvinces();
        MybatisUtil.close();
        return  provinces;
    }
}

package com.zyp.service;

import com.zyp.dao.CityDAO;
import com.zyp.entity.City;
import com.zyp.util.MybatisUtil;

import java.util.List;

public class CityServiceImpl implements  CityService {
    @Override
    public List<City> showCitys(String provincecode) {
        CityDAO cityDAO = MybatisUtil.getSqlSession().getMapper(CityDAO.class);
        List<City> cities = cityDAO.showCitys(provincecode);
        MybatisUtil.close();
        return  cities;
    }
}

package com.zyp.dao;

import com.zyp.entity.City;

import java.util.List;

public interface CityDAO {
    //通过省份的code查询对应的市
    public List<City> showCitys(String provincecode);
}

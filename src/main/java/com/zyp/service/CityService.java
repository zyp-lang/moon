package com.zyp.service;

import com.zyp.entity.City;

import java.util.List;

public interface CityService {
    //通过省份code查询所有的市
    List<City>  showCitys(String provincecode);
}

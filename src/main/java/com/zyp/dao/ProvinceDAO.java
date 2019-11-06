package com.zyp.dao;

import com.zyp.entity.Province;

import java.util.List;

public interface ProvinceDAO {
    //查询所有省份
    public List<Province> selectAllProvinces();
}

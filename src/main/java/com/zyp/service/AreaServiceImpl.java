package com.zyp.service;

import com.zyp.dao.AreaDAO;
import com.zyp.entity.Area;
import com.zyp.util.MybatisUtil;

import java.util.List;

public class AreaServiceImpl implements  AreaService{
    @Override
    public List<Area> showAreas(String citycode) {
        AreaDAO areaDAO = MybatisUtil.getSqlSession().getMapper(AreaDAO.class);
        List<Area> areas = areaDAO.showAreas(citycode);
        MybatisUtil.close();
        return  areas;
    }
}

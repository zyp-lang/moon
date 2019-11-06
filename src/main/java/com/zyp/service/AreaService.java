package com.zyp.service;

import com.zyp.entity.Area;

import java.util.List;

public interface AreaService {
    //查询该城市对应的区县
    List<Area> showAreas(String citycode);
}

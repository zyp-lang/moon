package com.zyp.dao;

import com.zyp.entity.Area;

import java.util.List;

public interface AreaDAO {
    //通过市的code  查询所有的区和县
   List<Area> showAreas(String citycode);
}

package com.zyp.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.zyp.entity.Area;
import com.zyp.service.AreaService;
import com.zyp.service.AreaServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

//这是我在GitHub上做的修改

//这是我在本地上做的修改
public class AreaAction extends ActionSupport {
    //接受城市编号
    private String citycode;

    public String showAreas(){
        AreaService areaService=new AreaServiceImpl();
        List<Area> areas = areaService.showAreas(citycode);
        //list转换JSON
        String s = JSON.toJSONString(areas);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
}

package com.zyp.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.zyp.entity.City;
import com.zyp.service.CityService;
import com.zyp.service.CityServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class CityAction extends ActionSupport {
    //接受省份编号
    private String provincecode;

    public String showCitys(){
        //展示所有城市
        CityService cityService = new CityServiceImpl();
        List<City> list=cityService.showCitys(provincecode);
        //list转换JSON
        String s = JSON.toJSONString(list);
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

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
}

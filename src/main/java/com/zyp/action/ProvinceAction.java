package com.zyp.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.zyp.entity.Province;
import com.zyp.service.ProvinceService;
import com.zyp.service.ProvinceServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction extends ActionSupport {
    public String showProvinces(){
        //查询所有省份
        ProvinceService provinceService = new ProvinceServiceImpl();
        List<Province> provinces = provinceService.showProvinces();
        //list转换JSON、
        String s = JSON.toJSONString(provinces);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            //将JSON协议串响应给前台
            writer.print(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}

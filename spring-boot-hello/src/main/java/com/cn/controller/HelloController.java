package com.cn.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.List;

import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 * @program: spring-boot-example
 * @description: 控制层：helllocontroller
 * @author:
 * @create: 2018-04-28 10:49
 **/

@RestController
public class HelloController {

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author:
     * @Adress: http://localhost:8080/hello
     * @Date: 2018/4/28
     */
    @RequestMapping("hei")
    public ModelAndView hello() {
    	Map<String, Object> map = new HashMap<>();
    	Collection<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
    	//List<Map<String, Object>> dataList = new List<Map<String, Object>>();
    	ArrayList<Map> arr=new ArrayList<Map>();
    	Map map1 = new HashMap(); 
    	map1.put("title", "ddddd"); 
    	arr.add(map1);
    	map.put("users", new JRMapArrayDataSource (arr.toArray()));
    	map.put("title", "报表名称");
    	return new ModelAndView(new PdfReportView("resume.jasper", "professors"),map);
    	
        //return "Hello World!";
    }

}

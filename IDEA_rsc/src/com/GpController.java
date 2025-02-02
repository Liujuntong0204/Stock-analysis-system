package com;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GpController {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://CentOS_1:3306/stu";
    String user = "root2";
    String password = "123456";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,password);

    public List getGp(String startdate, String enddate, Integer pagenow, String gpName , String pagesize){
        Integer PAGESIZE = Integer.parseInt(pagesize);
        Integer start = (pagenow-1)*PAGESIZE;

        return abstractDao.getMaps("stock1","*","date>"+startdate+" and date<"+enddate+" and name="+"'"+gpName+"'",start.toString(),PAGESIZE.toString());
    }

    public List<List<Map<String, Object>>> getStock(String startdate, String enddate, Integer pagenow, String gpname,String gpname1) {
        Integer pagesize = 50;
        Integer start = (pagenow - 1) * pagesize;

        List<List<Map<String, Object>>> results = new ArrayList<>();

        List<Map<String, Object>> result = abstractDao.getMaps("stock1","*","date > '" + startdate + "' AND date < '" + enddate + "' AND name = '" + gpname + "'",start.toString(),"50");

        results.add(result);

        List<Map<String, Object>> result1 = abstractDao.getMaps("stock1","*","date > '" + startdate + "' AND date < '" + enddate + "' AND name = '" + gpname1 + "'",start.toString(),"50");
        results.add(result1);


        return results;
    }

    public List get(String date){
        return abstractDao.getMaps("stock1","*","date = " + date);
    }


}

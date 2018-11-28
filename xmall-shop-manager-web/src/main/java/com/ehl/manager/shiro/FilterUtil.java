package com.ehl.manager.shiro;


import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @className:FilterUtil
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 11:47
 */
public class FilterUtil {
    private static final Logger logger =Logger.getLogger(FilterUtil.class);

    /**
     * create by: 王明飞 102365
     * description:判断方法是否为ajax请求
     * create time:2018/11/28 11:52 
     * @param 
     * @return 
     */
    public static boolean isAjax(ServletRequest request)
    {
        String httpRequest = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(httpRequest))
        {
            return true;
        }else
        {
            return false;
        }
    }


    /**
     * create by: 王明飞 102365
     * description:使用response输出json
     * create time:2018/11/28 11:57 
     * @param 
     * @return 
     */
    public static void out(ServletResponse response, Map<String, Object> resultMap)
    {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(new Gson().toJson(resultMap));
        } catch (Exception e) {
            logger.error(e + "输出JSON出错");
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
        
    }
}

package com.ehl.manager.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @className:MyPermissionFilter
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 11:32
 */
public class MyPermissionFilter extends AuthorizationFilter {

    private static final Logger logger= Logger.getLogger(MyPermissionFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = this.getSubject(request,response);

        String[] perms = (String[]) ((String[]) o);
        String username = subject.getPrincipal().toString();

        boolean isPermitted = true;

        if(username==null)
        {
            if(FilterUtil.isAjax(request))
            {
                logger.info("未登录或登录时间过长,是ajax！");
                Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("success",false);
                resultMap.put("message","您还未登录或登录时间过长,请重新登录！");
                FilterUtil.out(response,resultMap);
            }else
            {
                logger.info("未登录或登录时间过长,不是ajax！");
                this.saveRequestAndRedirectToLogin(request,response);

            }
        }else {
            if(perms!=null&&perms.length>0)
            {
                if(perms.length==1)
                {
                    if(!subject.isPermitted(perms[0]))
                    {

                        isPermitted=false;
                    }
                }else if (!subject.isPermittedAll(perms))
                {
                    isPermitted=false;
                }

            }
            if(!isPermitted)
            {
                if(FilterUtil.isAjax(request))
                {
                    logger.info("没有该权限，且是ajax请求");
                    Map<String,Object> resultMap = new HashMap<>();
                    resultMap.put("success",false);
                    resultMap.put("message","抱歉，您没有该权限！看就看，你点它干什么...");
                    FilterUtil.out(response,resultMap);
                }else {
                    return isPermitted;
                }

            }

        }

        return isPermitted;
    }
}

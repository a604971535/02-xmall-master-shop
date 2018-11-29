package com.ehl.manager.controller;

import com.ehl.common.bean.Result;
import com.ehl.common.utils.GeetestLib;
import com.ehl.common.utils.ResultUtil;
import com.ehl.xmall.bean.TbUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @className:UserController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 15:03
 */
@RestController
@RequestMapping("/user")
@Api(description = "管理员管理")
public class UserController {

    /**
     * create by: 王明飞 102365
     * description:获取用户信息
     * create time:2018/11/28 22:26 
     * @param 
     * @return 
     */

    @Value("${geetest_id}")
    private String geetest_id;

    @Value("${geetest_key}")
    private String geetest_key;

    @Value("${newfailback}")
    private boolean newfailback;

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public Result<TbUser> getUserInfo()
    {
        return null;
    }

    
    /**
     * create by: 王明飞 102365
     * description:极验控件初始化，参考官方实例StartCaptchaServlet方法
     * create time:2018/11/28 22:48 
     * @param
     * @return
     */
    @RequestMapping(value = "/geetestInit",method = RequestMethod.GET)
    @ApiOperation(value = "极验初始化")
    public String geetesrInit(HttpServletRequest request)
    {
        GeetestLib gtSdk = new GeetestLib(geetest_id, geetest_key,
                newfailback);

        String resStr = "{}";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);

        resStr = gtSdk.getResponseStr();


        return resStr;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口")
    public Result<Object> login(String username, String password,
                                String challenge,String validate,String seccode,
                                HttpServletRequest request)
    {

        GeetestLib gtSdk = new GeetestLib(geetest_id, geetest_key, newfailback);
        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证

            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
            System.out.println(gtResult);
        } else {
            // gt-server非正常情况下，进行failback模式验证

            System.out.println("failback:use your own server captcha validate");
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
            System.out.println(gtResult);
        }


        if (gtResult == 1) {
            // 极验验证成功
            Subject subject = SecurityUtils.getSubject();
            //MD5加密
            String md5Psd = DigestUtils.md5DigestAsHex(password.getBytes());

            UsernamePasswordToken token = new UsernamePasswordToken(username,md5Psd);

            try {
                subject.login(token);
                return new ResultUtil<Object>().setData(null);
            }catch (Exception e)
            {
                return new ResultUtil<Object>().setErrorMsg("用户名或密码错误");
            }
        }
        else {
            // 极验验证失败
                return new ResultUtil<Object>().setErrorMsg("极验验证失败");
        }

    }
}

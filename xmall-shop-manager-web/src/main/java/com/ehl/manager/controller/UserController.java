package com.ehl.manager.controller;

import com.ehl.common.bean.Result;
import com.ehl.xmall.bean.TbUser;
import com.ehl.xmall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:UserController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 15:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public Result<TbUser> getUserInfo()
    {
        return null;

    }
}

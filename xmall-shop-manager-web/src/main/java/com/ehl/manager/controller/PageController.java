package com.ehl.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @className:PageController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/24 16:50
 */
@Controller
@Api(description = "页面跳转")
public class PageController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(value = "首页跳转接口")
    public String showIndex()
    {
        return "index";
    }

    @RequestMapping(value = "/{page}",method = RequestMethod.GET)
    @ApiOperation(value = "其他页面跳转")
    public String showPage(@PathVariable String page)
    {
        return page;
    }
}

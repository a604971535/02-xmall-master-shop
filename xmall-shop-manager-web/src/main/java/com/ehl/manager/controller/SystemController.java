package com.ehl.manager.controller;

import com.ehl.common.bean.Result;
import com.ehl.common.utils.IPInfoUtil;
import com.ehl.common.utils.ResultUtil;
import com.ehl.xmall.bean.TbBase;
import com.ehl.xmall.bean.TbOrderItem;
import com.ehl.xmall.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @className:SystemController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 23:34
 */
@RestController
@RequestMapping("/sys")
@Api(description = "系统管理")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/base",method = RequestMethod.GET)
    @ApiOperation(value = "获取基本信息接口")
    public Result<TbBase> getBase(){

        TbBase tbBase = systemService.getBase();
        return new ResultUtil<TbBase>().setData(tbBase);
    }

    @RequestMapping(value = "/weekHot",method = RequestMethod.GET)
    @ApiOperation(value = "获取本周热销商品")
    public Result<TbOrderItem> getWeekHotItem()
    {
        TbOrderItem weekHotItem = systemService.getWeekHotItem();

        return new ResultUtil<TbOrderItem>().setData(weekHotItem);
    }

    @ApiOperation(value = "获取天气信息接口")
    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    public Result<Object> getWeather(HttpServletRequest request)
    {
        String weather = IPInfoUtil.getIpInfo(IPInfoUtil.getIpAddr(request));

        return new ResultUtil<Object>().setData(weather);
    }
}

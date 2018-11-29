package com.ehl.manager.controller;

import com.ehl.common.bean.Result;
import com.ehl.common.utils.ResultUtil;
import com.ehl.xmall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:OrderController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 19:52
 */
@RestController
@RequestMapping("/order")
@Api(description = "订单管理")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ApiOperation(value = "查询订单总数接口")
    public Result<Object> getAllOrderCount()
    {
        long orderCount = orderService.getAllOrderCount();
        return new ResultUtil<Object>().setData(orderCount);
    }
}

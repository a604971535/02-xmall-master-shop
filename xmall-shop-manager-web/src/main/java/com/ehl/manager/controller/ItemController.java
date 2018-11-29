package com.ehl.manager.controller;

import com.ehl.common.bean.DataTablesResult;
import com.ehl.xmall.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:ItemController
 * @description:商品
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 14:04
 */
@RestController
@RequestMapping("/item")
@Api(description = "商品列表信息")
public class ItemController {


    @Autowired
    ItemService itemService;

    @ApiOperation(value = "获取商品总数")
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public DataTablesResult getAllItemCount()
    {
        DataTablesResult itemCount = itemService.getAllItemCount();
        return itemCount;
    }
}

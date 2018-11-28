package com.ehl.manager.controller;

import com.ehl.common.bean.Result;
import com.ehl.common.utils.ResultUtil;
import com.ehl.xmall.bean.TbBase;
import com.ehl.xmall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:SystemController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 23:34
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/base",method = RequestMethod.GET)
    public Result<TbBase> getBase(){

        TbBase tbBase = systemService.getBase();
        return new ResultUtil<TbBase>().setData(tbBase);
    }
}

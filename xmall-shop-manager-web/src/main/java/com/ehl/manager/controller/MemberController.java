package com.ehl.manager.controller;

import com.ehl.common.bean.DataTablesResult;
import com.ehl.xmall.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:MemberController
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 19:48
 */
@RestController
@RequestMapping(value = "/member")
@Api(description = "会员管理")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ApiOperation(value = "查询会员总数接口")
    public DataTablesResult getAllMemberCount()
    {
        DataTablesResult memberCount = memberService.getAllMemberCount();

        return memberCount;

    }
}

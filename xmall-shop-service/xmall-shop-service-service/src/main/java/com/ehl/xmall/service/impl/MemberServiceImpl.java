package com.ehl.xmall.service.impl;

import com.ehl.common.bean.DataTablesResult;
import com.ehl.xmall.bean.TbMemberExample;
import com.ehl.xmall.mapper.TbMemberMapper;
import com.ehl.xmall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className:MemberServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 19:39
 */
public class MemberServiceImpl implements MemberService {

    @Autowired
    TbMemberMapper memberMapper;

    @Override
    public DataTablesResult getAllMemberCount() {

        TbMemberExample example = new TbMemberExample();
        long count = memberMapper.countByExample(example);
        DataTablesResult result = new DataTablesResult();
        result.setRecordsTotal(Math.toIntExact(count));
        return result;
    }
}

package com.ehl.xmall.service.impl;

import com.ehl.common.exception.XmallException;
import com.ehl.xmall.bean.TbShiroFilter;
import com.ehl.xmall.bean.TbShiroFilterExample;
import com.ehl.xmall.mapper.TbShiroFilterMapper;
import com.ehl.xmall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @className:SystemServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 14:42
 */
public class SystemServiceImpl implements SystemService {

    @Autowired
    TbShiroFilterMapper shiroFilterMapper;

    @Override
    public List<TbShiroFilter> getShiroFilter() {

        TbShiroFilterExample shiroFilterExample = new TbShiroFilterExample();
        shiroFilterExample.setOrderByClause("sort_order");
        List<TbShiroFilter> shiroFilterList = shiroFilterMapper.selectByExample(shiroFilterExample);

        if(shiroFilterList==null)
        {
            throw new XmallException("获取shiro过滤链失败");
        }

        return shiroFilterList;
    }
}

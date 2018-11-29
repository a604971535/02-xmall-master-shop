package com.ehl.xmall.service.impl;

import com.ehl.common.exception.XmallException;
import com.ehl.xmall.bean.*;
import com.ehl.xmall.mapper.TbBaseMapper;
import com.ehl.xmall.mapper.TbItemMapper;
import com.ehl.xmall.mapper.TbOrderItemMapper;
import com.ehl.xmall.mapper.TbShiroFilterMapper;
import com.ehl.xmall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className:SystemServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 14:42
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    TbShiroFilterMapper shiroFilterMapper;

    @Autowired
    TbBaseMapper baseMapper;

    @Autowired
    TbOrderItemMapper orderItemMapper;

    @Value("${BASEID}")
    private Integer baseId;

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

    @Override
    public TbBase getBase() {

        TbBase tbBase = baseMapper.selectByPrimaryKey(baseId);
        if(tbBase==null)
        {
            throw new XmallException("获取基本信息失败");
        }
        return tbBase;
    }

    @Override
    public TbOrderItem getWeekHotItem() {


        List<TbOrderItem> list = orderItemMapper.getWeekHotItem();

        if(list==null){
            throw new XmallException("获取热销商品数据失败");
        }
        if(list.size()==0){
            TbOrderItem tbOrderItem=new TbOrderItem();
            tbOrderItem.setTotal(0);
            tbOrderItem.setTitle("暂无数据");
            tbOrderItem.setPicPath("");
            return tbOrderItem;
        }
        return list.get(0);
    }
}

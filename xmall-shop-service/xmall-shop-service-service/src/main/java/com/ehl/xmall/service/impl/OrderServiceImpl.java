package com.ehl.xmall.service.impl;

import com.ehl.xmall.bean.TbOrderExample;
import com.ehl.xmall.bean.TbOrderItem;
import com.ehl.xmall.mapper.TbOrderMapper;
import com.ehl.xmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className:OrderServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 19:41
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    TbOrderMapper orderMapper;

    @Override
    public long getAllOrderCount() {
        TbOrderExample example = new TbOrderExample();
        long count = orderMapper.countByExample(example);
        return count;
    }
}

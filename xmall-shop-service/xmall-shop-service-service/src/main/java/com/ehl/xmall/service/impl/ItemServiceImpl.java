package com.ehl.xmall.service.impl;

import com.ehl.common.bean.DataTablesResult;
import com.ehl.xmall.bean.TbItemExample;
import com.ehl.xmall.mapper.TbItemMapper;
import com.ehl.xmall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className:ItemServiceImpl
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/29 17:18
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    TbItemMapper itemMapper;

    @Override
    public DataTablesResult getAllItemCount() {
        TbItemExample example = new TbItemExample();
        long count = itemMapper.countByExample(example);
        DataTablesResult result = new DataTablesResult();
        result.setRecordsTotal(Math.toIntExact(count));
        return result;
    }
}

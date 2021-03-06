package com.ehl.xmall.service;

import com.ehl.xmall.bean.TbBase;
import com.ehl.xmall.bean.TbItem;
import com.ehl.xmall.bean.TbOrderItem;
import com.ehl.xmall.bean.TbShiroFilter;

import java.util.List;

/**
 * @className:SystemService
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/28 13:09
 */
public interface SystemService {

    List<TbShiroFilter> getShiroFilter();

    TbBase getBase();

    TbOrderItem getWeekHotItem();
}

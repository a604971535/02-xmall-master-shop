package com.ehl.xmall.mapper;

import java.util.List;

import com.ehl.xmall.bean.TbBase;
import com.ehl.xmall.bean.TbBaseExample;
import org.apache.ibatis.annotations.Param;

public interface TbBaseMapper {
    long countByExample(TbBaseExample example);

    int deleteByExample(TbBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbBase record);

    int insertSelective(TbBase record);

    List<TbBase> selectByExample(TbBaseExample example);

    TbBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByExample(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByPrimaryKeySelective(TbBase record);

    int updateByPrimaryKey(TbBase record);
}
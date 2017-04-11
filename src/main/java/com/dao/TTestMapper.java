package com.dao;

import com.model.TTest;
import com.model.TTestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTestMapper {
    long countByExample(TTestExample example);

    int deleteByExample(TTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTest record);

    int insertSelective(TTest record);

    List<TTest> selectByExample(TTestExample example);

    TTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTest record, @Param("example") TTestExample example);

    int updateByExample(@Param("record") TTest record, @Param("example") TTestExample example);

    int updateByPrimaryKeySelective(TTest record);

    int updateByPrimaryKey(TTest record);
}
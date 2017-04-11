package com.dao;

import com.model.TGirl;
import com.model.TGirlExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGirlMapper {
    long countByExample(TGirlExample example);

    int deleteByExample(TGirlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGirl record);

    int insertSelective(TGirl record);

    List<TGirl> selectByExample(TGirlExample example);

    TGirl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGirl record, @Param("example") TGirlExample example);

    int updateByExample(@Param("record") TGirl record, @Param("example") TGirlExample example);

    int updateByPrimaryKeySelective(TGirl record);

    int updateByPrimaryKey(TGirl record);
}
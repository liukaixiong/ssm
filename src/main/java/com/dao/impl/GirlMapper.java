package com.dao.impl;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.model.TGirlExample;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liukx
 * @create 2018-03-22 14:55
 * @email liukx@elab-plus.com
 **/
@Primary
@Service("girlMapperImpl")
public class GirlMapper implements TGirlMapper {

    @Override
    public long countByExample(TGirlExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TGirlExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TGirl record) {
        return 0;
    }

    @Override
    public int insertSelective(TGirl record) {
        return 0;
    }

    @Override
    public List<TGirl> selectByExample(TGirlExample example) {
        System.out.println("=======================执行了实现的方法=============================");
        return null;
    }

    @Override
    public TGirl selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(TGirl record, TGirlExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TGirl record, TGirlExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TGirl record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TGirl record) {
        return 0;
    }
}

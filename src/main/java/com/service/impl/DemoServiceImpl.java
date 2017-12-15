package com.service.impl;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.model.TGirlExample;
import com.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
@Service("demoService")
public class DemoServiceImpl implements IDemoService {

    public DemoServiceImpl(){
        System.out.println("==========================");
    }

    @Autowired
    private TGirlMapper girlMapper;

    public void test(String s) throws Exception {
        TGirlExample example = new TGirlExample();
        List<TGirl> tGirls = girlMapper.selectByExample(example);
        System.out.println("===========>"+tGirls.size());
        System.out.println("----------------->" + s);
    }
}

package com.service.impl;

import com.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
@Service("demoService")
public class DemoServiceImpl implements IDemoService,Ordered {

    public DemoServiceImpl(){
        System.out.println("==========================");
    }

    @Override
    public int getOrder() {
        System.out.println("获取级别 : DemoServiceImpl");
        return 2;
    }


    //    @Autowired
//    private TGirlMapper girlMapper;

//    @Qualifier("demoService2")
    @Autowired
    private IDemoService demoService;

    public void test(String s) throws Exception {
//        TGirlExample example = new TGirlExample();
//        List<TGirl> tGirls = girlMapper.selectByExample(example);
//        System.out.println("===========>"+tGirls.size());
        System.out.println("DemoServiceImpl----------------->" + s);
    }
}

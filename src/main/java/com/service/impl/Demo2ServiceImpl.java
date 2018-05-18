package com.service.impl;

import com.service.IDemoService;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
@Service("demoService2")
public class Demo2ServiceImpl implements IDemoService,Ordered {

    public Demo2ServiceImpl(){
        System.out.println("==========================");
    }

//    @Autowired
//    private TGirlMapper girlMapper;

    @Override
    public int getOrder() {
        return 1;
    }

    public void test(String s) throws Exception {
//        TGirlExample example = new TGirlExample();
//        List<TGirl> tGirls = girlMapper.selectByExample(example);
//        System.out.println("===========>"+tGirls.size());
//        System.out.println("----------------->" + s);
    }
}

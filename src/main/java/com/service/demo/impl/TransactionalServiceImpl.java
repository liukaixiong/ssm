package com.service.demo.impl;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.service.demo.ITransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实现性Demo接口实现
 *
 * @author Liukx
 * @create 2017-07-28 10:12
 * @email liukx@elab-plus.com
 **/
@Service("transactionalService")
public class TransactionalServiceImpl implements ITransactionalService {

    @Autowired
    private TGirlMapper girlMapper;
//    @Autowired
//    private DataSourceTransactionManager transactionManager;

    //    @MultiTransactional(values = {DataSource.mvp, DataSource.system})
    @Transactional
    public void testTransactional() throws Exception {
        System.out.println("=====================开始处理MVP");
        TGirl girl = new TGirl();
        girl.setAge(11);
//        girl.setGirl_name("hah");
        girl.setStatus(1);
        int insert = girlMapper.insert(girl);
        System.out.println("=====================结束处理MVP");
        System.out.println("处理完成...");
//        int i = 1 / 0;
    }


    public void testQuery() throws Exception {
        System.out.println("执行完毕..");
    }
}

package com.service.demo.impl;

import com.dao.TGirlMapper;
import com.model.TGirl;
import com.model.TGirlExample;
import com.service.IDemoService;
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

    @Autowired
    private IDemoService demoService;

    public TransactionalServiceImpl() {
        System.out.println("初始化 - TransactionalServiceImpl");
    }

//    @Autowired
//    private DataSourceTransactionManager transactionManager;

    //    @MultiTransactional(values = {DataSource.mvp, DataSource.system})
    @Transactional
    public void testTransactional() throws Exception {
//        System.out.println("=====================开始处理MVP");
//        TGirl girl = new TGirl();
//        girl.setAge(11);
////        girl.setGirl_name("hah");
//        girl.setStatus(1);
//        int insert = girlMapper.insert(girl);
//        System.out.println("=====================结束处理MVP");
//        System.out.println("处理完成...");
        TGirl girl1 = girlMapper.selectByPrimaryKey(7);
        System.out.println("================================执行完成000000000000000");
//        TTest test = girl1.getTest();
//        List<TTest> testList = girl1.getTestList();
//        System.out.println("================================执行完成1111111 -->" + test);
//        girlMapper.selectByPrimaryKey(7);
//        System.out.println("================================222222222222222");
//        int i = 1 / 0;
    }


    public void testQuery() throws Exception {
        System.out.println("执行完毕..");
        TGirlExample example = new TGirlExample();
        example.createCriteria().andStatusEqualTo(1);
        TGirl girl1 = girlMapper.selectByPrimaryKey(7);
        System.out.println("================================执行完成000000000000000");
//        girlMapper.selectByPrimaryKey(2);
//        girl1.getStatus();
//        girl1.getTest();
        System.out.println("================================执行完成1111111");
//        girlMapper.selectByPrimaryKey(2);
//        System.out.println("================================222222222222222");
    }
}

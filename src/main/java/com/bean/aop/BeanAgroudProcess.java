package com.bean.aop;

import com.bean.anno.Autowired2;
import com.model.TGirl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * bean的初始化和销毁的方法
 *
 * @author Liukx
 * @create 2018-03-15 9:56
 * @email liukx@elab-plus.com
 **/
@Service
public class BeanAgroudProcess implements InitializingBean, DisposableBean {


    @Autowired2
    private TGirl girl;

    public BeanAgroudProcess() {
        System.out.println("-------------BeanAgroudProcess new--------------");
    }


    //    @Autowired
//    private TGirl girl2;

    @PostConstruct
    public void initMethod() {
        System.out.println("=========BeanAgroudProcess - 初始化方法=========");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========BeanAgroudProcess - afterPropertiesSet=========");
    }

    @PreDestroy
    public void distoryMethod() {
        System.out.println("=========BeanAgroudProcess - 销毁该方法===========");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("==================DisposableBean distory ======================");
    }

    public void invokeMethod() {
        System.out.println("执行BeanAgroudProcess的invokeMehtod方法");
    }

}

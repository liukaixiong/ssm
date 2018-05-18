package com.bean;

import com.bean.aop.BeanAgroudProcess;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * bean的初始化流程
 *
 * @author Liukx
 * @create 2018-03-14 16:36
 * @email liukx@elab-plus.com
 **/
@Service("beanInitProcess")
public class BeanInitProcess extends InstantiationAwareBeanPostProcessorAdapter implements BeanFactoryPostProcessor, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    //, InstantiationAwareBeanPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("4. ===============BeanFactoryPostProcessor = postProcessBeanFactory===================");
    }

    /**
     * 在对象实例化之前被触发,可自定义处理逻辑,比如返回一个代理对象等等,如果返回对象不为null , 则中断Spring创建对象的后续执行
     * <p>
     * 在实例化目标对象之前执行，可以自定义实例化逻辑，如返回一个代理对象等，
     * （3.1处执行；如果此处返回的Bean不为null将中断后续Spring创建Bean的流程，
     * 且只执行postProcessAfterInitialization回调方法，
     * 如当AbstractAutoProxyCreator的实现者注册了TargetSourceCreator
     * （创建自定义的TargetSource）将改变执行流程，
     * 不注册TargetSourceCreator我们默认使用的是SingletonTargetSource
     * （即AOP代理直接保证目标对象），此处我们还可以使用如ThreadLocalTargetSource
     * （线程绑定的Bean）、CommonsPoolTargetSource（实例池的Bean）等等，
     * 大家可以去spring官方文档了解TargetSource详情；
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("5. ===============InstantiationAwareBeanPostProcessor = postProcessBeforeInstantiation===================" + beanName + " [ class 阶段 ]");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("6. ===============InstantiationAwareBeanPostProcessor = postProcessAfterInstantiation===================[ 实例化阶段 ]");
        }
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3. ==========================ApplicationContextAware - setApplicationContext==========================");
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("7. ===============InstantiationAwareBeanPostProcessor = postProcessPropertyValues===================[ 属性注入阶段 ]");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("8. ===============BeanPostProcessor = postProcessBeforeInitialization===================[实例化完成阶段(这个时候已经拿到了实例完成的bean了,可以做一些代理)]");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("9. ===============BeanPostProcessor = postProcessAfterInitialization===================" + beanName + " [实例化完成之后的后置处理阶段(通常进入到这里说明bean已经被代理了)]");
        }
        return bean;
    }

    @Override
    public void setBeanName(String name) {
//        if (isBeanName(name)) {
        System.out.println("1. ===============BeanNameAware - setBeanName : " + name + "===================");
//        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("2. =====================BeanFactoryAware-setBeanFactory===================");
    }

    public void process(ApplicationContext applicationContext) {
        System.out.println("-----------------普通的执行方法----------------");
        BeanAgroudProcess agroudProcess = (BeanAgroudProcess) applicationContext.getBean("beanAgroudProcess");
        agroudProcess.invokeMethod();
    }

    private boolean isBeanName(String beanName) {
        if ("beanAgroudProcess".equals(beanName)) {
            return true;
        }
        return false;
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
        if (isBeanName(beanName)) {
            System.out.println("=======================SmartInstantiationAwareBeanPostProcessor - predictBeanType=====================");
        }
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("=======================SmartInstantiationAwareBeanPostProcessor - determineCandidateConstructors=====================");
        }
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if (isBeanName(beanName)) {
            System.out.println("=======================SmartInstantiationAwareBeanPostProcessor - getEarlyBeanReference=====================");
        }
        return super.getEarlyBeanReference(bean, beanName);
    }



    public static void main(String[] args) {
        BeanInitProcess process = new BeanInitProcess();

        String xml[] = {"classpath:dtms-spring/bean-service.xml"};

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
//        BeanInitProcess beanInitProcess = (BeanInitProcess) applicationContext.getBean("beanInitProcess");
//        beanInitProcess.process();
        process.process(applicationContext);
        applicationContext.close();
//        agroudProcess.invokeMethod();
    }
}

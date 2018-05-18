package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.Ordered;

/**
 * beanDefinition初始化顺序
 *
 * @author Liukx
 * @create 2018-03-15 16:24
 * @email liukx@elab-plus.com
 **/
//@Service
public class BeanDifinitionInit extends InstantiationAwareBeanPostProcessorAdapter implements BeanDefinitionRegistryPostProcessor, MergedBeanDefinitionPostProcessor, Ordered {


    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("--------------------postProcessBeanDefinitionRegistry---------------" + registry.getBeanDefinitionNames());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("--------------------postProcessBeanFactory---------------");
    }

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println("--------------------postProcessMergedBeanDefinition---------------------------");
    }
}

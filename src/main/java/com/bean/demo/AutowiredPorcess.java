package com.bean.demo;

import com.bean.anno.Autowired2;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 自定义注解
 *
 * @author Liukx
 * @create 2018-03-15 18:26
 * @email liukx@elab-plus.com
 **/
@Service
public class AutowiredPorcess extends InstantiationAwareBeanPostProcessorAdapter implements MergedBeanDefinitionPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Set<Class<? extends Annotation>> annotationSet = new HashSet<>();

    public AutowiredPorcess() {
        annotationSet.add(Autowired2.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        InjectionMetadata metadata = findAutowiringMetadata(beanName, bean.getClass(), pvs);
        try {
            metadata.inject(bean, beanName, pvs);
        } catch (Throwable ex) {
            throw new BeanCreationException(beanName, "Injection of autowired dependencies failed", ex);
        }
        return pvs;
    }

    /**
     * 处于BeanDefinition的时候触发的回调方法
     *
     * @param beanDefinition
     * @param beanType
     * @param beanName
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        InjectionMetadata metadata = findAutowiringMetadata(beanName, beanType, null);
        metadata.checkConfigMembers(beanDefinition);
    }

    private InjectionMetadata findAutowiringMetadata(String beanName, Class<?> beanType, Object o) {

        LinkedList<InjectionMetadata.InjectedElement> elements = new LinkedList<InjectionMetadata.InjectedElement>();
        Class<?> targetClazz = beanType;

        for (Field filed : targetClazz.getDeclaredFields()) {
            AnnotationAttributes autowiredAnnotation = findAutowiredAnnotation(filed);
            if (autowiredAnnotation != null) {
                elements.add(new AutowiredFieldElement(filed, true));
            }
        }
        return new InjectionMetadata(targetClazz, elements);
    }

    private AnnotationAttributes findAutowiredAnnotation(AccessibleObject ao) {
        for (Class<? extends Annotation> type : this.annotationSet) {
            AnnotationAttributes ann = AnnotatedElementUtils.getAnnotationAttributes(ao, type.getName());
            if (ann != null) {
                return ann;
            }
        }
        return null;
    }

    /**
     * Class representing injection information about an annotated field.
     */
    private class AutowiredFieldElement extends InjectionMetadata.InjectedElement {

        private final boolean required;

        private volatile boolean cached = false;

        private volatile Object cachedFieldValue;

        public AutowiredFieldElement(Field field, boolean required) {
            super(field, null);
            this.required = required;
        }

        @Override
        protected void inject(Object bean, String beanName, PropertyValues pvs) throws Throwable {
            Field field = (Field) this.member;
            DependencyDescriptor desc = new DependencyDescriptor(field, this.required);
            Object value = applicationContext.getBeansOfType(desc.getDependencyType()).get(field.getName());
            if (value != null) {
                ReflectionUtils.makeAccessible(field);
                field.set(bean, value);
            }
        }
    }


}

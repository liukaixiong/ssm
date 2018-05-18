package spring.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.ibatis.executor.loader.ProxyFactory;
import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.executor.loader.WriteReplaceInterface;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * 代理工厂
 *
 * @author Liukx
 * @create 2018-02-02 19:59
 * @email liukx@elab-plus.com
 **/
public class MyProxyFactory implements ProxyFactory {

    final static Logger log = LoggerFactory.getLogger(MyProxyFactory.class);

    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private static Object crateProxy(Class<?> type, Callback callback, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(callback);
        enhancer.setSuperclass(type);

        try {
            type.getDeclaredMethod("writeReplace", new Class[0]);
            log.debug("writeReplace method was found on bean " + type + ", make sure it returns this");
        } catch (NoSuchMethodException var8) {
            enhancer.setInterfaces(new Class[]{WriteReplaceInterface.class});
        } catch (SecurityException var9) {
            ;
        }

        Object enhanced = null;
        if (constructorArgTypes.isEmpty()) {
            enhanced = enhancer.create();
        } else {
            Class[] typesArray = (Class[]) constructorArgTypes.toArray(new Class[constructorArgTypes.size()]);
            Object[] valuesArray = constructorArgs.toArray(new Object[constructorArgs.size()]);
            enhanced = enhancer.create(typesArray, valuesArray);
        }
        return enhanced;
    }

    @Override
    public Object createProxy(Object o, ResultLoaderMap resultLoaderMap, Configuration configuration, ObjectFactory objectFactory, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return MyProxyFactory.EnhancedResultObjectProxyImpl.createProxy(o, resultLoaderMap, configuration, objectFactory, constructorArgTypes, constructorArgs);
    }

    private static class EnhancedResultObjectProxyImpl implements MethodInterceptor {

        private Class<?> type;
        private ResultLoaderMap lazyLoader;
        private boolean aggressive;
        private Set<String> lazyLoadTriggerMethods;
        private ObjectFactory objectFactory;
        private List<Class<?>> constructorArgTypes;
        private List<Object> constructorArgs;

        private EnhancedResultObjectProxyImpl(Class<?> type, ResultLoaderMap lazyLoader, Configuration configuration, ObjectFactory objectFactory, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
            this.type = type;
            this.lazyLoader = lazyLoader;
            this.aggressive = configuration.isAggressiveLazyLoading();
            this.lazyLoadTriggerMethods = configuration.getLazyLoadTriggerMethods();
            this.objectFactory = objectFactory;
            this.constructorArgTypes = constructorArgTypes;
            this.constructorArgs = constructorArgs;
        }

        public static Object createProxy(Object target, ResultLoaderMap lazyLoader, Configuration configuration, ObjectFactory objectFactory, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
            Class type = target.getClass();
            MyProxyFactory.EnhancedResultObjectProxyImpl callback = new MyProxyFactory.EnhancedResultObjectProxyImpl(type, lazyLoader, configuration, objectFactory, constructorArgTypes, constructorArgs);
            Object enhanced = MyProxyFactory.crateProxy(type, callback, constructorArgTypes, constructorArgs);
            PropertyCopier.copyBeanProperties(type, target, enhanced);
            return enhanced;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            methodProxy.invokeSuper(o, objects);
            return null;
        }
    }
}

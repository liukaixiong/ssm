package com.aop;

import com.dto.BaseInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 校验切入点管理
 *
 * @author Liukx
 * @create 2017-04-10 13:41
 * @email liukx@elab-plus.com
 **/
//@Aspect
//@Component
public class ValidatorAOP {

    @Autowired
    private Validator validator;

    //声明AOP切入点，凡是使用了XXXOperateLog的方法均被拦截
    @Pointcut("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void validMethodPointcut() {

    }

    //在执行目标方法的过程中，会执行这个方法，可以在这里实现具体的业务
    @Around("validMethodPointcut()")
    public Object validMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation[] annotationList = method.getAnnotations();
        for (Annotation anno : annotationList) {
            System.out.println(ResponseBody.class.isInstance(anno));
        }
        Annotation[][] argAnnotations = method.getParameterAnnotations();
        String[] argNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (hasRequestBodyAndValidAnnotations(argAnnotations[i])) {
                Object ret = validateArg(args[i], argNames[i]);
                if (ret != null) {
                    return ret;
                }
            }
        }
        return joinPoint.proceed(args);
    }

    private boolean hasRequestBodyAndValidAnnotations(Annotation[] annotations) {
        if (annotations.length < 2)
            return false;

        boolean hasValid = false;
        boolean hasRequestBody = false;

        for (Annotation annotation : annotations) {
            if (Valid.class.isInstance(annotation))
                hasValid = true;
            else if (RequestBody.class.isInstance(annotation))
                hasRequestBody = true;

            if (hasValid && hasRequestBody)
                return true;
        }
        return false;
    }


    private BaseInfo validateArg(Object arg, String argName) {
        BindingResult result = getBindingResult(arg, argName);
        validator.validate(arg, result);
        if (result.hasErrors()) {
            return BaseInfo.isNo("校验失败!");
        }
        return null;
    }

    private BindingResult getBindingResult(Object target, String targetName) {
        return new BeanPropertyBindingResult(target, targetName);
    }

}

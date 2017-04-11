package com.exception;

import com.dto.BaseInfo;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

/**
 * 全局异常定义
 *
 * @author Liukx
 * @create 2017-04-10 15:28
 * @email liukx@elab-plus.com
 **/
@ControllerAdvice
public class CommonException {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exception(NativeWebRequest request, Exception ex) {
        return BaseInfo.isNo(ex.getMessage().toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object methodArgumentNotValidException(Exception ex) {
        StringBuffer sb = new StringBuffer();
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                FieldError objectError = (FieldError) allErrors.get(i);
                sb.append(objectError.getField() + " 字段值 " + objectError.getRejectedValue() + objectError.getDefaultMessage());
            }
        }
        return BaseInfo.isNo(sb.toString());
    }
}

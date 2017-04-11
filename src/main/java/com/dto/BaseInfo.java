package com.dto;

/**
 * 出参顶层类
 *
 * @author Liukx
 * @create 2017-04-10 10:07
 * @email liukx@elab-plus.com
 **/
public class BaseInfo {

    private boolean success;
    private String message;
    private Object single;

    public BaseInfo(boolean success, String message, Object single) {
        this.success = success;
        this.message = message;
        this.single = single;
    }

    public static BaseInfo isOk(Object o) {
        return new BaseInfo(true, null, o);
    }

    public static BaseInfo isNo(String message) {
        return new BaseInfo(false, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getSingle() {
        return single;
    }

    public void setSingle(Object single) {
        this.single = single;
    }
}

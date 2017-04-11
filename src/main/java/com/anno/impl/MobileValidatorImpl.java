package com.anno.impl;

import com.anno.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号验证
 *
 * @author Liukx
 * @create 2017-04-11 10:21
 * @email liukx@elab-plus.com
 **/
public class MobileValidatorImpl implements ConstraintValidator<Mobile, CharSequence> {
    private String regex = "1(3|5|7|8)[0-9]{9}";
    private String message;
    private String regexp;

    public MobileValidatorImpl() {
        System.out.println("验证手机中..");
    }

    public void initialize(Mobile annotation) {
        message = annotation.message();
        regexp = annotation.regexp();
    }

    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value != null && value.length() != 0) {
            String stringValue = value.toString();

            if (stringValue.length() != 11) {
                return false;
            }

            if (regexp != null) {
                regex = regexp;
            }

            return stringValue.matches(regex);
        } else {
            return true;
        }
    }

}
package com.controller;

import com.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @RequestMapping(value = "/xionggg", method = RequestMethod.GET)
    public String t(HttpServletRequest request) throws Exception {
        demoService.test("AAAAAAAAAAAAAAAAA");
        System.out.println("111111111111111111111");
        return "";
    }

}

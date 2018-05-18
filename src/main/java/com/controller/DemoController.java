package com.controller;

import com.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    public IDemoService getDemoService() {
        return demoService;
    }

    @InitBinder
    public void initBind() {
        System.out.println("========================================");
    }

    public DemoController() {
        System.out.println("=================DemoController==========");
    }

    public void setDemoService(IDemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(value = "/xionggg", method = RequestMethod.GET)
    public String t(HttpServletRequest request) throws Exception {
//        demoService.test("AAAAAAAAAAAAAAAAA");
//        System.out.println("111111111111111111111");

        String msg ;

        return "";
    }

    // 测试url匹配规则
    @RequestMapping(value = "/xionggg/lkx", method = RequestMethod.GET)
    public String params(@RequestParam(value = "xiong", required = false) String xiong) throws Exception {
        System.out.println("============RequestParam======" + xiong);
        return "";
    }


    @RequestMapping(value = "/xionggg/lkx/{xiong}", method = RequestMethod.GET)
    public String lkx(@PathVariable(value = "xiong") String xiong) throws Exception {
        System.out.println("======/xionggg/lkx/{xiong}=====" + xiong);
        return "";
    }

    @RequestMapping(value = "/xionggg/lkx/**", method = RequestMethod.GET)
    public String tongpeifu() throws Exception {
        System.out.println("=====/xionggg/lkx/**=====");
        return "";
    }

    @RequestMapping(value = "/xionggg/lkx/*", method = RequestMethod.GET)
    public String tongpeifu2() throws Exception {
        System.out.println("=====/xionggg/lkx/*=====");
        return "";
    }


}

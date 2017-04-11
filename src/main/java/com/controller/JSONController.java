package com.controller;

import com.alibaba.fastjson.JSON;
import com.dto.BaseInfo;
import com.dto.JsonDTO;
import org.springframework.web.bind.annotation.*;

/**
 * json参数处理
 *
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@RestController
@RequestMapping("/json")
public class JSONController {

    @RequestMapping(value = "/json1", method = RequestMethod.GET)
    public BaseInfo json(@RequestBody  JsonDTO jsonDTO) throws Exception {
        System.out.println("获取到的实体 - " + JSON.toJSONString(jsonDTO));
        return BaseInfo.isOk(null);
    }

}

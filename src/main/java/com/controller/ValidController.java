package com.controller;

import com.alibaba.fastjson.JSON;
import com.dto.BaseInfo;
import com.dto.valid.ValidDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * json参数处理
 *
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/valid")
public class ValidController {

    @RequestMapping(value = "/dto", method = RequestMethod.GET)
    @ResponseBody
    public BaseInfo json(@Valid @RequestBody ValidDTO validDTO) throws Exception {
        System.out.println("获取到的实体 - " + JSON.toJSONString(validDTO));
        return BaseInfo.isOk(null);
    }

}

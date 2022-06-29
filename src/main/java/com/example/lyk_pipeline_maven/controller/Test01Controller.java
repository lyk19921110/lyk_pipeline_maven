package com.example.lyk_pipeline_maven.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test01")
@RestController
public class Test01Controller {

    @RequestMapping("/method01")
    public Map get(){
        Map map=new HashMap();
        map.put("login","lyk_pipeline_mave");
        return map;
    }
}

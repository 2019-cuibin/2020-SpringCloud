package com.cb.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuibin
 * @date 2020-07-30 15:36
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${from}")
    private String form;

    @RequestMapping("/getPort")
    public String getPort(){
        return form;
    }
}

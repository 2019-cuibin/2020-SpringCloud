package cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuibin
 * @date 2020-07-31 14:30
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/putId/{id}")
    public String putId(@PathVariable("id") Integer id){

        return "返回nacos的端口：" + port + "。此时的id是：" + id;
    }
}

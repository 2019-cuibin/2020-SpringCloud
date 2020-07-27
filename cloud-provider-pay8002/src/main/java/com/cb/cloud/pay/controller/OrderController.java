package com.cb.cloud.pay.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.cloud.common.entity.CommonResult;
import com.cb.cloud.common.entity.Order;
import com.cb.cloud.pay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author cuibin
 * @date 2020-07-08 10:00
 */
@Controller
@RequestMapping("/order")
public class OrderController {

   @Autowired
   private OrderService orderService;

   @Value("${server.port}")
   private String serverPort;
   /**
    * 查询订单
    */
   @ResponseBody
   @RequestMapping("/selectAll")
   public CommonResult selectOrder(Order order){
      QueryWrapper<Order> queryOrder = new QueryWrapper<>();
      if (!StringUtils.isEmpty(order.getId())) {
         queryOrder.eq("id", order.getId());
      }
      if (!StringUtils.isEmpty(order.getOrderNumber())) {
         queryOrder.eq("order", order.getOrderNumber());
      }
      List<Order> orders = orderService.list(queryOrder);
      if (orders.size() > 0){
         return new CommonResult(200,"查询成功！",orders);
      }
      return new CommonResult(500,"查询失败！",null);
   }

   @RequestMapping("/getPort")
   @ResponseBody
   public String getPort(){
      return serverPort;
   }

}

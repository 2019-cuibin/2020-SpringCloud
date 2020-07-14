package com.cb.cloud.pay.service.impl;

import com.cb.cloud.common.entity.Order;
import com.cb.cloud.pay.mapper.OrderMapper;
import com.cb.cloud.pay.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuibin
 * @since 2020-07-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

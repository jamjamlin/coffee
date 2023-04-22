package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.OrderGoods;
import system.mapper.OrderGoodsMapper;
import system.service.OrderGoodsService;

@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods> implements OrderGoodsService {
}

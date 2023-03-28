package system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Order;
import system.mapper.OrderMapper;
import system.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public IPage<Order> selectOrderPage(Page<Order> orderPage) {
        IPage<Order> page = baseMapper.selectOrderPage(orderPage);
        return page;
    }

    @Override
    public IPage<Order> selectFinnishOrderPage(Page<Order> OrderPage) {
        IPage<Order> IPage = baseMapper.selectFinnishOrderPage(OrderPage);
        return IPage;
    }

    @Override
    public IPage<Order> selectOrderPageByUserId(Page<Order> orderPage, int userid) {
        IPage<Order> iPage = baseMapper.selectOrderPageByUserId(orderPage, userid);
        return iPage;

    }

    @Override
    public float viewSalesByTime(int time) {
        float v = baseMapper.viewSalesByTime(time);
        return v;
    }

    @Override
    public float viewSalesByCategory(String coffeecategory) {
        float v = baseMapper.viewSalesByCategory(coffeecategory);
        return v;
    }
}

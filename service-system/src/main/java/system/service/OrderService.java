package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Order;

public interface OrderService extends IService<Order> {
    IPage<Order> selectOrderPage(Page<Order> orderPage);

    IPage<Order> selectFinnishOrderPage(Page<Order> orderPage);

    IPage<Order> selectOrderPageByUserId(Page<Order> orderPage, int userid);

    float viewSalesByTime(int time);

    float viewSalesByCategory(String coffeecategory);
}

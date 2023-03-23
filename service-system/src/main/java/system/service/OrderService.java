package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Order;

public interface OrderService extends IService<Order> {
    IPage<Order> selectOrderPage(Page<Order> orderPage);

    IPage<Order> selectFinnishOrderPage(Long page);

    IPage<Order> selectOrderPageByUserId(Long page, int userid);

    float viewSalesByTime(int time);

    float viewSalesByCategory(String coffeecategory);
}

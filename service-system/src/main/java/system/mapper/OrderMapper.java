package system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import pojo.Order;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    public IPage<Order> selectOrderPage(Page<Order> orderPage);

    public IPage<Order> selectFinnishOrderPage(Page<Order> orderPage);

    public IPage<Order> selectOrderPageByUserId(Page<Order> orderPage, int userid);

    public float viewSalesByTime(int time);

    public float viewSalesByCategory(String coffeecategory);
}

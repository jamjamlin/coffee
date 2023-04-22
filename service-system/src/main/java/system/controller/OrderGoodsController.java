package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.OrderGoods;
import system.service.OrderGoodsService;

import java.util.List;

@Api(tags="订单商品接口")
@RestController
@RequestMapping("/admin/system/user")
@CrossOrigin(origins = "*")
public class OrderGoodsController {

    @Autowired
    private OrderGoodsService orderGoodsService;

    @ApiOperation("添加订单内商品接口")
    @PostMapping("saveordergoods")
    public Result saveOrderGoods(@RequestBody OrderGoods orderGoods){
        boolean isSuccess = orderGoodsService.save(orderGoods);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("根据订单id查询订单商品接口")
    @PostMapping("findordergoodsbyorderid/{orderid}")
    public Result findOrderGoodsByOrderId(@PathVariable String orderid){
        QueryWrapper<OrderGoods> orderGoodsQueryWrapper = new QueryWrapper<>();
        orderGoodsQueryWrapper.eq("order_id",orderid);
        List<OrderGoods> orderGoodsList = orderGoodsService.list(orderGoodsQueryWrapper);
        return Result.ok(orderGoodsList);
    }
}

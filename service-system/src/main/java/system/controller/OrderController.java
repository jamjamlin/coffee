package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Goods;
import pojo.Order;
import system.service.GoodsService;
import system.service.OrderService;
import vo.CoffeeCateGoryVo;
import vo.Time;
import vo.UserQueryVo;

import java.util.List;

@Api(tags = "订单管理接口")
@RestController
@RequestMapping("/admin/system/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;

    @ApiOperation("添加订单接口")
    @PostMapping("saveorder")
    public Result saveOrder(@RequestBody Order order){
        boolean isSuccess = orderService.save(order);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }


    @ApiOperation("分页查找所有订单")
    @PostMapping("queryallorder")
    public Result findAllPageOrder(@RequestBody vo.Page page){
        Page<Order> orderPage  = new Page<>(page.getPage(), page.getLimit());
        IPage<Order> page1 = orderService.selectOrderPage(orderPage);
        return  Result.ok(page1);
    }

    @ApiOperation("查找未接单的订单接口")
    @GetMapping("findpendingorder")
    public Result findPendingOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","已下单");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }

    @ApiOperation("查找申请取消的订单接口")
    @GetMapping("findcancelorder")
    public Result findCancelOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","申请取消");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }

    @ApiOperation("查找已接单的订单接口")
    @GetMapping("findcreceiveorder")
    public Result findReceiveOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","已接单");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }

    @ApiOperation("查找取消成功的订单接口")
    @GetMapping("findcancelledorder")
    public Result findCancelledOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","取消成功");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }
    @ApiOperation("查找制作完成的订单接口")
    @GetMapping("findreadyorder")
    public Result findReadyOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","制作完成");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }
    @ApiOperation("查找配送中的订单接口")
    @GetMapping("findsendingorder")
    public Result findSendingOrder(){
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_state","配送中");
        List<Order> orderList = orderService.list(orderQueryWrapper);
        return Result.ok(orderList);
    }
    @ApiOperation("分页查看已完成的订单接口")
    @PostMapping("findfinnishorder")
    public Result findfinnishOrder(@RequestBody vo.Page page){
        Page<Order> orderPage = new Page<>(page.getPage(), page.getLimit());
        IPage<Order> page1 = orderService.selectFinnishOrderPage(orderPage);
        return Result.ok(page1);
    }

    @ApiOperation("根据用户id分页查看历史订单")
    @PostMapping("findorderbyuserid")
    public Result findOrderPageByUserId(@RequestBody UserQueryVo userQueryVo){
        Page<Order> orderPage = new Page<>(userQueryVo.getPage(), userQueryVo.getLimit());
        int userid = Integer.parseInt(userQueryVo.getUserId());
        IPage<Order> page1 = orderService.selectOrderPageByUserId(orderPage,userid);
        return Result.ok(page1);
    }

    @ApiOperation("更新订单状态为申请取消")
    @PostMapping("cancelorderbyorderid/{orderid}")
    public  Result cancelOrderByOrderId(@PathVariable int orderid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","申请取消");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("更新订单状态为已接单")
    @PostMapping("receiveorderbyorderid/{orderid}")
    public  Result receiveOrderByOrderId(@PathVariable int orderid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","已接单");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("更新订单状态为取消成功")
    @PostMapping("cancelordersuccessbyorderid/{orderid}")
    public  Result cancelOrderSuccessByOrderId(@PathVariable int orderid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","取消成功");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("更新订单状态为制作完成")
    @PostMapping("readyorderbyorderid/{orderid}")
    public  Result readyOrderByOrderId(@PathVariable int orderid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","制作完成");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("更新订单状态为配送中")
    @PostMapping("pendorderbyorderid/{orderid}")
    public  Result pendOrderByOrderId(@PathVariable int orderid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","配送中");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("更新订单状态为已完成")
    @PostMapping("finnishorderbyorderid/{orderid}/{goodsid}")
    public  Result finnishOrderByOrderId(@PathVariable int orderid,@PathVariable int goodsid){
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        orderUpdateWrapper.set("order_state","已完成");
        orderUpdateWrapper.eq("order_id",orderid);
        boolean isSuccess = orderService.update(orderUpdateWrapper);
        if(isSuccess){
            UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
            goodsUpdateWrapper.eq("goods_id",goodsid);
            goodsUpdateWrapper.setSql("goods_number =  goods_number + 1");
            goodsService.update(goodsUpdateWrapper);
            return Result.ok();
        }else
            return Result.fail();
    }


    @ApiOperation("根据时间段查看销售情况")
    @PostMapping("viewsalesbytime/{time}")
    public Result viewSalesByTime(@PathVariable int time){
        float v = orderService.viewSalesByTime(time);
        return Result.ok(v);
    }
    @ApiOperation("根据类型查看销售情况")
    @PostMapping("viewsalesbycoffeecategory/{category}")
    public Result viewSalesByCoffeeCategory(@PathVariable String  category){
        float v = orderService.viewSalesByCategory(category);
        return Result.ok(v);
    }
}

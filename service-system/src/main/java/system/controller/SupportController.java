package system.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Goods;
import pojo.Support;
import system.service.GoodsService;
import system.service.SupportService;

@Api(tags = "点赞管理接口")
@RestController
@RequestMapping("/admin/system/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("添加点赞")
    @PostMapping("savesupport")
    public Result saveSupport(@RequestBody Support support){
        boolean isSuccess = supportService.save(support);
        UpdateWrapper<Goods> goodsUpdateWrapper =new UpdateWrapper<>();
        goodsUpdateWrapper.eq("goods_id",support.getGoodsId());
        goodsUpdateWrapper.setSql("goods_state =  goods_state + 1");
        boolean update = goodsService.update(goodsUpdateWrapper);
        if(isSuccess&&update){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("取消点赞")
    @DeleteMapping("deletesupport")
    public Result deleteSupport(@RequestBody Support support){
        UpdateWrapper<Support> supportUpdateWrapper =new UpdateWrapper<>();
        supportUpdateWrapper.eq("user_id",support.getUserId());
        supportUpdateWrapper.eq("goods_id",support.getGoodsId());
        boolean isSuccess = supportService.remove(supportUpdateWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("查找前十点赞")
    @GetMapping("topsupport")
    public Result topSupport(){
        Page<Support> supportPage = new Page<>(1,10);

        IPage<Support> page1 = supportService.selectTopSupport(supportPage);
        return Result.ok(page1);
    }

}

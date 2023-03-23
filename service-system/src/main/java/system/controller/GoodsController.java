package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.Goods;
import system.service.GoodsService;
import vo.GoodsQueryVo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(tags = "商品管理接口")
@RestController
@RequestMapping("/admin/system/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("分页查询所有商品接口")
    @GetMapping("{page}/{limit}")
    public Result findPageAllGoods(@PathVariable Long page, @PathVariable Long limit, GoodsQueryVo goodsQueryVo){

        Page<Goods> goodsPage = new Page<>(page,limit);


        IPage<Goods> page1 = goodsService.selectGoodsPage(goodsPage,goodsQueryVo);

        System.out.println(page1);

        return Result.ok(page1);
    }

    //未完善！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @ApiOperation("添加商品接口")
    @PostMapping("savegoods")
    public Result saveGoods(@RequestBody Goods goods ,MultipartFile file){
        //获取上传文件的文件名
        String filename = file.getOriginalFilename();

        //处理文件同名问题
         String suffixname  = filename.substring(filename.lastIndexOf("."));

         filename = UUID.randomUUID().toString() + suffixname; // 拼接名字
        String filePath = "src/main/pic";
        File filedir = new File(filePath);
        //判断是否存在保存目录
        if (!filedir.exists()){
            filedir.mkdir();
        }
        //separator 路径分隔符
        String path = filePath+File.separator + filename;

        try {
            //文件保存
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //传入需要保存的实例
        goods.setGoodsPicture(path);

        boolean isSuccess = goodsService.save(goods);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }


    @ApiOperation("修改商品接口")
    @PostMapping("updategoods")
    public Result updateGoods(@RequestBody Goods goods){
        boolean isSuccess = goodsService.updateById(goods);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("逻辑删除接口")
    @DeleteMapping("removegoodsbygoodsid/{goodsid}")
    public Result removeGoodsById(@PathVariable int goodsid){
        boolean isSuccess = goodsService.removeById(goodsid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("查找销量前n商品")
    @GetMapping("topgoods/{num}")
    public Result topGoods(@PathVariable int num){
        Page<Goods> goodsPage = new Page<>(1,num);
        IPage iPage = goodsService.selectTopGoods(goodsPage);
        return Result.ok(iPage);
    }
}

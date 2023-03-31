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
import org.springframework.web.multipart.MultipartFile;
import pojo.Goods;
import system.service.GoodsService;
import vo.GoodsManage;
import vo.GoodsQueryVo;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Api(tags = "商品管理接口")
@RestController
@RequestMapping("/admin/system/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("分页查询所有商品接口")
    @PostMapping("querygoods")
    public Result findPageAllGoods(@RequestBody GoodsQueryVo goodsQueryVo, HttpServletResponse response){

        Page<Goods> goodsPage = new Page<>(goodsQueryVo.getPage(), goodsQueryVo.getLimit());


        IPage<Goods> page1 = goodsService.selectGoodsPage(goodsPage,goodsQueryVo);

//        Long index;
//        index = goodsQueryVo.getLimit();
//        for(int i=0;i<index;i++) {
//            System.out.println(page1.getRecords().get(i).getGoodsPicture());
//            String path = page1.getRecords().get(i).getGoodsPicture();
//            String text = "attachment;filename="+page1.getRecords().get(i).getGoodsId()+".jpg";
//            System.out.println(text);
//            try{
//                //图片的绝对路径（工程路径+图片的相对路径）
//                //创建输入流
//                 FileInputStream stream = new FileInputStream(path);
//                //创建字节数组，获取当前文件中所有的字节数
//                byte[] bytes = new byte[stream.available()];
//                //将流读到字节数组中
//                stream.read(bytes);
//                //设置响应头信息，Content-Disposition响应头表示收到的数据怎么处理（固定），attachment表示下载使用（固定），filename指定下载的文件名（下载时会在客户端显示该名字）
//                response.addHeader("Content-Disposition", text);
//                //创建输出流
//                OutputStream out = response.getOutputStream();
//                out.write(bytes);
//
//                //关闭资源
//                stream.close();
//                out.flush();
//
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//        }

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

    @ApiOperation("查找销量前8商品")
    @GetMapping("topgoods")
    public Result topGoods(){
        Page<Goods> goodsPage = new Page<>(1,8);
        IPage iPage = goodsService.selectTopGoods(goodsPage);
        return Result.ok(iPage);
    }

    @ApiOperation("查找好评前8的商品")
    @GetMapping("stargoods")
    public Result starGoods(){
        Page<Goods> goodsPage = new Page<>(1,8);
        IPage iPage = goodsService.selectStarGoods(goodsPage);
        return Result.ok(iPage);
    }

    @ApiOperation("修改商品优惠")
    @PostMapping("updategoodsdiscount")
    public Result updateGoodsDiscount(@RequestBody GoodsManage goodsManage){
        UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
        goodsUpdateWrapper.eq("goods_id",goodsManage.getGoodsId());
        goodsUpdateWrapper.set("goods_discount",goodsManage.getGoodsDiscount());
        boolean isSuccess = goodsService.update(goodsUpdateWrapper);if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();

    }
}

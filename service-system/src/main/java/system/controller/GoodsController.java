package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
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


    @ApiOperation("添加商品接口")
    @PostMapping("savegoods/{goodsname}/{goodscategory}/{goodsprice}/{goodsintro}/{goodsdiscount}")
    public Result saveGoods(MultipartFile file ,@PathVariable String goodsname,@PathVariable String goodsprice,@PathVariable String goodscategory,@PathVariable String goodsintro,@PathVariable String goodsdiscount){

        Goods goods = new Goods();
        goods.setGoodsCategory(goodscategory);
        goods.setGoodsDiscount(goodsdiscount);
        goods.setGoodsIntro(goodsintro);
        goods.setGoodsName(goodsname);
        goods.setGoodsPrice(goodsprice);

        System.out.println(goods.toString());

        //图片校验（图片是否为空,图片大小，上传的是不是图片、图片类型（例如只能上传png）等等）
        if (file.isEmpty()) {
            return Result.fail("图片上传失败");
        }
        //可以自己加一点校验 例如上传的是不是图片或者上传的文件是不是png格式等等 这里省略
        //获取原来的文件名和后缀
        String originalFilename = file.getOriginalFilename();
//        String ext = "." + FilenameUtils.getExtension(orgFileName); --需要导依赖
        String ext = "."+ originalFilename.split("\\.")[1];
        //生成一个新的文件名（以防有重复的名字存在导致被覆盖）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + ext;
        //拼接图片上传的路径 url+图片名
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\";
        String path = pre + newName;
        goods.setGoodsPicture(path);

        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


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
    @ApiOperation("根据商品id查询接口")
    @PostMapping("findgoodsbygoodsid/{goodsid}")
    public Result findGoodsByGoodsId(@PathVariable String goodsid){
        Goods goods = goodsService.getById(goodsid);
        return Result.ok(goods);
    }
}

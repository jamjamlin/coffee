package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pojo.Annex;
import system.service.AnnexService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(tags = "附件管理接口")
@RestController
@RequestMapping("admin/system/annex")
public class AnnexController {

    @Autowired
    private AnnexService annexService;

    @ApiOperation("添加附件接口")
    @PostMapping("upload/saveannex/{goodsid}")
    public Result saveAnnex( @PathVariable String goodsid, MultipartFile file){
        Annex annex = new Annex();
        System.out.println(goodsid);
        annex.setGoodsId(goodsid);
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
        String sqlname = "http://localhost:8800/"+newName;
        annex.setAnnexAddress(sqlname);
        annexService.save(annex);
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.ok();
    }

    @ApiOperation("根据商品id查询商品附件")
    @PostMapping("findannexbygoodsid/{goodsid}")
    public Result findAnnexByGoodsId(@PathVariable String goodsid){
        QueryWrapper<Annex> annexQueryWrapper = new QueryWrapper<>();
        annexQueryWrapper.eq("goods_id",goodsid);
        List<Annex> annexes = annexService.list(annexQueryWrapper);
        return Result.ok(annexes);
    }
}

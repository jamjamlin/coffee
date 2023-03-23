package system.controller;


import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Stuff;
import system.service.StuffService;

import java.util.List;

@Api(tags = "物料管理接口")
@RestController
@RequestMapping("/admin/system/Stuff")
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @ApiOperation("查询所有物料接口")
    @GetMapping("findallstuff")
    public Result finallstuff(){
        List<Stuff> stuffList = stuffService.list();
        return Result.ok(stuffList);
    }

    @ApiOperation("逻辑删除物料接口")
    @DeleteMapping("removestuffbystuffid/{stuffid}")
    public Result removeStuffByStuffId(@PathVariable int stuffid){
        boolean isSuccess = stuffService.removeById(stuffid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("添加物料接口")
    @PostMapping("savestuff")
    public Result saveStuff(@RequestBody Stuff stuff){
        boolean isSuccess = stuffService.save(stuff);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("根据物料id修改物料数量接口")
    @PostMapping("updatestuff")
    public Result updateStuff(@RequestBody Stuff stuff){
        boolean isSuccess = stuffService.updateById(stuff);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
}

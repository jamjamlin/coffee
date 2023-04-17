package system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Car;
import system.service.CarService;

import java.util.List;

@Api(tags = "购物车管理接口")
@RestController
//浏览器调用
@RequestMapping("/admin/system/car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation("购物车添加商品接口")
    @PostMapping("savecar")
    public Result saveCar(@RequestBody Car car){
        boolean isSuccess = carService.save(car); if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("逻辑删除购物车接口")
    @PostMapping("deletecarbycarid/{carid}")
    public Result removeCarByCarId(@PathVariable int carid){
        boolean isSuccess = carService.removeById(carid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("根据用户id查看购物车接口")
    @PostMapping("findcarbyuserid/{userid}")
    public  Result findCarByUserId(@PathVariable int userid){
        QueryWrapper<Car> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("user_id",userid);
        List<Car> carList = carService.list(queryWrapper);
        return Result.ok(carList);
    }
    @ApiOperation("清空购物车根据用户id接口")
    @PostMapping("allremovecarbyuserid/{userid}")
    public Result allRemoveCarByUserId(@PathVariable int userid){
       QueryWrapper<Car> carQueryWrapper =new QueryWrapper<>();
        carQueryWrapper.eq("user_id", userid);
        boolean isSuccess = carService.remove(carQueryWrapper);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
}

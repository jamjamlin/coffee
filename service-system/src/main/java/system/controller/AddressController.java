package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Address;
import system.service.AddressService;

import java.util.List;

@Api(tags = "地址管理接口")

//浏览器调用
@RequestMapping("/admin/system/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation("根据用户id查询地址接口")
    @PostMapping("findbyuserid/{userid}")
    public Result findAddressByUserId(@PathVariable String userid){
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userid);
        List<Address> addressList = addressService.list(wrapper);
        return Result.ok(addressList);
    }


    @ApiOperation("根据用户id添加地址接口")
    @PostMapping("savebyuserid")
    public Result saveAddressByUserId(@RequestBody Address address){
        boolean isSuccess = addressService.save(address);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("修改地址")
    @PostMapping("updateaddress")
    public Result updateAddress(@RequestBody Address ads){
        boolean isSuccess = addressService.updateById(ads);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("逻辑删除地址接口")
    @DeleteMapping("removeaddressbyaddressid/{addressid}")
    public Result removeAddressById(@PathVariable int addressid){
        boolean isSuccess = addressService.removeById(addressid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }
    @ApiOperation("根据地址id查询接口")
    @PostMapping("findaddressbyaddressid/{addressid}")
    public Result findAddressByAddressId(@PathVariable int addressid){
        Address address = addressService.getById(addressid);
        return Result.ok(address);
    }

}

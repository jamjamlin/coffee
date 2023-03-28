package system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import system.service.UserService;
import vo.UserLoginVo;
import vo.UserQueryVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;



@Api(tags = "角色管理接口")
@RestController
//浏览器调用
@RequestMapping("/admin/system/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("查询所有用户接口")
    //查询所有记录
    @GetMapping("findalluser")
    public Result finAllUser(){
        List<User> userList = userService.list();
        return Result.ok(userList);
    }

    @ApiOperation("逻辑删除角色接口")
    //逻辑删除(通过路径传递）
    @DeleteMapping("removeuserbyuserid/{userid}")
    public Result removeUserById(@PathVariable int userid){
        boolean isSuccess = userService.removeById(userid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("条件分页查询")
    //条件分页查询
    //page当前页 limit 每页记录数
    @PostMapping("queryuser")
    public Result findPageQueryUser(UserQueryVo userQueryVo){
        //创建page对象
        Page<User> userPage = new Page<>(userQueryVo.getPage(), userQueryVo.getLimit());

        //调用service方法
        IPage<User> page1 = userService.selectUserPage(userPage,userQueryVo);

        //返回
        return Result.ok(page1);

    }

    @ApiOperation("添加/注册接口")
    //添加注册新用户
    //@RequestBody 只在post中可用
    //传递json格式，把json格式数据封装到对象里面{...}
    @RequestMapping ("saveuser")
    public Result saveUSer(@RequestBody User user){
        boolean isSuccess = userService.save(user);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("根据id查询")
    @PostMapping("finduserbyuserid/{userid}")
    //根据id查询
    public Result findUserById(@PathVariable Long userid){
    User user =userService.getById(userid);
    return Result.ok(user);
    }

    @ApiOperation("修改用户")
    //根据id修改
    @PostMapping("updateuser")
    public Result updateUser(@RequestBody User user){
        boolean isSuccess = userService.updateById(user);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("批量删除")
    //批量删除
    //多个id值[1,3,4]  json数值格式对应javalist集合
    @DeleteMapping("batchremoveuser")
    public Result batchRemoveUser(@RequestBody List<Long> ids){
        boolean isSuccess = userService.removeByIds(ids);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("登录接口")
    @GetMapping("loadinguser")
    public Result loadingUser(  UserLoginVo loginVo){
        System.out.println(loginVo.getPassword());
        System.out.println(loginVo.getPhone());
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_phone",loginVo.getPhone());
        wrapper.eq("user_password",loginVo.getPassword());
        List<User> list = userService.list(wrapper);
        System.out.println(list.toString());
        return Result.ok(list);
    }

}

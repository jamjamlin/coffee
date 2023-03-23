package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Talk;
import system.service.TalkService;

import java.util.List;

@Api(tags = "留言客服接口")
@RestController
@RequestMapping("/admin/system/Talk")
public class TalkController {
    @Autowired
    private TalkService talkService;

    @ApiOperation("顾客留言发送")
    @PostMapping("customersavetalk")
    public Result customerSaveTalk(@RequestBody Talk talk){
        boolean isSuccess = talkService.save(talk);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();

    }
    @ApiOperation("顾客留言查看根据顾客id")
    @GetMapping("findtalkbyuserid/{userid}")
    public Result findTalkByUserId(@PathVariable int userid){
        QueryWrapper<Talk> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("user_id",userid);
        List<Talk> talkList = talkService.list(QueryWrapper);
        return Result.ok(talkList);
    }

    @ApiOperation("回复顾客接口")
    @PostMapping("coffeesavetalk")
    public Result coffeeSaveTalk(@RequestBody Talk talk){
        talk.setTalkCategory("1");
        boolean isSuccess = talkService.save(talk);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();
    }

    @ApiOperation("分页查看所有留言")
    @GetMapping("findalltalk/{page}/{limit}")
    public Result findAllTalk(@PathVariable long page, @PathVariable long limit){
        Page<Talk> talkpage = new Page<>(page, limit);

        IPage<Talk> page1 = talkService.selectTalkPage(talkpage);

        return Result.ok(page1);
    }


}

package system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Comment;
import system.service.CommentService;
import vo.GoodsQueryVo;
import vo.UserIdVo;

import java.util.List;

@Api(tags = "点评管理接口")
@RestController
@RequestMapping("/admin/system/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("根据商品id查询点评")
    @PostMapping("querycommentbygoodsid")
    public Result findPageQueryCommentByGoodsId(@RequestBody GoodsQueryVo goodsQueryVo){

        Page<Comment> commentPage = new Page<>(goodsQueryVo.getPage(), goodsQueryVo.getLimit());

        IPage<Comment> page1 = commentService.selectCommentByGoodsId(commentPage, goodsQueryVo.getGoodsId());

        System.out.println(page1);
        return Result.ok(page1);

    }

    @ApiOperation("根据用户id查询点评")
    @PostMapping("findcommentbyuserid")
    public Result findCommentByUserId(@RequestBody UserIdVo userid){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userid.getUserId());
        List<Comment> commentList = commentService.list(wrapper);
        return Result.ok(commentList);

    }


    @ApiOperation("添加点评")
    @PostMapping("savecomment")
    public  Result saveComment(@RequestBody Comment comment){
        boolean isSuccess = commentService.save(comment);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();

    }

    @ApiOperation("逻辑删除点评")
    @DeleteMapping("removecommentbycommentid/{commentid}")
    public Result removeCommentByCommentId(@PathVariable int commentid){
        boolean isSuccess = commentService.removeById(commentid);
        if(isSuccess){
            return Result.ok();
        }else
            return Result.fail();

    }
}

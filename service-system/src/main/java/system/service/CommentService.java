package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Comment;

public interface CommentService extends IService<Comment> {

    IPage<Comment> selectCommentByGoodsId(Page<Comment> commentPage, int goodsid);
}

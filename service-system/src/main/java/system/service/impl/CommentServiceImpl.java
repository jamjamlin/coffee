package system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Comment;
import system.mapper.CommentMapper;
import system.service.CommentService;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public IPage<Comment> selectCommentByGoodsId(Page<Comment> commentPage, int goodsid) {
        IPage<Comment> page = baseMapper.selectCommentByGoodsId(commentPage, goodsid);
        return page;
    }
}

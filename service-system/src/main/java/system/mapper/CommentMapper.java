package system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import pojo.Comment;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    public IPage<Comment> selectCommentByGoodsId(Page<Comment> commentPage, int goodsid);
}

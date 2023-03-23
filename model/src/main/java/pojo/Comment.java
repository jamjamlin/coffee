package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String CommentId;

    @TableField("goods_id")
    private String GoodsId;

    @TableField("user_id")
    private String UserId;

    @TableField("comment_content")
    private String CommentContent;

    @TableField("comment_createtime")
    private String CommentCreateTime;

    @TableField("comment_updatetime")
    private String CommentUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int CommentIsDeleted;

    @TableField("goods_name")
    private String GoodsName;


}

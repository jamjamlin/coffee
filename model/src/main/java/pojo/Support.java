package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_support")
public class Support implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String SupportId;


    @TableField("user_id")
    private String UserId;

    @TableField("goods_id")
    private String Goodsid;

    @TableField("goods_name")
    private String GoodsName;

    @TableField("support_createtime")
    private String SupportCreateTime;

    @TableField("support_updatetime")
    private String SupportUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int SupportIsDeleted;
}

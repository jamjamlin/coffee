package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_car")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String CarId;

    @TableField("user_id")
    private String UserID;

    @TableField("goods_id")
    private String GoodsID;

    @TableField("goods_type")
    private String GoodsType;

    @TableLogic
    @TableField("is_deleted")
    private  int CarIsDeleted;
}

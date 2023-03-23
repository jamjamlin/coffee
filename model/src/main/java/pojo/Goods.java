package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String GoodsId;

    @TableField("goods_name")
    private String GoodsName;

    @TableField("goods_price")
    private String GoodsPrice;

    @TableField("goods_state")
    private String GoodsState;

    @TableField("goods_category")
    private String GoodsCategory;

    @TableField("goods_picture")
    private String GoodsPicture;

    @TableField("goods_intro")
    private String GoodsIntro;

    @TableField("goods_discount")
    private String GoodsDiscount;

    @TableField("goods_createtime")
    private String GoodsCreateTime;

    @TableField("goods_updatetime")
    private String GoodsUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int GoodsIsDeleted;

    @TableField("goods_number")
    private  int GoodsNumber;



}

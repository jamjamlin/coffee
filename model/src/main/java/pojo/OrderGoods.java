package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_ordergoods")
public class OrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String OrderGoodsId;

    @TableField("goods_id")
    private String GoodsId;

    @TableField("order_id")
    private String OrderId;

    @TableField("goods_type")
    private String GoodsType;

    @TableField("goods_name")
    private String GoodsName;

    @TableField("goods_price")
    private String GoodsPrice;

    @TableField("goods_discount")
    private String GoodsDiscount;

    @TableField("goods_realprice")
    private String GoodsRealPrice;

    @TableField("goods_category")
    private String GoodsCategory;
}

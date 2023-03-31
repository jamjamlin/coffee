package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String OrderId;

    @TableField("user_id")
    private String UserId;

    @TableField("user_name")
    private String UserName;

    @TableField("address_id")
    private String AddressId;

    @TableField("address_info")
    private String AddressInfo;

    @TableField("order_amount")
    private String OrderAmount;

    @TableField("order_realamount")
    private String OrderRealAmount;

    @TableField("order_content")
    private String OrderContent;

    @TableField("order_remarks")
    private String OrderRemarks;

    //1.已下单 2.申请取消 3.已接单 4.取消成功 5.制作完成 6.配送中 7.已完成
    @TableField("order_state")
    private String OrderState;

    @TableField("order_createtime")
    private String OrderCreateTime;

    @TableField("order_updatetime")
    private String OrderUpdateTime;

    @TableField("is_deleted")
    private int OrderIsDeleted;

    @TableField("goods_id")
    private String GoodsId;

    @TableField("goods_name")
    private String GoodsName;



}

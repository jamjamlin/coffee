package pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String AddressId;

    @TableField("user_id")
    private String UserId;

    @TableField("address_name")
    private String AddressName;

    @TableField("address_tel")
    private String AddressTel;

    @TableField("address_contacts")
    private String AddressContacts;

    @TableField("address_remarks")
    private String AddressRemarks;

    @TableField("address_createtime")
    private String AddressCreateTime;

    @TableField("address_updatetime")
    private String AddressUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int AddressIsDeleted;
}

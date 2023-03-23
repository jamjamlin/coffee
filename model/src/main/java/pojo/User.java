package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String UserId;

    @TableField("user_name")
    private String UserName;

    @TableField("user_age")
    private String UserAge;

    @TableField("user_phone")
    private String UserPhone;

    @TableField("user_sex")
    private String UserSex;

    @TableField("user_password")
    private String UserPassword;

    @TableField("user_createtime")
    private String UserCreateTime;

    @TableField("user_updatetime")
    private String UserUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int UserIsDeleted;
}

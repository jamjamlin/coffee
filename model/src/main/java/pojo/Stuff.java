package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_stuff")
public class Stuff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String StuffId;

    @TableField("stuff_name")
    private String StuffName;

    @TableField("stuff_number")
    private String StuffNumber;

    @TableField("stuff_createtime")
    private String StuffCreateTime;

    @TableField("stuff_updatetime")
    private String StuffUpdateTime;

    @TableLogic
    @TableField("is_deleted")
    private int StuffIsDeleted;

}

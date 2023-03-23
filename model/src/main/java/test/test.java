package test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test")
public class test {

    @TableId(type = IdType.AUTO)
    private String idtest;

    @TableField("nametest")
    private String nametest;

    @TableField("pswtest")
    private String pswtest;
}

package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_talk")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String TalkId;

    @TableField("talk_content")
    private String TalkContent;

    @TableField("user_id")
    private String UserId;

    @TableField("user_name")
    private String UserName;

    @TableField("talk_category")
    private String TalkCategory;

    @TableField("talk_createtime")
    private String TalkCreateTime;
}

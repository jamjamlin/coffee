package pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_annex")
public class Annex implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String AnnexId;

    @TableField("goods_id")
    private String GoodsId;

    @TableField("annex_address")
    private String AnnexAddress;

    @TableField("is_deleted")
    @TableLogic
    private int AnnexIsDeleted;
}

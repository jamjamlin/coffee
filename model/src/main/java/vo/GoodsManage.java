package vo;

import java.io.Serializable;

public class GoodsManage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String GoodsId;
    private String GoodsDiscount;

    public String getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(String goodsId) {
        GoodsId = goodsId;
    }

    public String getGoodsDiscount() {
        return GoodsDiscount;
    }

    public void setGoodsDiscount(String goodsDiscount) {
        GoodsDiscount = goodsDiscount;
    }
}

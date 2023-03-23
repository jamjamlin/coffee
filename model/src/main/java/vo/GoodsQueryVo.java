package vo;

import java.io.Serializable;

/**
 *
 * 商品条件查询实体
 *
 */
public class GoodsQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String GoodsName;

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodsState() {
        return GoodsState;
    }

    public void setGoodsState(String goodsState) {
        GoodsState = goodsState;
    }

    public String getGoodCategory() {
        return GoodsCategory;
    }

    public void setGoodCategory(String goodCategory) {
        GoodsCategory = goodCategory;
    }

    private String GoodsState;

    private String GoodsCategory;
}

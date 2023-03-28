package vo;

import java.io.Serializable;

public class CoffeeCateGoryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String GoodsCategory;

    public String getGoodsCategory() {
        return GoodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        GoodsCategory = goodsCategory;
    }
}

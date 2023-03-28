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

    private Long page;

    public String getGoodsCategory() {
        return GoodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        GoodsCategory = goodsCategory;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    private Long limit;

    public int getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(int goodsId) {
        GoodsId = goodsId;
    }

    private int GoodsId;
}

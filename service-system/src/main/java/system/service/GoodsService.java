package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Goods;
import vo.GoodsQueryVo;

public interface GoodsService extends IService<Goods> {

    IPage<Goods> selectGoodsPage(Page<Goods> goodsPage,GoodsQueryVo goodsQueryVo);

    IPage selectTopGoods(Page<Goods> goodsPage);
}

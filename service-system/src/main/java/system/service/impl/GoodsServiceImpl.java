package system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Goods;
import system.mapper.GoodsMapper;
import system.service.GoodsService;
import vo.GoodsQueryVo;


@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>implements GoodsService {


    @Override
    public IPage<Goods> selectGoodsPage(Page<Goods> goodsPage, GoodsQueryVo goodsQueryVo) {
        IPage<Goods> page1 = baseMapper.selectGoodsPage(goodsPage, goodsQueryVo);
        return page1;
    }

    @Override
    public IPage selectTopGoods(Page<Goods> goodsPage) {
        IPage<Goods> page2 = baseMapper.selectTopGoods(goodsPage);
        return page2;
    }

    @Override
    public IPage selectStarGoods(Page<Goods> goodsPage) {
        IPage<Goods> page3 = baseMapper.selectStarGoods(goodsPage);
        return page3;
    }
}

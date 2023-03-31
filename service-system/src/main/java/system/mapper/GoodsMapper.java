package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Goods;
import vo.GoodsQueryVo;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    public IPage<Goods> selectGoodsPage(Page<Goods> goodsPage, @Param("vo")GoodsQueryVo goodsQueryVo);

    public IPage<Goods> selectTopGoods(Page<Goods> goodsPage);

    public IPage<Goods> selectStarGoods(Page<Goods> goodsPage);
}

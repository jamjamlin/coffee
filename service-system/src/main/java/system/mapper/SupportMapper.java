package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import pojo.Support;

import java.util.List;

@Repository
public interface SupportMapper extends BaseMapper<Support> {

    IPage<Support> selectTopSupport(Page<Support> supportPage);

    //点赞前十查询

}

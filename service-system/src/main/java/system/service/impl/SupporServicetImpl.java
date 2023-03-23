package system.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Support;
import system.mapper.SupportMapper;
import system.service.SupportService;

import java.util.List;

@Service
public class SupporServicetImpl extends ServiceImpl<SupportMapper, Support> implements SupportService {

    @Override
    public IPage<Support> selectTopSupport(Page<Support> supportPage) {
        IPage<Support> page1 = baseMapper.selectTopSupport(supportPage);
        return page1;
    }
}

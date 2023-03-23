package system.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Talk;
import system.mapper.TalkMapper;
import system.service.TalkService;

@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
    @Override
    public IPage<Talk> selectTalkPage(Page<Talk> talkpage) {
        IPage<Talk> page = baseMapper.selectTalkPage(talkpage);
        return page;
    }
}

package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Talk;

public interface TalkService extends IService<Talk> {
    public IPage<Talk> selectTalkPage(Page<Talk> talkpage);
}

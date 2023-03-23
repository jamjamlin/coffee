package system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import pojo.Talk;

@Repository
public interface TalkMapper extends BaseMapper<Talk> {

    public IPage<Talk> selectTalkPage(Page<Talk> talkpage);
}

package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.Support;

import java.util.List;

public interface SupportService extends IService<Support> {

    IPage<Support> selectTopSupport(Page<Support> supportPage);
}

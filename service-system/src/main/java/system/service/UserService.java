package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.User;
import vo.UserQueryVo;

public interface UserService  extends IService<User> {

    //条件分页查询
    IPage<User> selectUserPage(Page<User> userPage, UserQueryVo userQueryVo);
}

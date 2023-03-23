package system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.User;
import system.mapper.UserMapper;
import system.service.UserService;
import vo.UserQueryVo;


@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {


    //条件分页查询
    @Override
    public IPage<User> selectUserPage(Page<User> userPage, UserQueryVo userQueryVo) {
        IPage<User> page1 = baseMapper.selectUserPage(userPage, userQueryVo);
        return page1;
    }
}

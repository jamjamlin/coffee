package system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.User;
import vo.UserQueryVo;

@Repository
public interface UserMapper extends BaseMapper<User> {

    //条件分页查询
    public IPage<User> selectUserPage(Page<User> userPage, @Param("vo") UserQueryVo userQueryVo);

}

package system.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pojo.User;
import system.service.UserService;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService service;




    @Test
    public void findall(){
        List<User> list = service.list();
        System.out.println(list);
    }
    @Test
    public void add(){
        User user =new User();
        user.setUserAge("18");
        user.setUserName("罗哥");
        user.setUserPhone("110120119");
        user.setUserSex("man");
        user.setUserPassword("110120119");
        service.save(user);
    }

    @Test
    public void update(){
        User a = service.getById("1");
        a.setUserName("丁哥");
        service.updateById(a);
    }

    @Test
    public void delete(){
        service.removeById("1");

    }

    @Test
    public void find(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","罗哥");
        List<User> list = service.list(wrapper);
        System.out.println(list);

    }
}

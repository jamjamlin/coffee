package system.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system.mapper.TestMapper;
import test.test;

import java.util.List;

@SpringBootTest
public class TestMapperTest {


    @Autowired
    private TestMapper testMapper;

    @Test
    public void findAll(){
        List<test> list = testMapper.selectList(null);
        for (test test:list){
            System.out.println(test);
        }

    }

    @Test
    public  void add(){
        test t = new test();
        t.setNametest("名字");
        t.setPswtest("密码");
        System.out.println(t);
        int rows = testMapper.insert(t);
        System.out.println(rows);
    }

    @Test
    public void update(){
        //根据id查询
        test t = testMapper.selectById(1);
        //设置修改值
        t.setNametest("小瘪三");
        t.setPswtest("xbs");
        //调用方法实现
        testMapper.updateById(t);
    }

    @Test
    public void delete(){
        int t =testMapper.deleteById("5");
    }

    @Test
    public void select(){
        //创建构造器对象
        QueryWrapper<test> wrapper =new QueryWrapper<>();
        //设置条件  列名+值
        wrapper.like("nametest", "名");
        //调用方法查询
        List<test> list = testMapper.selectList(wrapper);
        System.out.println(list);
    }

}

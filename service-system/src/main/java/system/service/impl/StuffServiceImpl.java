package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Stuff;
import system.mapper.StuffMapper;
import system.service.StuffService;

@Service
public class StuffServiceImpl extends ServiceImpl<StuffMapper, Stuff>implements StuffService {
}

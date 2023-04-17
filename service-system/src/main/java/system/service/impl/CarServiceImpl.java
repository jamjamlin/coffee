package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Car;
import system.mapper.CarMapper;
import system.service.CarService;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
}

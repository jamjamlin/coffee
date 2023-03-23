package system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Address;
import system.mapper.AddressMapper;
import system.service.AddressService;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>implements AddressService {


}

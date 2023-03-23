package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.Annex;
import system.mapper.AnnexMapper;
import system.service.AnnexService;

@Service
public class AnnexServiceImpl extends ServiceImpl<AnnexMapper, Annex> implements AnnexService {
}

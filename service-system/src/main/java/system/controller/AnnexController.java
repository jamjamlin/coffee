package system.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.service.AnnexService;

@Api(tags = "附件管理接口")
@RestController
@RequestMapping("admin/system/annex")
public class AnnexController {

    @Autowired
    private AnnexService annexService;
}

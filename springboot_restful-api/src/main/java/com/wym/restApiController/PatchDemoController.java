package com.wym.restApiController;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Patch
 * @author yongmao.wu
 *
 */
@RestController
@Api(value = "API of user")
@RequestMapping("/api-demo/")
public class PatchDemoController {

    private Logger logger = LoggerFactory.getLogger(PatchDemoController.class);

    /**
     * 修改用户名（传入被修改对象的部分信息）
     * @param id
     * @param name
     * @return
     */
    @PatchMapping("user/{id}")
    public int updateUserName(
            @PathVariable("id")String id,
            @RequestParam("name") String name
    ){
        logger.debug("id:"+id+",name:"+name);
        return 1;
    }


}

package com.wym.restApiController;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wym.model.User;

/**
 * Put
 * @author yongmao.wu
 *
 */
@RestController
@Api(value = "API of user")
@RequestMapping("/api-demo/")
public class PutDemoController {

    private Logger logger = LoggerFactory.getLogger(PutDemoController.class);

    /**
     * 修改用户信息（传入被修改对象的全部）
     * @param user
     * @return
     */
    @PutMapping("user")
    public int updateUser(@RequestBody User user){
        logger.debug("user:"+user);
        return 1;
    }
}

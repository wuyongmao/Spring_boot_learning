package com.wym.restApiController;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wym.model.User;

/**
 * Post
 * @author yongmao.wu
 *
 */
@RestController
@Api(value = "API of user")
@RequestMapping("/api-demo")
public class PostDemoController {

    private Logger logger = LoggerFactory.getLogger(PostDemoController.class);

    /**
     * 添加用户信息
     * 请求参数支持json
     * @param user
     * @param dept
     * @return
     */
    @PostMapping("/json/user")
    public int addUserToSpecialDepart(
            @RequestParam("dept") String dept,
            @RequestBody User user
    ){
        logger.debug("dept:"+dept+",user:"+user);
        return 1;
    }

    /**
     * 添加用户信息
     * 请求参数支持表单数据
     * @param user
     * @return
     */
    @PostMapping("/form/user")
    public int addUserByForm(@ModelAttribute User user){
        logger.debug("user:"+user);
        return 1;
    }
}

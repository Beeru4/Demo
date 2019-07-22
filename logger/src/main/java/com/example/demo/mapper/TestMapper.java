package com.example.demo.mapper;

import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Beerus
 * @Description 测试映射类
 * @Date 2019-07-01
 **/
@Component
public class TestMapper {
    private Logger logger = LoggerFactory.getLogger(TestService.class);

    /**
     * 添加用户
     */
    public void addUser() {
        logger.info("execute addUser");
    }

    /**
     * 删除用户
     */
    public void delUser() {
        logger.info("execute delUser");
    }
}

package com.example.demo.controller;

import com.example.demo.logger.AddLogger;
import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 测试控制器
 * @Date 2019-07-01
 **/
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TestService testService;

    /**
     * 测试方法
     */
    @AddLogger(describe = "添加用户", context = "添加了一条用户")
    @RequestMapping(value = "/addUser")
    public String testLogger() {
        testService.saveUser();
        return "add";
    }

    /**
     * 测试方法
     */
    @AddLogger(describe = "删除用户", context = "删除了一个用户")
    @RequestMapping(value = "/deleteUser")
    public String deleteUser() {
        testService.deleteUser();
        return "del";
    }
}

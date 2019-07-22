package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 测试业务类
 * @Date 2019-07-01
 **/
@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public void saveUser() {testMapper.addUser();}

    public void deleteUser() {
        testMapper.delUser();
    }


}

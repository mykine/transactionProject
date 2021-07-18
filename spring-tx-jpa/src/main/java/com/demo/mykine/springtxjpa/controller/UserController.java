package com.demo.mykine.springtxjpa.controller;

import com.demo.mykine.springtxjpa.dao.User.TUsersMapper;
import com.demo.mykine.springtxjpa.domain.entity.User.TUsers;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private TUsersMapper usersMapper;

    @GetMapping("/test")
    public TUsers testInsert(){
        TUsers user = new TUsers();
        user.setAge(1);
        user.setName("james");
        user.setGender(1);
        usersMapper.insertSelective(user);
        return user;
    }
}

package com.demo.mykine.springtxjpa.service.impl;

import com.demo.mykine.springtxjpa.dao.User.TUsersMapper;
import com.demo.mykine.springtxjpa.domain.entity.User.TUsers;
import com.demo.mykine.springtxjpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUsersMapper usersMapper;

    @Transactional
    @Override
    public int addData( TUsers user ) throws Exception {
        int res = 0;
        log.info("开始新增用户,{}",user);
        res = usersMapper.insertSelective(user);
        if(user.getName().equals("james")){
            log.error("用户已存在,user={}",user);
            throw new RuntimeException("用户已存在,name="+user.getName());
        }
        return res;
    }
}

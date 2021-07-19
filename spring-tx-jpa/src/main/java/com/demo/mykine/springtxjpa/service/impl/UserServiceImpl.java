package com.demo.mykine.springtxjpa.service.impl;

import com.demo.mykine.springtxjpa.dao.User.TUsersMapper;
import com.demo.mykine.springtxjpa.domain.entity.User.TUsers;
import com.demo.mykine.springtxjpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUsersMapper usersMapper;

    @Autowired
    private PlatformTransactionManager transactionManager;

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

    @Override
    public int addData2(TUsers user) throws Exception {
        //事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        //设置事务隔离级别，默认值:Mysql是可重复读
        def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        //设置传播属性:如果当前存在事务就加入，否则创建新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        int res = 0;
        //开启事务并返回事务状态
        TransactionStatus ts = transactionManager.getTransaction(def);
        try{
            log.info("开始新增用户,{}",user);
            res = usersMapper.insertSelective(user);
            if(user.getName().equals("james1")){
                log.error("用户已存在,user={}",user);
                throw new RuntimeException("用户已存在,name="+user.getName());
            }
            transactionManager.commit(ts);
        }catch (RuntimeException e){
            log.error("error,e={}",e);
            transactionManager.rollback(ts);
        }

        return res;
    }


}

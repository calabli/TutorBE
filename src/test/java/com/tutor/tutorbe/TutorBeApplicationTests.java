package com.tutor.tutorbe;

import cn.hutool.core.lang.UUID;
import com.tutor.tutorbe.login.domain.Accounts;
import com.tutor.tutorbe.login.mapper.AccountsMapper;
import com.tutor.tutorbe.login.req.LoginReq;
import com.tutor.tutorbe.login.service.AccountsService;
import com.tutor.tutorbe.util.IDUtil;
import com.tutor.tutorbe.util.PasswordUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;

@SpringBootTest
class TutorBeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AccountsMapper accountsMapper;

    @Autowired
    private AccountsService accountsService;

    @Test
    void insertAccount() throws Exception {
        Accounts accounts = new Accounts();
        accounts.setAccountId(IDUtil.generateId());
        accounts.setUsername("admin");
        String salt = UUID.fastUUID().toString(true);
        accounts.setSalt(salt);
        accounts.setPassword(PasswordUtil.encrypt(salt, "123456"));
        accounts.setCreator(accounts.getAccountId());
        accounts.setOwner(accounts.getAccountId());
        accounts.setCreatedAt(new Date());
        accounts.setUpdatedAt(new Date());
        accounts.setStatus("ACTIVE");
        accountsMapper.insertAccount(accounts);
    }

    @Test
    void login() {
        LoginReq loginReq = new LoginReq();
        loginReq.setPassword("123456");
        loginReq.setUsername("admin");
        Assert.isTrue(accountsService.login(loginReq), "fail to login");

        loginReq.setPassword("123457");
        Assert.isTrue(!accountsService.login(loginReq), "success to login");
    }


}

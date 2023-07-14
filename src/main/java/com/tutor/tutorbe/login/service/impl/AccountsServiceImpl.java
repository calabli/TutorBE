package com.tutor.tutorbe.login.service.impl;


import com.tutor.tutorbe.login.domain.Accounts;
import com.tutor.tutorbe.login.mapper.AccountsMapper;
import com.tutor.tutorbe.login.req.LoginReq;
import com.tutor.tutorbe.login.service.AccountsService;
import com.tutor.tutorbe.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author cxg
 * @description 针对表【accounts】的数据库操作Service实现
 * @createDate 2023-04-27 11:11:20
 */
@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsMapper accountsMapper;

    @Override
    public boolean login(LoginReq req) {
        Optional<Accounts> accountsOptional = accountsMapper.selectByUsername(req.getUsername());
        if (!accountsOptional.isPresent()) {
            return false;
        }
        Accounts account = accountsOptional.get();
        return Objects.equals(
                PasswordUtil.encrypt(account.getSalt(), req.getPassword()), account.getPassword()
        );
    }
}





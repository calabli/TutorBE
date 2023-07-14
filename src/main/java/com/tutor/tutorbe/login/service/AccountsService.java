package com.tutor.tutorbe.login.service;


import com.tutor.tutorbe.login.req.LoginReq;

/**
* @author cxg
* @description 针对表【accounts】的数据库操作Service
* @createDate 2023-04-27 11:11:20
*/
public interface AccountsService{

    boolean login(LoginReq req);
}

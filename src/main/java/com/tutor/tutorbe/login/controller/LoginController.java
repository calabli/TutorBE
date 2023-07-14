package com.tutor.tutorbe.login.controller;

import cn.hutool.core.lang.UUID;

import com.tutor.tutorbe.base.FacadeResponse;
import com.tutor.tutorbe.base.ResponseCode;
import com.tutor.tutorbe.login.req.LoginReq;
import com.tutor.tutorbe.login.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account/")
@Slf4j
public class LoginController {

    @Autowired
    private AccountsService accountsService;

    @PostMapping("login")
    public FacadeResponse<String> login(@RequestBody LoginReq req) {
        boolean res = accountsService.login(req);
        FacadeResponse<String> response = new FacadeResponse<>();
        if (res) {
            response.fillWithSuccess();
            response.setValue(UUID.fastUUID().toString(false));
            return response;
        }
        response.fillWithUnSuccess(ResponseCode.FAIL, "用户名或密码错误");
        return response;
    }

}

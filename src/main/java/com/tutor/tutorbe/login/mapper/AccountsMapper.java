package com.tutor.tutorbe.login.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutor.tutorbe.login.domain.Accounts;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * @author cxg
 * @description 针对表【accounts】的数据库操作Mapper
 * @createDate 2023-04-27 11:11:20
 * @Entity com.cl.clservice.login.domain.Accounts
 */
@Mapper
public interface AccountsMapper extends BaseMapper<Accounts> {

    String UserName = "username";
    String Status = "status";

    default Optional<Accounts> selectByUsername(@NonNull String username) {
        return Optional.ofNullable(
                selectOne(
                        new QueryWrapper<Accounts>()
                                .eq(UserName, username)
                                .eq(Status, "ACTIVE")
                )
        );
    }

    default void insertAccount(Accounts accounts) throws Exception {
        int insert = insert(accounts);
        if (insert != 1) {
            throw new Exception(String.format("fail to create a account: %s", accounts.getUsername()));
        }
    }
}





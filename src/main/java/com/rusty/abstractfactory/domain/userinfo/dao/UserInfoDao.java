package com.rusty.abstractfactory.domain.userinfo.dao;

import com.rusty.abstractfactory.domain.userinfo.UserInfo;

public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInf(UserInfo userInfo);
}

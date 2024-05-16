package com.rusty.apstractfactory.domain.userinfo.dao;

import com.rusty.apstractfactory.domain.userinfo.UserInfo;

public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInf(UserInfo userInfo);
}

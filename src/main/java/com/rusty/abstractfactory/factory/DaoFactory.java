package com.rusty.abstractfactory.factory;

import com.rusty.abstractfactory.domain.product.dao.ProductDao;
import com.rusty.abstractfactory.domain.userinfo.dao.UserInfoDao;

public class DaoFactory {

    public abstract UserInfoDao createUserInfoDao();
    public abstract ProductDao createProductDao();

}

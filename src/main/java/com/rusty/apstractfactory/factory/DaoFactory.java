package com.rusty.apstractfactory.factory;

import com.rusty.apstractfactory.domain.product.dao.ProductDao;
import com.rusty.apstractfactory.domain.userinfo.dao.UserInfoDao;

public class DaoFactory {

    public abstract UserInfoDao createUserInfoDao();
    public abstract ProductDao createProductDao();

}

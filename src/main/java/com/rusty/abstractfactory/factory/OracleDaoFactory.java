package com.rusty.abstractfactory.factory;

import com.rusty.abstractfactory.domain.product.dao.oracle.ProductOracleDao;

public class OracleDaoFactory extends DaoFactory{

    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductOracleDao();
    }


}

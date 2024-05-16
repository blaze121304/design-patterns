package com.rusty.apstractfactory.userinfo;

import com.rusty.apstractfactory.domain.product.Product;
import com.rusty.apstractfactory.domain.product.dao.ProductDao;
import com.rusty.apstractfactory.domain.userinfo.UserInfo;
import com.rusty.apstractfactory.domain.userinfo.dao.UserInfoDao;
import com.rusty.apstractfactory.factory.DaoFactory;
import com.rusty.apstractfactory.factory.MySqlDaoFactory;
import com.rusty.apstractfactory.factory.OracleDaoFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("db.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPasswd("!@#$%");
        userInfo.setUserName("�̼���");

        Product product = new Product();
        product.setProductId("0011AA");
        product.setProductName("TV");

        DaoFactory daoFactory = null;
        UserInfoDao userInfoDao = null;
        ProductDao productDao = null;



        if(dbType.equals("ORACLE")){
            daoFactory = new OracleDaoFactory();
        }
        else if(dbType.endsWith("MYSQL")){
            daoFactory = new MySqlDaoFactory();
        }
        else{
            System.out.println("db support error");
            return;
        }

        userInfoDao = daoFactory.createUserInfoDao();
        productDao = daoFactory.createProductDao();

        System.out.println("==USERINFO TRANSACTION==");
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInf(userInfo);

        System.out.println("==PRODUCT TRANSACTION==");
        productDao.insertProduct(product);
        productDao.updateProduct(product);
        productDao.deleteProduct(product);

    }


}

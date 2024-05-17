package com.rusty.abstractfactory.domain.product.dao.oracle;

import com.rusty.abstractfactory.domain.product.Product;
import com.rusty.abstractfactory.domain.product.dao.ProductDao;

public class ProductOracleDao implements ProductDao {

    @Override
    public void insertProduct(Product product) {
        System.out.println("insert into ORACLE DB productId =" + product.getProductId() );
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("update into ORACLE DB productId =" + product.getProductId() );
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("delete from ORACLE DB productId =" + product.getProductId() );
    }

}

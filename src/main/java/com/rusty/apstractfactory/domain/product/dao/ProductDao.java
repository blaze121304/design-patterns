package com.rusty.apstractfactory.domain.product.dao;

import com.rusty.apstractfactory.domain.product.Product;

public interface ProductDao {

    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product prodcut);
}

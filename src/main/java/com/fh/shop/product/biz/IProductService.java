package com.fh.shop.product.biz;

import com.fh.shop.jar.ServerException;
import com.fh.shop.product.po.Product;

public interface IProductService {


    ServerException addProduct(Product product);

    ServerException list();

}

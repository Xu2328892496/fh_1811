package com.fh.shop.product.controller;

import com.fh.shop.jar.ServerException;
import com.fh.shop.product.biz.IProductService;
import com.fh.shop.product.po.Product;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:8000")
public class ProductController {

    @Resource(name = "productService")
    private IProductService iProductService;

    @GetMapping
    public ServerException list(){
        return iProductService.list();
    }

    @PostMapping
    public ServerException addProduct(Product product){
        return iProductService.addProduct(product);
    }
}

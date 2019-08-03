package com.fh.shop.product.biz;

import com.fh.api.brand.BrandApi;
import com.fh.api.brand.vo.BrandVo;
import com.fh.shop.jar.ServerException;
import com.fh.shop.product.mapper.IProductMapper;
import com.fh.shop.product.po.Product;
import com.fh.shop.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductMapper iProductMapper;

    @Autowired
    private BrandApi brandApi;

    public ServerException addProduct(Product product) {
        iProductMapper.insert(product);
        return ServerException.serverException();
    }

    public ServerException list() {
        List<Product> products = iProductMapper.selectList(null);
        List<ProductVo> productVoList = buildProductVo(products);
        return ServerException.serverException(productVoList);
    }

    private List<ProductVo> buildProductVo(List<Product> products) {
        List<ProductVo> productVoList = new ArrayList<>();
        for (Product product : products) {
            ProductVo productVo = new ProductVo();
            productVo.setId(product.getId());
            productVo.setName(product.getName());
            productVo.setPrice(product.getPrice());
            productVo.setClassifyName(product.getClassifyName());
            ServerException<BrandVo> brand = brandApi.queryBrandById(product.getBrandid());
            String b_name = brand.getData().getB_name();
            productVo.setBrandName(b_name);
            productVoList.add(productVo);
        }
        return productVoList;
    }
}

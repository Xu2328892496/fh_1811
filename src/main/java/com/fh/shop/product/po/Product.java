package com.fh.shop.product.po;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_shop")
public class Product implements Serializable {

    private static final long serialVersionUID = 5355520382347176470L;

    private Integer id;

    private String name;

    private Float price;

    private Integer brandid;

    private Integer gc1;

    private Integer gc2;

    private Integer gc3;

    private String classifyName;

}

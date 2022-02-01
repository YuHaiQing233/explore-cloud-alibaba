package com.explore.product.controller;

import com.explore.product.dto.ProductReductionRequest;
import com.explore.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 产品 控制器类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 19:01
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductService productService;


    @GetMapping("/info")
    public String info(){
        return "服务名称: cloud-product, 端口: " + port;
    }


    @PostMapping("/reduction")
    public Boolean reduction(@RequestBody ProductReductionRequest request){
        return productService.reduction(request);
    }

}

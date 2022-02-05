package com.explore.product.controller;

import com.explore.base.ResultResponse;
import com.explore.product.dto.ProductReductionRequest;
import com.explore.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
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
    public ResultResponse<String> info(){
        return ResultResponse.success("服务名称: cloud-product, 端口: " + port);
    }


    @PostMapping("/reduction")
    @Transactional(rollbackFor = Exception.class)
    public Boolean reduction(@RequestBody ProductReductionRequest request){
        int number = 10 / 0 ;
        return productService.reduction(request);
    }

}

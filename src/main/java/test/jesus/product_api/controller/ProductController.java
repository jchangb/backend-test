package test.jesus.product_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.jesus.product_api.config.ProductAPIConfig;
import test.jesus.product_api.service.ProductService;
import test.jesus.product_api.model.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductAPIConfig productAPIConfig;

    @Autowired
    private ProductService service;

    @GetMapping("/{id}/similar")
    public List<Product> GetSimilarProducts(@PathVariable String id){
        return service.GetSimilarProducts(id);
    }
}

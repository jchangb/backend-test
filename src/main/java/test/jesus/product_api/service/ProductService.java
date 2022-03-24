package test.jesus.product_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.jesus.product_api.model.Product;
import test.jesus.product_api.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product GetProductDetails(String id){
        return repository.GetProductById(id);
    }

    public List<Product> GetSimilarProducts(String id){
        List<Product> resultList = new ArrayList<>();
        var similarProducts = repository.GetSimilarProductsByProductId(id);
        if(similarProducts != null) {
            similarProducts.forEach(pid -> {
                var product = repository.GetProductById(pid);
                resultList.add(product);
            });
        }

        return resultList;

    }
}

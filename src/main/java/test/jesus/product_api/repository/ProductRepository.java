package test.jesus.product_api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import test.jesus.product_api.config.ProductAPIConfig;
import test.jesus.product_api.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    @Autowired
    private final ProductAPIConfig config;

    private ApiClient apiClient;

    @Value("${product-api.url}")
    private String productApiUrl;
    @Value("${product-api.request_timeout_in_seconds}")
    private int requestTimeoutInSeconds;

    @Autowired
    public void configure(){
        apiClient = new ApiClient(productApiUrl, requestTimeoutInSeconds);
    }

    public ProductRepository(ProductAPIConfig config) {
        this.config = config;
    }
    
    public Product GetProductById(String id){
        var uri = config.getEndpoint_product().replace("{id}", id);
        var response = apiClient.get(Product.class, uri);

        if(response.status == HttpStatus.OK)
            return response.body;
        else
            return null;
    }

    public List<String> GetSimilarProductsByProductId(String id){
        var uri = config.getEndpoint_productSimilarIds().replace("{id}", id);
        var response = apiClient.get(List.class, uri);

        if(response.status == HttpStatus.OK){
            var strList = new ArrayList<String>();
            for(Object i : response.body) strList.add(Integer.toString((int)i));
            return strList;
        } else return null;
    }
}

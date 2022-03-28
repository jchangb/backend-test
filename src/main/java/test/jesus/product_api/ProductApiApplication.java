package test.jesus.product_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import test.jesus.product_api.config.ProductAPIConfig;
import test.jesus.product_api.model.Product;

@SpringBootApplication
@EnableConfigurationProperties(ProductAPIConfig.class)
@EnableCaching
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}

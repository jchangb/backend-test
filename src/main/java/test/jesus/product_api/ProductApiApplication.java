package test.jesus.product_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import test.jesus.product_api.config.ProductAPIConfig;
import test.jesus.product_api.model.Product;

@SpringBootApplication
@EnableConfigurationProperties(ProductAPIConfig.class)
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}

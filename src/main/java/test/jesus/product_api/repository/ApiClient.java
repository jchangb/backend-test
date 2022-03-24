package test.jesus.product_api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import test.jesus.product_api.model.ApiResponse;
import java.time.Duration;

public class ApiClient {

    private int requestTimeoutInSeconds;

    private final WebClient webClient;

    ApiClient(String server, int timeout){
        webClient = WebClient.create(server);
        requestTimeoutInSeconds = timeout;
    }

    public <T> ApiResponse<T> get(Class<T> responseType, String uri){

        ApiResponse<T> response = new ApiResponse<T>();

        response.body = webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(result -> {
                    response.status = result.statusCode();
                    return result.bodyToMono(responseType);
                }).block(Duration.ofSeconds(requestTimeoutInSeconds));;

        return response;
    }
}

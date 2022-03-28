package test.jesus.product_api.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import test.jesus.product_api.model.ApiResponse;
import java.time.Duration;

public class ApiClient {

    private final int requestTimeoutInSeconds;
    private final WebClient webClient;

    ApiClient(String server, int timeout){
        webClient = WebClient.create(server);
        requestTimeoutInSeconds = timeout;
    }

    public <T> ApiResponse<T> get(Class<T> responseType, String uri) {
        ApiResponse<T> response = new ApiResponse<T>();
        try {
            response.body = webClient.get()
                    .uri(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("not found")))
                    .onStatus(HttpStatus::is5xxServerError,
                            error -> Mono.error(new RuntimeException("internal server error")))
                    .bodyToMono(responseType)
                    .block(Duration.ofSeconds(requestTimeoutInSeconds));
        } catch (RuntimeException re){
            ApiResponse<T> resp = new ApiResponse<T>();
            response.body = null;
            return resp;
        }
        return response;
    }
}

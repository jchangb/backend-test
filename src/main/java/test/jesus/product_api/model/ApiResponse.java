package test.jesus.product_api.model;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    public HttpStatus status;
    public T body;
}

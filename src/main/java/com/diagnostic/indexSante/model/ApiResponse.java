package com.diagnostic.indexSante.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer codeHttp;
    private HttpStatus status;
    private T data;

    public ApiResponse(Integer codeHttp, HttpStatus status, T data) {
        this.codeHttp = codeHttp;
        this.status = status;
        this.data = data;
    }
}

package com.diagnostic.indexSante.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }
}

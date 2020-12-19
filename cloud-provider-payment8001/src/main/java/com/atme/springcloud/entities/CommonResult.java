package com.atme.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private String error;
    private String message;
    private T data;

    public CommonResult(T data) {
        this(null, null, data);
    }

    public CommonResult(String error, String message) {
        this(error, message, null);
    }
}

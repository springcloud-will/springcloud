package com.atme.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private String instanceName;
    private String error;
    private String message;
    private T data;

    public CommonResult(String instanceName, T data) {
        this(instanceName, null, null, data);
    }

    public CommonResult(String instanceName, String error, String message) {
        this(instanceName, error, message, null);
    }
}

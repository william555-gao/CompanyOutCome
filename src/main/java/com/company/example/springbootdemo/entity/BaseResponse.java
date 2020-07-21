package com.company.example.springbootdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:BaseResponse
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/6/1 10:58
 * @Version: 1.0
 */
@Data
public class BaseResponse<T> implements Serializable {


    // 返回方法调用结果内容
    private String resultStr;
    //返回方法调用结果状态码
    private String resultStatusCode;
    // 返回方法调用结果标示
    private String resultMark;

    private T data;



}

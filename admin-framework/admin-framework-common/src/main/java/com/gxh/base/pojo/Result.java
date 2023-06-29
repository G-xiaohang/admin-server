package com.gxh.base.pojo;

import lombok.Data;

/**
 * 全局通用返回结果类
 */
@Data
public class Result<T> {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 请求返回的数据
     */
    private T data;

}

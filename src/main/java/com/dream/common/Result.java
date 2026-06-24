package com.dream.common;

import lombok.Data;

@Data // 如果你没装 Lombok，就手动生成 Getter/Setter
public class Result<T> {
    private Integer code;    // 状态码：200 成功，500 失败
    private String message;  // 提示消息
    private T data;          // 真正的宝贝（数据）

    // 快捷成功的静态方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    // 快捷失败的静态方法
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(msg);
        return result;
    }
}
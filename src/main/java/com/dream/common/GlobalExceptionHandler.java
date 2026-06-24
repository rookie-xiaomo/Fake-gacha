package com.dream.common;

import com.dream.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 这个注解告诉 Spring Boot：我是全局的异常大管家！
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 只要程序抛出 Exception（所有的报错），都会跑到这个方法里来
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        // 1. 在后台控制台偷偷打印真正的错误，方便我们开发时排查
        e.printStackTrace();

        // 2. 给用户返回一个温馨且体面的提示
        return Result.error("系统繁忙，请稍后再试（错误原因：" + e.getMessage() + "）");
    }
}
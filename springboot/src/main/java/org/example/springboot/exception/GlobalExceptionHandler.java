package org.example.springboot.exception;
import org.example.springboot.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice("org.example.springboot.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
            e.printStackTrace();
            return Result.error();
        }

    @ExceptionHandler(CustomerException.class)
    //主动抛出异常的部分有异常还没调试
    @ResponseBody
    public Result error(CustomerException e){
        e.printStackTrace();
        return Result.error(e.getCode(),e.getMessage());
    }

}

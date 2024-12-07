package org.example.springboot.common;

public class Result {
    private String code;
    private String msg;
    private Object data;



    public static Result success() {
        Result result =new Result();
        result.setCode("100");
        result.setMsg("请求成功！！你今天也很棒！！！");
        return result;
    }

    public static Result success(Object data) {
        Result result =success();
        result.setData(data);
        return result;
    }


public static Result error() {
        Result result =new Result();
        result.setCode("404");
        result.setMsg("系统错误啦！");
        return result;
}

public static Result error(String code,String msg) {
        Result result =new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

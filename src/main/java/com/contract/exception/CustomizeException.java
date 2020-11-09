package com.contract.exception;

//错误类
public class CustomizeException extends RuntimeException {
    private String message; //错误信息成员,用于存放错误的内容
    private Integer code;//错误代码

    public CustomizeException(ICustomizeErrorCode errorCode)        //重写构造方法
    {
        this.code = errorCode.getCode();
        //构造的时候利用错误代码接口的方法获得具体错误代码枚举中的错误信息
        this.message = errorCode.getMessage();
        //这里,ICustomizeErrorCode是一个接口,但是我们在构造的时候传入的是一个枚举,该枚举包含了错误信息,并且肯定有这个接口的方法
    }

    @Override
    public String getMessage() {
        return message;
    }   //get方法

    public Integer getCode() {
        return code;
    }
}

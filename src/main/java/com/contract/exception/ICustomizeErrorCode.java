package com.contract.exception;

public interface ICustomizeErrorCode        //错误接口
{
    //获得错误信息
    String getMessage();

    //获得错误代码
    Integer getCode();
}

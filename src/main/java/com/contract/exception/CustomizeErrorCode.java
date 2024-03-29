package com.contract.exception;

/**
 * 这是里负责question方面的错误枚举
 * 为了防止类爆炸,建议把枚举写成一个接口
 * 每个需要错误枚举的层面自己定义枚举继承该接口
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //其实这个枚举相当于一个方法,它就是下面的CustomizeErrorCode方法,调用该枚举就会把后面括号的东西作为方法参数来执行该方法
    //也就是把本类的message成员变成括号里的东西
    SYSTEM_ERROR(1000, "其他错误"),
    HAVE_ID_NUM(200, "该身份已经注册"),
    HAVEN_PHONE(2000,"该号码未注册"),
    CREATE_WRONG(2000,"注册失败,请联系管理员解决"),
    PASS_WRONG(2001,"密码错误"),
    SUPPLIER_STATUS_WRONG(2002,"账号已弃用"),
    SUPPLIER_INFO_WRONG(2000,"该号码在后台的数据出现错误,联系管理员解决"),
    SUPPLIER_WRONG(2000,"供货人信息有误"),
    NOT_SUPPLIER(2000,"没有该供货人,请先添加供货人"),
    SUPPLIER_INFO_LOST(2000,"供货人信息缺失"),
    SUPPLIER_IDNUM_LOST(2001,"供货人身份证号缺失"),
    SUPPLIER_BANKNUM_LOST(2002,"供货人银行卡号缺失"),
    SUPPLIER_BANKNUME_LOST(2003,"供货人开户行名缺失"),
    SUPPLIER_HOMEADDRESS_LOST(2004,"供货人家庭住址缺失"),
    SUPPLIER_PHONENUM_LOST(2005,"供货人电话号缺失"),
    SUPPLIER_ID0_LOST(2006,"供货人身份证正面照片缺失"),
    SUPPLIER_ID1_LOST(2007,"供货人身份证反面照片缺失"),
    SUPPLIER_BANK0_LOST(2008,"供货人银行卡正面照片缺失"),
    SUPPLIER_BANK1_LOST(2009,"供货人银行卡反面照片缺失"),
    UPDATE_ERROR(2010,"合同更新失败"),
    FILE_NAME_WRONG(3000, "文件名或者格式错误"),
    WRITE_FILE_WRONG(3000,"新文件写入错误"),
    CONTRACT_TEMPLATE_WRONG(3000,"后台生效合同模板数出错,请联系管理员"),
    NOT_CONTRACT_TEMPLATE(3000,"没有模板合同"),
    CONTRACT_TEMPLATE_IMAGE_WRONG(3000,"没有模板图片,请联系管理员上传"),
    NOT_ORDER(3001,"没有合同"),
    NOT_OSS_ORDER(3002,"合同未上传到云端"),
    ORDER_WRONG(3003,"合同订单数目出错"),
    ORDER_ID_WRONG(3004,"订单ID出错,数据库里查不到该订单"),
    ORDER_STATUS_WRONG(3005,"订单状态错误,只有待审核的订单才可以盖章"),
    ORDER_STATUS_WRONG2(3006,"订单状态错误,请确认输入了正确的状态"),
    ORDER_NUM_REPEAT(3007,"委托收购协议号重复!"),
    ORDER_REPEAT(3008,"合同重复"),
    IMAGE_WRONG(2000, "照片类别错误"),
    SQL_SEARCH_FAIL(4000, "数据库查询失败"),
    SQL_INSERT_FAIL(4000, "数据库插入失败"),
    SQL_UPDATE_FAIL(4000, "数据库更新失败"),
    COMPANY_INFO_WRONG(5001, "没有这家公司或者这家公司的信息数目有误"),
    COMPANY_WRONG(5000, "获取公司列表失败"),
    DOCX_TO_PDF_WRONG(6000,"docx转pdf失败"),
    NOT_PDF(6001,"该合同PDF文件不存在,请上传");




    //当然,枚举可以有很多个,每个都是一个传入参数不同但是方法过程相同的东西
    CustomizeErrorCode(String message) {
        this.message = message;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    private final String message;
    private int code;

    //重写接口方法
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}

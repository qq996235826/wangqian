package com.contract.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description
 * @date 2021/1/14 16:59
 */
@Data
@ApiModel(value = "AddByWebDTO",description = "添加order用的DTO类")
public class AddByWebDTO
{
    @ApiModelProperty(value = "协议id")
    private Long id;
    @ApiModelProperty(value = "收购协议编号")
    private String orderCode;
    @ApiModelProperty(value = "记录生成时间")
    private String createTime;
    @ApiModelProperty(value = "货物名称")
    private String itemName;
    @ApiModelProperty(value = "价格")
    private String price;
    @ApiModelProperty(value = "订单状态")
    private String status;
    @ApiModelProperty(value = "收购方名称")
    private String companyName;
    @ApiModelProperty(value = "收购方代号")
    private String companyCode;
    @ApiModelProperty(value = "供货人id")
    private Long supplierId;
    @ApiModelProperty(value = "供货人姓名")
    private String supplierName;
    @ApiModelProperty(value = "供货人身份证号")
    private String supplierIdNum;
    @ApiModelProperty(value = "供货人手机号")
    private String supplierPhone;
    @ApiModelProperty(value = "供货人地址")
    private String supplierHomeAddress;
    @ApiModelProperty(value = "开户银行名")
    private String bankName;
    @ApiModelProperty(value = "支行名")
    private String branchBankName;
    @ApiModelProperty(value = "银行卡号")
    private String bankNum;
    @ApiModelProperty(value = "银行卡照片地址")
    private String bankImage;
    @ApiModelProperty(value = "开始日期")
    private String startDate;
    @ApiModelProperty(value = "截止日期")
    private String endDate;
    @ApiModelProperty(value = "供货人手机号")
    private String phone;
    @ApiModelProperty(value = "货物重量")
    private String weight;
    @ApiModelProperty(value = "标记是否线上,线上为0,线下为1")
    private Integer origin;


}

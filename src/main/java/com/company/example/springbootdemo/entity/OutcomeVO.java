package com.company.example.springbootdemo.entity;

import lombok.Data;

/**
 * @ClassName:OutcomeVO
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 9:14
 * @Version: 1.0
 */

@Data
public class OutcomeVO extends BaseResponse {

    private String outcomeName;

    private String belongDomain;

    private String cooperationType;

    private String trandsactionPrice;

    private String useType;

    private String maturity;

}

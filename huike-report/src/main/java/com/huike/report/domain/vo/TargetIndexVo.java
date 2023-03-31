package com.huike.report.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TargetIndexVo {
    private String create_by;
    private String username;
    private String deptName;
    private Long num;
    private Integer numall;
    private BigDecimal radio;
}

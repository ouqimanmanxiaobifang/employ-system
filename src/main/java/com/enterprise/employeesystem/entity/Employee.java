package com.enterprise.employeesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 员工实体类
 * @Data：Lombok注解，自动生成get/set/toString/equals/hashCode
 * @TableName：MyBatis-Plus注解，映射数据库表名
 */
@Data
@TableName("employee")
public class Employee {
    // 主键自增
    @TableId(type = IdType.AUTO)
    private Long id;

    // 员工编号
    private String empCode;

    // 员工姓名
    private String empName;

    // 性别 1-男 2-女
    private Integer gender;

    // 年龄
    private Integer age;

    // 部门名称
    private String deptName;

    // 职位
    private String job;

    // 薪资
    private BigDecimal salary;

    // 手机号
    private String phone;

    // 创建时间（自动填充）
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间（自动填充）
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 逻辑删除（0-未删除 1-已删除）
    @TableLogic
    private Integer isDeleted;
}

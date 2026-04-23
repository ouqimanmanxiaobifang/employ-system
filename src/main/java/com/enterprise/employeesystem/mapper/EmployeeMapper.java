package com.enterprise.employeesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enterprise.employeesystem.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工Mapper
 * 继承BaseMapper：直接拥有增删改查方法，无需写XML
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    // 无需写任何代码，MyBatis-Plus自动实现CRUD
}

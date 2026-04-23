package com.enterprise.employeesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enterprise.employeesystem.entity.Employee;
import java.util.List;

/**
 * 员工业务接口
 */
public interface EmployeeService extends IService<Employee> {
    // 自定义业务方法：根据部门查询员工
    List<Employee> getByDept(String deptName);
}

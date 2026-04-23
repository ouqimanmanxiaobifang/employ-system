package com.enterprise.employeesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enterprise.employeesystem.entity.Employee;
import com.enterprise.employeesystem.mapper.EmployeeMapper;
import com.enterprise.employeesystem.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 员工业务实现类
 * @Service：将类交给Spring容器管理（IOC核心）
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    // 实现自定义方法：根据部门查询员工
    @Override
    public List<Employee> getByDept(String deptName) {
        // Lambda查询条件：避免字段名写错
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getDeptName, deptName);
        return this.list(wrapper);
    }
}

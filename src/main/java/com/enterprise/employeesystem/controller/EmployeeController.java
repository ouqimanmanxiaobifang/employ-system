package com.enterprise.employeesystem.controller;

import com.enterprise.employeesystem.common.R;
import com.enterprise.employeesystem.entity.Employee;
import com.enterprise.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//  这个类代表的含义,酒店前台
/**
 * 员工接口控制器
 * @RestController：组合注解，返回JSON数据    告诉 Spring，这个类是一个Controller（控制器），并且所有方法的返回值都会直接变成 JSON 格式返回给前端。
 * @RequestMapping：接口前缀    给整个类的所有接口统一加一个请求前缀, 这个类里的所有接口，地址都要以 /employee 开头。
 * 比如 list() 接口的完整地址是：/employee/list，而不是 /list。
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // @Autowired：自动注入业务对象（DI依赖注入）
    @Autowired
    private EmployeeService employeeService;

    // 1. 查询所有员工
    @GetMapping("/list")    //这是一个get请求的接口
    public R<List<Employee>> list() {
        List<Employee> list = employeeService.list();
        return R.success(list);
    }

    // 2. 根据ID查询员工
    @GetMapping("/get/{id}")
    public R<Employee> getById(@PathVariable Long id) { // @PathVariable从请求 URL 里获取参数，比如 /employee/get/1 里的 1，会被自动赋值给 id 变量
//        关键点：URL 里的 {id} 必须和 @PathVariable 修饰的参数名一致（如果不一致，要写 @PathVariable("id")）。
        Employee employee = employeeService.getById(id);
        return R.success(employee);
    }

    // 3. 新增员工
    @PostMapping("/add")
    public R<String> add(@RequestBody Employee employee) {//从请求的JSON 体里获取参数，自动把 JSON 数据转换成 Employee 对象。
        boolean save = employeeService.save(employee);
//        等价于
//  if (save) {
//    return R.success();
//} else {
//    return R.failed();
//}
        return save ? R.success() : R.failed();
    }

    // 4. 修改员工
    @PutMapping("/update")
    public R<String> update(@RequestBody Employee employee) {
        boolean update = employeeService.updateById(employee);
        return update ? R.success() : R.failed();
    }

    // 5. 删除员工（逻辑删除）
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id) {
        boolean remove = employeeService.removeById(id);
        return remove ? R.success() : R.failed();
    }

    // 6. 根据部门查询员工
    @GetMapping("/dept/{deptName}")
    public R<List<Employee>> getByDept(@PathVariable String deptName) {
        List<Employee> list = employeeService.getByDept(deptName);
        return R.success(list);
    }
}

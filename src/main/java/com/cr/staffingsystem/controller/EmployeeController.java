package com.cr.staffingsystem.controller;

import com.cr.staffingsystem.dao.DepartmentDao;
import com.cr.staffingsystem.dao.EmployeeDao;
import com.cr.staffingsystem.pojo.Department;
import com.cr.staffingsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/employees")
    public String getAllEmployees(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/employee")
    public String toAddEmployeePage(Model model){
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "employee/add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
       // System.out.println("add=>"+employee.toString());
        employeeDao.addEmployee(employee);
        return "redirect:/employees";
    }
    /**
    * @Description: 跳转至修改员工信息页面
    * @Param: 
    * @return: 
    * @Author: cr
    * @Date: 2020/4/9
    */ 
    @GetMapping("/employee/{id}")
    public String toModifyPage(@PathVariable Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "employee/modify";
    }

    /**
    * @Description: 修改员工信息并返回到主页
    * @Param:
    * @return:
    * @Author: cr
    * @Date: 2020/4/9
    */
    @PostMapping("/employee/update")
    public String updateEmployee(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/del/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}

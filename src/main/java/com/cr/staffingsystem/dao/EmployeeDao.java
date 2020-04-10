package com.cr.staffingsystem.dao;

import com.cr.staffingsystem.pojo.Department;
import com.cr.staffingsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();

        employees.put(1001,
                new Employee(1001,"AA","aa10086@qq.com",1,
                        new Department(101,"市场部")));
        employees.put(1002,
                new Employee(1002,"BB","bb10086@qq.com",0,
                        new Department(202,"研发部")));
        employees.put(1003,
                new Employee(1003,"CC","cc10086@qq.com",0,
                        new Department(303,"后勤部")));
        employees.put(1004,
                new Employee(1004,"DD","dd10086@qq.com",1,
                        new Department(404,"指挥部")));
    }

    /**
     * 查询全部员工信息
     */
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //自增主键
    private Integer initId = 1005;
    /**
     * 添加一个员工
     */
    public void addEmployee(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }
    /**
     * 判断员工是否存在
     */
    private boolean isExist(Integer id){
        return (employees.get(id)==null)?false:true;
    }
    /**
     * 根据id查询员工
     */
    public Employee getEmployeeById(Integer id){
       return employees.get(id);
    }
    /**
     * 删除一个员工
     */
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

}

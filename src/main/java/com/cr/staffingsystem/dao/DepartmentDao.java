package com.cr.staffingsystem.dao;

import com.cr.staffingsystem.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {

    //模拟数据库
    private static Map<Integer,Department> departments = null;

    static {
        departments = new HashMap<>();

        departments.put(101, new Department(101,"市场部"));
        departments.put(202, new Department(202,"研发部"));
        departments.put(303, new Department(303,"后勤部"));
        departments.put(404, new Department(404,"指挥部"));
    }
    /**
     * 获得全部部门信息
     */
    public Collection<Department> getAll(){
        return departments.values();
    }

    /**
     * 根据id获取部门名称
     */
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}

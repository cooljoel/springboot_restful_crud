package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查出所有员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //来修改页面，查出当前员工，并回显
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("保存员工的信息" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model m) {
        Employee employee = employeeDao.get(id);
        m.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        m.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String editEmp(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

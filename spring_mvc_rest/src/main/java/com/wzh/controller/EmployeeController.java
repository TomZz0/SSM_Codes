package com.wzh.controller;

import com.wzh.dao.EmployeeDao;
import com.wzh.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author wzh
 * @date 2023年03月24日 15:58
 * Description:
 * 查询全部数据 /employee-->get
 * 跳转到添加页面 /to/add/-->get
 * 新增员工信息-->/employee-->post
 * 跳转到修改页面-->/employee/1-->get
 * 修改员工信息-->/employee-->put
 * 删除员工 -->/employee/1-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployees(HttpServletRequest req) {
        //获取所有的员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //放置到请求域中
        req.getSession().setAttribute("employees", employees);
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存用户
        employeeDao.save(employee);
        //重定向到列表功能 默认是get方式 就是获取所有用户
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String updateEmployee1(@PathVariable("id") Integer id, Model model){
        //通过id查询用户
        Employee employee = employeeDao.get(id);
        //将查询到的要修改的用户共享到域中
        model.addAttribute("employee",employee);
        //重跳转到
        return "employee_update";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee2(Employee employee){
        employeeDao.save(employee);
        //重定向到修改页面
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        //重定向到修改页面
        return "redirect:/employee";
    }
}

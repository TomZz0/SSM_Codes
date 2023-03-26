package com.wzh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.wzh.ssm.pojo.Emp;
import com.wzh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.List;

/**
 * @author wzh
 * @date 2023年03月25日 21:09
 * Description:
 *  * 查询所有员工信息: -->/employee-->get方法
 *  * 查询员工分页信息: -->/employee/page/1-->get方法
 *  * 查询id=1的员工信息: -->/employee/1-->get方法
 *  * 添加员工信息: -->/employee-->post方法
 *  * 修改员工信息: -->/employee-->put方法
 *  * 删除员工信息: -->/employee/1-->delete方法
 */
@Controller
public class EmployeeController {
    //报错有很多原因 比如遗漏注解 或者service类没有实现接口
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{curPage}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("curPage")Integer curPage,Model model){
        //获取员工的分页信息
        PageInfo<Emp> page = employeeService.getaEmployeePage(curPage);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        //跳转到分页页面
        return "employee_list";
    }
    /**
     * 获取所有员工信息
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Emp> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到分页页面
        return "employee_list";
    }
}

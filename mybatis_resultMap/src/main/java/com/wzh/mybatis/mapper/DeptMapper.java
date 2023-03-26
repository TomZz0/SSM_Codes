package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分布查询查询员工信息和部门信息的方法二(多对一查询)
     * @return
     */
    Dept getEmpAndDeptByEmpIdStepTwo(@Param("deptId") Integer deptId);

    /**
     * 一对多查询且分布查询 部门下有许多归属员工
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptIdStepOne(@Param("deptId") Integer deptId);

    /**
     * 一对多查询 collection标签设置
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
}

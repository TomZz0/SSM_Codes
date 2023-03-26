package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 通过empId获取Emp对象
     *
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 通过empId获取Emp对象
     *
     * @param empId
     * @return
     */
    Emp getEmpByEmpIdOld(@Param("empId") Integer empId);

    /**
     * 在Emp对象中有对应Dept的对象 直接查询无法对应 会返回null 则该如何进行字段和属性的映射? 三种方法
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 分布处理连表查询 步骤一 得到Emp对象
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpIdStepOne(@Param("empId") Integer empId);

    /**
     * 一对多 分布查询 第二布
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByDeptIdStepTwo(@Param("deptId") Integer deptId);
}

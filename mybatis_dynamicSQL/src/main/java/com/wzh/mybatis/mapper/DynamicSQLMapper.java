package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 多条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 使用choose标签查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量插入emp
     * @param emps
     */
    void insertEmps(@Param("emps") List<Emp> emps);


    /**
     * 通过数组传入id 批量删除
     * @param empIds
     */
    void deleteEmps(@Param("empIds") Integer[] empIds);
}

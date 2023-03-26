package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     * 通过员工Id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);
}

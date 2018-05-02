package com.huaweisoft.training.dao;

import com.huaweisoft.training.entity.Employee;

public interface EmployeeMapper {

	Employee selectByPrimaryKey(Integer id);
}
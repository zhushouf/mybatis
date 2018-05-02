package com.huaweisoft.training;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaweisoft.training.dao.EmployeeMapper;
import com.huaweisoft.training.entity.Employee;
import com.huaweisoft.training.entity.EmployeeExample;
import com.huaweisoft.training.entity.EmployeeExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestMybatis {

	private static final Logger log = Logger.getLogger(TestMybatis.class);

	@Autowired
	private EmployeeMapper employeeMapper;

	@Test
	public void test1() {
		Employee employee = employeeMapper.selectByPrimaryKey(1);
		if (employee != null) {
			log.info(JSON.toJSONString(employee, true));
		}
	}

	/**
	 * 按查询条件
	 */
	@Test
	public void test2() {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andGenderEqualTo(1);
		criteria.andNameLike("赵%");
		List<Employee> list = employeeMapper.selectByExample(example);
		if (list != null) {
			log.info(JSON.toJSONString(list, true));
		}
	}

	/**
	 * 分页插件
	 */
	@Test
	public void test3() {
		int pageNum = 2;
		int pageSize = 2;
		PageHelper.startPage(pageNum, pageSize);

		EmployeeExample example = new EmployeeExample();
		List<Employee> list = employeeMapper.selectByExample(example);
		if (list != null) {
			log.info(JSON.toJSONString(list, true));
		}
		
		PageInfo<Employee> info = new PageInfo<>(list);
		log.info(JSON.toJSONString(info, true));
	}

	@Test
	public void test4() {
		Employee employee = employeeMapper.selectByPrimaryKey(1);
		if (employee != null) {
			log.info(JSON.toJSONString(employee, true));
		}
	}
}

package com.huaweisoft.training.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;
import com.huaweisoft.training.dao.EmployeeMapper;
import com.huaweisoft.training.entity.Employee;

public class TestMybatis {

	/*
	 * 获取数据库访问链接
	 */
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		try {
			InputStream stream = Resources.getResourceAsStream("config/mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	/*
	 * 获取数据库访问链接
	 */
	public static void closeSession(SqlSession session) {
		session.close();
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.selectByPrimaryKey(2);
			System.out.println(JSON.toJSONString(employee, true));
		} finally {
			session.close();
		}
	}
}

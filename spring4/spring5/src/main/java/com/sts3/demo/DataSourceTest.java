package com.sts3.demo;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	Logger logger = Logger.getLogger(DataSourceTest.class);
	@Autowired
	public DataSource dataSource = null;
	@Test
	public void testConnection() {
		logger.info("testConnection 호출 성공");
		try {
			Connection con = dataSource.getConnection();
			logger.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}	
}

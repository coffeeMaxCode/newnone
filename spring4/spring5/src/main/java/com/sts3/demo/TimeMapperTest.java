package com.sts3.demo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.mapper.TimeMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTest {
	Logger logger = Logger.getLogger(TimeMapperTest.class);
	@Autowired
	private TimeMapper timeMapper = null;
	@Test
	public void testGetTime() {
		logger.info("testGetTime 호출 성공");
		logger.info(timeMapper.getTime());
	}	
}

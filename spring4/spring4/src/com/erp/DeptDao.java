package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);

	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void deptUpdate(DeptVO dVO) throws DataAccessException  {
		logger.info("DeptDao.deptUpdate");
		dVO = new DeptVO();

		dVO.setDeptno(99);
		dVO.setDname("기술영업 NY팀");
		dVO.setLoc("NewYork");

		// 한줄로 DB 연동하기
		sqlSessionTemplate.update("deptUpdate",dVO);
	}

}

package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.EmpVO;

public class EmpDao {
	Logger logger = Logger.getLogger(EmpDao.class);

	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void empInsert(EmpVO eVO) throws DataAccessException {
		logger.info("EmpDao.empInsert");
		eVO = new EmpVO();	
		
		/* empno : 새로운것 // deptno : 기존에 있는 것 */
		eVO.setEmpno(9595);
		eVO.setEname("김유신");
		eVO.setDeptno(99);
		//eVO.setHiredate(hiredate);
		//eVO.setComm(comm);
		//eVO.setJob(job);
		//eVO.setMgr(mgr);
		//eVO.setSal(sal);
		
		// 한줄로 DB 연동하기
		sqlSessionTemplate.insert("empInsert",eVO);
	}

}

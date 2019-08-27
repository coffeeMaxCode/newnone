package com.erp;

import org.apache.log4j.Logger;

import com.vo.EmpVO;

//@service
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	
	//@Autowired
	public DeptDao deptDao = null;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
		

}

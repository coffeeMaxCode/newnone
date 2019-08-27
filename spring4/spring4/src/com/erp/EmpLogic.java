package com.erp;

import org.apache.log4j.Logger;

import com.vo.EmpVO;

//@service
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	
	//@Autowired
	public DeptDao deptDao = null;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public EmpDao empDao = null;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public void doEmp(EmpVO eVO) {
		try {
			empDao.empInsert(null);
			deptDao.deptUpdate(null);
		} catch (Exception e) {
			throw e;
		}
		
	}

	public void eudEmp(EmpVO eVO) {
		try {
			empDao.empInsert(null);
			deptDao.deptUpdate(null);
		} catch (Exception e) {
			throw e;
		}
		
	}

}

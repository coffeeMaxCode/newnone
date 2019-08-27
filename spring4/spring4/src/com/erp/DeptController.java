package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vo.DeptVO;

public class DeptController extends MultiActionController {
	Logger logger = Logger.getLogger(DeptController.class);
	
	public deptInsert deptInsert = null;

	public void setDeptInsert(deptInsert deptInsert) {
		this.deptInsert = deptInsert;
	}
	
	public String doDept(HttpServletRequest req, HttpServletResponse res) {
		logger.info("DeptController.doEmp");
		DeptVO dVO = new DeptVO();
		deptInsert.doDept(dVO);
		return "redirect:empInsertOk.jsp";
	}
	

}

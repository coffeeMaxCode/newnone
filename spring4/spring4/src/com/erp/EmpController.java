package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vo.EmpVO;

public class EmpController extends MultiActionController {
	Logger logger = Logger.getLogger(EmpController.class);
	
	public EmpLogic empLogic = null;
	
	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}
	
	public String doEmp(HttpServletRequest req, HttpServletResponse res) {
		logger.info("EmpController.doEmp");
		EmpVO eVO = new EmpVO();
		empLogic.eudEmp(eVO);
		return "redirect:empInsertOk.jsp";
	}

	 
}

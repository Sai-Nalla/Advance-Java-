package com.nt.service;

import com.nt.beans.EmployeeBean;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Override
	public void processResult(EmployeeBean emp) {
		//calculate netSal and gross Sal 
		float grossSal=emp.getEmpsal()+emp.getEmpsal()*0.3f;
		emp.setGrossSal(grossSal);
		float netSal=emp.getGrossSal()+emp.getEmpsal();
		emp.setNetSal(netSal);
	}

	
}

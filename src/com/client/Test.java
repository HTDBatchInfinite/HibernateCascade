package com.client;

import com.dao.StudentDao;
import com.daoimpl.StudentDaoImpl;

public class Test {

	public static void main(String[] args) {
		
	StudentDao studentDao=new StudentDaoImpl();
	            studentDao.insertStudentData();
	           //studentDao.cascadeAll();
		    
	}
}

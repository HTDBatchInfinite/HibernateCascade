package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.StudentDao;
import com.domain.Address;
import com.domain.Student;
import com.utill.HibernateUtill;

/**
 * @author Suresh
 * 
 */

public class StudentDaoImpl implements StudentDao {

	@Override
	public void insertStudentData() {

		try {
			List<Address> list = new ArrayList();

			Address address = new Address();
			address.setCountry("India");
			address.setState("AP");
			address.setCity("Ongole");

			Address address1 = new Address();
			address1.setCountry("India");
			address1.setState("AP");
			address1.setCity("Ongole");

			list.add(address);
			list.add(address1);
			
       		Student student = new Student();
			student.setStuName("Rakesh");
			student.setAddress(list);
			
			

			Session session = HibernateUtill.getsession();

			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception :::::" + e.getMessage());
			System.err.println("Hibernate Exception :::::" + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException ::::" + e.getMessage());
			System.err.println("NullPointerException ::::" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			System.out.println("Exception ::::" + e.getMessage());
			System.err.println("Exception ::::" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void cascadeAll() {

		int value = 0;
		try {

			Session session = HibernateUtill.getsession();

			Student student = (Student) session.load(Student.class, 1);

			System.out.println("Student Id " + student.getStuID());
			System.out.println("Student Name " + student.getStuName());

			List<Address> addresses = student.getAddress();

			for (Address address : addresses) {
				
				session.delete(address);
			}
			System.out.println("Id " + value);

			Transaction transaction=session.beginTransaction();
			transaction.commit();
			
			

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception :::::" + e.getMessage());
			System.err.println("Hibernate Exception :::::" + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException ::::" + e.getMessage());
			System.err.println("NullPointerException ::::" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			System.out.println("Exception ::::" + e.getMessage());
			System.err.println("Exception ::::" + e.getMessage());
			e.printStackTrace();
		}

	}

}

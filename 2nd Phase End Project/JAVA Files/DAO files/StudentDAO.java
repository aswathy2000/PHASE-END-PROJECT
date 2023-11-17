package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.dbutil.DbUtil;
import com.project.pojo.Student;

public class StudentDAO {
	
	public int addStudent(Student student)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(student);

		transaction.commit();
		session.close();

		return value;	
	}

	public List<Student> displayStudent()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Student");
		List<Student> listStudents = query.list();

		transaction.commit();
		session.close();
		return listStudents;

	}

	public List<Student> deleteStudent(Student student)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(student);

		transaction.commit();
		session.close();
		return displayStudent();

	}

	public void updateStudent(Student student)
	{

		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();	

		Query query= session.createQuery("update Student set studentName=:sname, studentAddress=:sAddress, studentPhoneNo=:sPhoneNo, studentDOB =:sDOB, classes=:sClass  where studentId=:sId");
		
		session.update(student);

		transaction.commit();
		session.close();
	}

}

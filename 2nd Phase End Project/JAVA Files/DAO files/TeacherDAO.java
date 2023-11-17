package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.dbutil.DbUtil;
import com.project.pojo.Teacher;

public class TeacherDAO {

	public int addTeacher(Teacher teacher)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(teacher);

		transaction.commit();
		session.close();

		return value;	
	}

	public List<Teacher> displayTeacher()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Teacher");
		List<Teacher> listTeachers = query.list();

		transaction.commit();
		session.close();
		return listTeachers;

	}

	public List<Teacher> deleteTeacher(Teacher teacher)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(teacher);

		transaction.commit();
		session.close();
		return displayTeacher();

	}

	public void updateTeacher(Teacher teacher)
	{

		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();


		Query query= session.createQuery("update Teacher set teacherName=:tname, teacherDesignation=:tDesignation where teacherId=:tId");

		session.update(teacher);

		transaction.commit();
		session.close();
	}

	public Teacher getTeacherByName(String teacherName) {
		try {
			Session session = DbUtil.dbConn();
			Transaction transaction = session.beginTransaction();

			Query<Teacher> query = session.createQuery("FROM Teacher WHERE teacherName = :name", Teacher.class);
			query.setParameter("name", teacherName);
			Teacher teacher = query.uniqueResult();

			transaction.commit();
			session.close();

			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception as per your application's needs
			return null;
		}
	}

	public Teacher getTeacherById(int teacherId) {
		try {
			Session session = DbUtil.dbConn();
			Teacher teacher = session.get(Teacher.class, teacherId);
			session.close();
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}

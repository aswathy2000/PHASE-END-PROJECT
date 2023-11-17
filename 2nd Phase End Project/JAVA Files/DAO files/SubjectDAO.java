package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.dbutil.DbUtil;
import com.project.pojo.Subject;

public class SubjectDAO 
{


	public int addSubject(Subject subject)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(subject);

		transaction.commit();
		session.close();

		return value;	
	}

	public List<Subject> displaySubject()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Subject");
		List<Subject> listSubjects = query.list();

		transaction.commit();
		session.close();
		return listSubjects;

	}

	public List<Subject> deleteSubject(Subject subject)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(subject);

		transaction.commit();
		session.close();
		return displaySubject();

	}

	public void updateSubject(Subject subject)
	{

		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();


		Query query= session.createQuery("update Subject set subjectName=:sname where subjectId=:sId");

		session.update(subject);

		transaction.commit();
		session.close();
	}

	public Subject getSubjectById(int subjectId) {
		try {
			Session session = DbUtil.dbConn();
			Subject subject = session.get(Subject.class, subjectId);
			session.close();
			return subject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public Subject getSubjectsByName(String subjectName) {
	    try {
	        Session session = DbUtil.dbConn();
	        Transaction transaction = session.beginTransaction();
	        Query<Subject> query = session.createQuery("FROM Subject WHERE subjectName = :name", Subject.class);
	        query.setParameter("name", subjectName);
	        Subject subject = query.uniqueResult();
	        transaction.commit();
	        session.close();
	       
	        return subject;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception as per your application's needs
	        return null;
	    }
	}






}

package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.dbutil.DbUtil;
import com.project.pojo.Classes;

public class ClassDAO {
	
	public int addClasses(Classes classes)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(classes);

		transaction.commit();
		session.close();

		return value;	
	}

	public List<Classes> displayClasses()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Classes");
		List<Classes> listStudents = query.list();

		transaction.commit();
		session.close();
		return listStudents;

	}

	public List<Classes> deleteClasses(Classes classes)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(classes);

		transaction.commit();
		session.close();
		return displayClasses();

	}

	public void updateClasses(Classes classes)
	{

		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();	

		Query query= session.createQuery("update Classes set className=:cname where classId=:cId");
		
		session.update(classes);

		transaction.commit();
		session.close();
	}
	
	public List<Classes> getClassesByName(String className) {
	    try {
	        Session session = DbUtil.dbConn();
	        Transaction transaction = session.beginTransaction();

	        Query<Classes> query = session.createQuery("FROM Classes WHERE className = :name", Classes.class);
	        query.setParameter("name", className);
	        List<Classes> subjects = query.list();

	        transaction.commit();
	        session.close();
	        return subjects;
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	

}

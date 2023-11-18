package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dbUtil.DbUtil;
import com.pojo.Admin;


public class AdminDAO {
	
	
	public int addAdmin(Admin admin)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(admin);

		transaction.commit();
		session.close();

		return value;	
	}
	
	public boolean validateAdmin(String adminemail, String adminpassword)
	{

		Session session = DbUtil.dbConn();
		
		{
			Query<Admin> query = session.createQuery("from Admin where adminEmail = :email", Admin.class);
			query.setParameter("email", adminemail);
			Admin admin = query.uniqueResult();
			if (admin!= null && admin.getAdminPassword().equals(adminpassword)) 
			{
				return true;
			} 
			else 
			{
				return false;
			}
		}	
	}

}

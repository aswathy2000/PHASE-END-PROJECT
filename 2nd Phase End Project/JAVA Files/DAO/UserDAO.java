package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.dbUtil.DbUtil;
import com.pojo.User;

public class UserDAO 
{

	public int addUser(User user)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(user);

		transaction.commit();
		session.close();

		return value;	
	}


	public boolean validateUser(String useremail, String password)
	{

		Session session = DbUtil.dbConn();
		
		{
			Query<User> query = session.createQuery("from User where userEmail = :email", User.class);
			query.setParameter("email", useremail);
			User u = query.uniqueResult();
			if (u != null && u.getUserPassword().equals(password)) 
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

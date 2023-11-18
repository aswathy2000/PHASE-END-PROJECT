package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.dbUtil.DbUtil;
import com.pojo.railwayCrossingData;

public class railwayCrossingDataDAO 
{

	public int addRailwayCrossingData(railwayCrossingData crossingData)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		int value = (Integer) session.save(crossingData);

		transaction.commit();
		session.close();

		return value;	
	}

	public List<railwayCrossingData > displayRailwayCrossingData()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from railwayCrossingData");
		List<railwayCrossingData > listData = query.list();

		transaction.commit();
		session.close();
		return listData;

	}

	public List<railwayCrossingData > deleteRailwayCrossingData(railwayCrossingData  crossingData)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(crossingData);

		transaction.commit();
		session.close();
		return displayRailwayCrossingData();

	}

	public void updateRailwayCrossingData(railwayCrossingData  crossingData)
	{

		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();


		Query query= session.createQuery("update railwayCrossingData set crossingName=:cname, "
				+ "address=:caddress, landmark=: clandmark, trainSchedule=:ctime, personInCharge =:cperson, "
				+ "statusCrossing=: cstatus "
				+ "where crossingId=:cId");

		session.update(crossingData);

		transaction.commit();
		session.close();
	}
	
	public List<railwayCrossingData > searchRailwayCrossingData(String search)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from railwayCrossingData as rc where rc.crossingName like ?0");
		query.setString(0, "%"+search+"%");
		List<railwayCrossingData > listCrossingData = query.list();

		transaction.commit();
		session.close();
		return listCrossingData;

	}
	
}

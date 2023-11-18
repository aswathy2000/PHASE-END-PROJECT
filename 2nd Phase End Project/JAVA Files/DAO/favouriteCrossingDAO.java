package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.dbUtil.DbUtil;
import com.pojo.favouriteCrossing;
import com.pojo.railwayCrossingData;

public class favouriteCrossingDAO {
	public int addfavouriteCrossing(favouriteCrossing favCrossingData)
	{
		Session session = DbUtil.dbConn();
	    Transaction transaction = session.beginTransaction();
	    int value = (Integer) session.save(favCrossingData);
	    transaction.commit();
	    session.close();
	    return value;
	}

	public List<favouriteCrossing > displayfavouriteCrossing()
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from favouriteCrossing");
		List<favouriteCrossing > listCrossings = query.list();

		transaction.commit();
		session.close();
		return listCrossings;
	}

	public List<favouriteCrossing> deletefavouriteCrossing(favouriteCrossing  favcrossingData)
	{
		Session session = DbUtil.dbConn();
		Transaction transaction = session.beginTransaction();

		session.delete(favcrossingData);

		transaction.commit();
		session.close();
		return displayfavouriteCrossing();
	}

	public railwayCrossingData getRailwayCrossingById(int crossingId) {
	   	 try
	   	 {
	   		 Session session = DbUtil.dbConn();
	   		 railwayCrossingData crossing = session.get(railwayCrossingData.class, crossingId);
	   		 session.close();
	   		 return crossing;
	   	 }
	   	 catch (Exception e) {
	   		 e.printStackTrace();
	   		 return null;
	   	 }
	    }

}

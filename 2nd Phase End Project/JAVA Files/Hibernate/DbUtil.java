package com.dbUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class DbUtil 
{

	static StandardServiceRegistry ssr=null;
	static Metadata md=null;
	static SessionFactory sf=null;
	static Session s=null;

	public static Session dbConn() {
		
		ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
		md=new MetadataSources(ssr).getMetadataBuilder().build();	
			
		sf=md.getSessionFactoryBuilder().build();
		
		return sf.openSession();
	}
}

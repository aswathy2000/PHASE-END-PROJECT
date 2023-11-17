package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.dbutil.DbUtil;
import com.project.pojo.Classes;
import com.project.pojo.Subject;
import com.project.pojo.Teacher;
import com.project.pojo.Student;

public class ClassSubjectTeacherDAO 
{
		 public List<Classes> getClassesByClassName(String className) {
		       try {
		           Session session = DbUtil.dbConn();
		           String hql = "SELECT c FROM Classes c JOIN FETCH c.teacher t JOIN FETCH c.subject s WHERE c.className = :className";
		           Query<Classes> query = session.createQuery(hql, Classes.class);
		           query.setParameter("className", className);
		           List<Classes> classesList = query.list();
		           session.close();
		           return classesList;
		       } catch (Exception e) {
		           e.printStackTrace();
		           return null;
		       }
		 }

}

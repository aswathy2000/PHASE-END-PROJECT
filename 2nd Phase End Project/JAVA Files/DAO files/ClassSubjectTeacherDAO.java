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
	
//	 Session sessionHb = session.openSession();
//    String sql = "select stud.firstname,stud.roll,sub.subjectname,cls.classname,exam.exam_name,exam.from_time,exam.to_time,exam.exam_date from Student stud,Subject sub,Classs cls,Exam exam where exam.classs=cls.id and exam.subject=sub.id and sub.classs=cls.id and stud.classs=cls.id and stud.roll= :roll";
//    SQLQuery query = sessionHb.createSQLQuery(sql);
//    query.setParameter("roll", a);
//    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//    return query.list();
	
	
	
	
	//String query = "select c.classId, c.className, t.teacherName, s.subjectName from Classes c join Teacher t ON c.teacherId = t.teacherId Join Subject s ON c.subjectId = s.subjectId  where c.className =:c.cName order by c.classId";
	

//	Query query = session.createQuery(query);
//	List<Classes> listStudents = query.list();
	
	
//	public List<Object[]> viewReport(String classname)
//	{
//				
//		Session session = DbUtil.dbConn();
//		Transaction transaction = session.beginTransaction();
//		
//		Query query= session.createQuery("select c.classId, c.className, t.teacherName, s.subjectName "
//				+ "from Classes c join Teacher t ON c.teacherId = t.teacherId "
//				+ "Join Subject s ON c.subjectId = s.subjectId  "
//				+ "where c.className =:c.cName order by c.classId");
//		
//		query.setParameter("cName", classname);
//		
//		List<Object[]> classObj = query.list();
//			
//		
//		transaction.commit();
//		session.close();
//	}
		
//		Object[] obj;
//		for(obj : classObj)
//		{
//			Classes classOb = new Classes();
//			classOb.setClassId(Integer.parseInt((obj[0].toString())));
//			classOb.setClassName(obj[1].toString());
//			classOb.getSubject().setSubjectName(obj[2].toString());
//			classOb.getTeacher().setTeacherName(obj[3].toString());
//		}
		
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

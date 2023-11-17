package com.project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;

	private String className;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherId")	
	private Teacher teacher;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectId")	
	private Subject subject;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}

package com.project.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int teacherId;
	
	private String teacherName;
	private String teacherDesignation;
	
	public Teacher() {
		super();
	}

	public Teacher(int teacherId, String teacherName, String teacherDesignation) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherDesignation = teacherDesignation;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherDesignation() {
		return teacherDesignation;
	}

	public void setTeacherDesignation(String teacherDesignation) {
		this.teacherDesignation = teacherDesignation;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherDesignation="
				+ teacherDesignation + "]";
	}
	
	
}

package com.carl.rdj.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student{
	@Id
	@Column(name="stu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int stu_id;
	@Column(name="stu_fullname")
	public String stu_fullname;
	@Column(name="stu_date")
	public Date stu_date;
	@Column(name="stu_status")
	public int stu_status;
	
	//Constructor vacío
	public Student() {
		super();
	}
	
	//Constructor con parametros estrablecidos al intacia la clase
	public Student(int stu_id, String stu_fullname, Date stu_date, int stu_status) {
		super();
		this.stu_id = stu_id;
		this.stu_fullname = stu_fullname;
		this.stu_date = stu_date;
		this.stu_status = stu_status;
	}
	
	//Getter y Setter
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_fullname() {
		return stu_fullname;
	}
	public void setStu_fullname(String stu_fullname) {
		this.stu_fullname = stu_fullname;
	}
	public Date getStu_date() {
		return stu_date;
	}
	public void setStu_date(Date stu_date) {
		this.stu_date = stu_date;
	}
	public int getStu_status() {
		return stu_status;
	}
	public void setStu_status(int stu_status) {
		this.stu_status = stu_status;
	}
	
	
}

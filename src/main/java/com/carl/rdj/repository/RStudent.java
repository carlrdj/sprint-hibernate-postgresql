package com.carl.rdj.repository;

import java.util.List;

import com.carl.rdj.model.Student;

public interface RStudent {
	List<Student> getListStudents();
	Student getStudentById(int id);
	Student getStudentByFullname(String fullname);
	void insertStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int id);
}

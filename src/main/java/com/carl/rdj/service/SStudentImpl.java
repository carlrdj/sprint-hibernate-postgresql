package com.carl.rdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carl.rdj.model.Student;
import com.carl.rdj.repository.RStudent;

@Service(value = "studentService")
@Transactional
public class SStudentImpl implements SStudent{

	@Autowired
	private RStudent rStudent;
	
	@Override
	public List<Student> getListStudents() {
		return rStudent.getListStudents();
	}

	@Override
	public Student getStudentById(int id) {
		return rStudent.getStudentById(id);
	}

	@Override
	public Student getStudentByFullname(String fullname) {
		return rStudent.getStudentByFullname(fullname);
	}

	@Override
	public void insertStudent(Student student) {
		rStudent.insertStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		rStudent.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		rStudent.deleteStudent(id);
	}

}

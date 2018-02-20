package com.carl.rdj.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.carl.rdj.model.Student;
import com.carl.rdj.session.AbstractSession;

@Repository
@Transactional
public class RStudentImpl extends AbstractSession implements RStudent{

	@Override
	public List<Student> getListStudents() {
		return getSession().createQuery("from Student where stu_status = 1").list();
	}

	@Override
	public Student getStudentById(int id) {
		return (Student)getSession().get(Student.class, id);
	}

	@Override
	public Student getStudentByFullname(String fullname) {
		return (Student)getSession().createQuery("from Student where stu_fullname = :fullname").setParameter("fullname", fullname).uniqueResult();
	}

	@Override
	public void insertStudent(Student student) {
		getSession().persist(student);
	}

	@Override
	public void updateStudent(Student student) {
		getSession().update(student);
	}

	@Override
	public void deleteStudent(int id) {
		Student s = getStudentById(id);
		if (s != null) {
			getSession().delete(s);;
		}
	}

}

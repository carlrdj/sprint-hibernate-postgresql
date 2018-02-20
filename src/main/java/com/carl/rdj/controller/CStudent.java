package com.carl.rdj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.carl.rdj.model.Student;
import com.carl.rdj.service.SStudent;

@Controller
@RequestMapping("/v1")
public class CStudent {
	@Autowired
	private SStudent sStudent; 
	
	@RequestMapping(value = "/getListStudents", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Student>> getListStudents(){
		List<Student> list = new ArrayList<>();
		list = sStudent.getListStudents();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStudentById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int id){
		Student student = sStudent.getStudentById(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStudentByFullname", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentByFullname(@RequestParam(value = "fullname") String fullname){
		Student student = sStudent.getStudentByFullname(fullname);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}	

	@RequestMapping(value = "/insertStudent", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> insertStudent(@RequestBody Student student, UriComponentsBuilder uriComponentsBuilder){		
		//Student student2 = sStudent.getStudentByFullname(student.getStu_fullname());
		sStudent.insertStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateStudent(@PathVariable(value = "id") int id, @RequestBody Student student){
		Student currentStudent = sStudent.getStudentById(id);
		currentStudent.setStu_fullname(student.getStu_fullname());
		currentStudent.setStu_date(student.getStu_date());
		sStudent.updateStudent(currentStudent);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteStudent(@PathParam(value = "id") int id){
		sStudent.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

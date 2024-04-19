package com.example.test.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.student.model.Student;
import com.example.test.student.service.StudentService;

@RestController
@RequestMapping(value = "/student")

public class StudentController {

	@Autowired
	private StudentService studentservice;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	// Save Data or Insert Data
	@PostMapping(value = "/saveStudentData")
	public ResponseEntity<Student> saveData(@RequestBody Student student) {
		Student saveStudentInfo = studentservice.saveInfo(student);
		return ResponseEntity.ok(saveStudentInfo);

	}

	// Update Data
	@PutMapping(value = "/updateStudentData")
	public ResponseEntity<Student> updateData(@RequestBody Student student) {
		Student updateInfo = studentservice.updateInfo(student);
		return ResponseEntity.ok(updateInfo);

	}

	// Get Data
	@GetMapping(value = "/getData")
	public ResponseEntity<List<Student>> getAllData() {
		List<Student> StudentInformation = studentservice.getStudentInfo();
		return ResponseEntity.ok(StudentInformation);

	}

	// Delete Data
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteInfo(@RequestBody Student student) {
		 studentservice.deletInfo(student);
		logger.info("Inside Student rest Controller");
		return ResponseEntity.ok("Student entry deleted successfully");

	}

}

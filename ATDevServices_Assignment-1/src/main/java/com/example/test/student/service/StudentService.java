package com.example.test.student.service;

import java.util.List;

import com.example.test.student.model.Student;

public interface StudentService {

	public Student saveInfo(Student student);

	public Student updateInfo(Student student);

	public List<Student> getStudentInfo();

	public Student deletInfo(Student student);

}

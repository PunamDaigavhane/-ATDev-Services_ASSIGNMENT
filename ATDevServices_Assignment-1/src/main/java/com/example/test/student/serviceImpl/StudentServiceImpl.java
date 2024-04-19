package com.example.test.student.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.student.controller.StudentController;
import com.example.test.student.model.Student;
import com.example.test.student.repositroy.StudentRepo;
import com.example.test.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentrepo;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Override
	public Student saveInfo(Student student) {
		Student save = studentrepo.save(student);
		return save;
	}

	@Override
	public Student updateInfo(Student student) {
		Student byId = studentrepo.findById(student.getId()).get();
		byId.setFirstName(student.getFirstName());
		byId.setLastName(student.getLastName());
		byId.setCity(student.getCity());
		Student updated = studentrepo.save(byId);
		return updated;
	}

	@Override
	public List<Student> getStudentInfo() {
		List<Student> findAll = studentrepo.findAll();
		return findAll;
	}

	@Override
	public Student deletInfo(Student student) {
		Student one = studentrepo.findById(student.getId()).get();
		logger.info("Inside Student ServicesImpl");
		studentrepo.delete(one);
		return student;
	}

}

package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Student;
import com.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	// private StudentRepository studentRepo = new StudentRepositoryImpl();
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public boolean enrolledStudent(Student student) {
		return studentRepo.addStudent(student);
	}

	@Override
	public void removeStudentById(int id) {
		studentRepo.deleteStudentById(id);
	}

	@Override
	public boolean modifyStudent(int existingID, Student updatedstudent) {

		return studentRepo.updateStudent(existingID, updatedstudent);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findStudentById(id);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.findAllStudents();
	}

}
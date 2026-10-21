package com.service;

import java.util.List;

import com.bean.Student;

public interface StudentService {

	boolean enrolledStudent(Student student);

	void removeStudentById(int id);

	boolean modifyStudent(int existingID, Student updatedstudent);

	Student getStudentById(int id);

	List<Student> getAllStudents();

}

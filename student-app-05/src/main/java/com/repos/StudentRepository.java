package com.repos;

import java.util.List;

import com.bean.Student;

public interface StudentRepository {
	boolean addStudent(Student student);

	void deleteStudentById(int id);

	boolean updateStudent(int existingID, Student updatedstudent);

	Student findStudentById(int id);

	List<Student> findAllStudents();
}
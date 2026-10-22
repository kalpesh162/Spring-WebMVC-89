package com.repos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addStudent(Student student) {
		String sql = "insert into student (name,marks)  values (?,?)";

		return jdbcTemplate.update(sql, student.getName(), student.getMarks()) > 0;
	}

	@Override
	public void deleteStudentById(int id) {
		String sql = "DELETE FROM student WHERE id = ?";

		int rows = jdbcTemplate.update(sql, id);

		if (rows == 0) {
			throw new RuntimeException("Student not found: " + id);
		}

	}

	@Override
	public boolean updateStudent(int existingID, Student updatedstudent) {
		String sql = "UPDATE student SET name = ?, marks = ? WHERE id = ?";

		int rows = jdbcTemplate.update(sql, updatedstudent.getName(), updatedstudent.getMarks(), existingID);

		return rows > 0;

	}

	@Override
	public Student findStudentById(int id) {
		String sql = "SELECT id, name, marks FROM student WHERE id = ?";

		Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		String sql = "SELECT id, name, marks FROM student";
		List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
		return students;
	}
}
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private StudentService service = null;

	@Autowired
	public void setStudentService(StudentService service) {
		this.service = service;
	}

	@RequestMapping(value = "/")
	public String openStudentForm() {
		System.out.println("openStudentform");
		return "studform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		System.out.println(student);
		service.enrolledStudent(student);

		return "redirect:/student/read";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String showAllStuents(Model model) {
		// all students
		List<Student> students = service.getAllStudents();
		model.addAttribute("students", students);
		return "display";
	}
	/*
	 * //http://localhost:8080/student-app-05/student/delete?id=1
	 * 
	 * @RequestMapping(value = "/delete", method = RequestMethod.GET) public String
	 * deleteRecord(@RequestParam("id") int id) { System.out.println("---> "+id);
	 * service.removeStudentById(id); return "redirect:/student/read";
	 * 
	 * }
	 */

	// http://localhost:8080/student-app-05/student/delete/5
	// @PathVariable
	// value = "/delete{id}"

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteRecord(@PathVariable("id") int id) {
		System.out.println("---> " + id);
		service.removeStudentById(id);
		return "redirect:/student/read";

	}

	@RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
	public String updateRecord(@PathVariable("id") int id, Model model) {

		System.out.println("Upadte form   ---->  " + id);

		Student student = service.getStudentById(id);
		System.out.println("update Student   ---> " + student);
		model.addAttribute("student", student);

		return "updateform";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateRecordFinal(@ModelAttribute("student") Student student) {

		System.out.println("--->"+student);
		
		service.modifyStudent(student.getId(), student);
		

		return "redirect:/student/read";

	}

}

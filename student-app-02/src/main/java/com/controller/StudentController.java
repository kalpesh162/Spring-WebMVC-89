package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openForm() {
		return "studform";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getStudentData(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("marks") double marks, Model model) {

		model.addAttribute("sid", id);
		model.addAttribute("sname", name);
		model.addAttribute("smarks", marks);
		return "display";
	}

}

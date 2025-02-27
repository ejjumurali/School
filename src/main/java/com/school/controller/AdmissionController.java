package com.school.controller;

import com.school.dto.StudentDTO;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdmissionController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public List<StudentDTO> getListPrograms() {
		return studentService.getStudentList();
	}
	@GetMapping("/student/{id}")
	public StudentDTO getStudent(@PathVariable("id") Long id) {
		return studentService.getStudent(id);
	}
}

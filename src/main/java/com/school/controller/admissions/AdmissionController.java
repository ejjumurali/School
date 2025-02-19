package com.school.controller.admissions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.enums.AdmissionTypes;

@RestController
@RequestMapping("/sadmission")
public class AdmissionController {

	@GetMapping("/list")
	public List<String> getListPrograms() {
		return Arrays.asList(AdmissionTypes.values()).stream().map(AdmissionTypes::getName)
				.collect(Collectors.toList());
	}
}

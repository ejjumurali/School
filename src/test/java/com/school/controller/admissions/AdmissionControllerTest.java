package com.school.controller.admissions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.school.enums.AdmissionTypes;

class AdmissionControllerTest {

	@Test
	void test() {
		List<String> admissions = Arrays.asList(AdmissionTypes.values()).stream().map(AdmissionTypes::getName)
				.collect(Collectors.toList());
		assertEquals(5, admissions.size());
	}

}

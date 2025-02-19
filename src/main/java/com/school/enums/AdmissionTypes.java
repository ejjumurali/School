package com.school.enums;

public enum AdmissionTypes {

	POLYTECHNIC("Polytechnic(Diploma)"),
	UG("UG"),
	PG("PG"),
	MCA("MCA"),
	PHD("PHD"),
	;

	private String name;

	AdmissionTypes(String name) {
		// TODO Auto-generated constructor stub
		this.name= name;
	}
	
	public String getName() {
		return name;
	}
}

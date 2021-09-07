package com.htu.Project.dtos;

public class DepartmentDto {
	private Integer departmentId;

	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public DepartmentDto(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public DepartmentDto() {
	}
//spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false
}

package com.htu.Project.models;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
@Entity(name="days_off")
public class DaysOff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String status;
	private Date dayDate;
	private String description;
	
	@OneToOne
	@JoinColumn(name="employee_id", referencedColumnName="id")
	private Employee employee;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDayDate() {
		return dayDate;
	}

	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public DaysOff(Integer id, String status, Date dayDate, String description) {
		super();
		this.id = id;
		this.status = status;
		this.dayDate = dayDate;
		this.description = description;
	}

	public DaysOff() {
	}
}

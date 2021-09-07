package com.htu.Project.models;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity(name="Attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@JsonDeserialize(using = SqlTimeDeserializer.class)
	private Time arrival;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@JsonDeserialize(using = SqlTimeDeserializer.class)
	private Time departure;
	
	private Date dayDate;
	
	@OneToOne
	@JoinColumn(name="employee_id", referencedColumnName="id")
	private Employee employee;
	
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
	
	public Time getArrival() {
		return arrival;
	}
	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}
	public Time getDeparture() {
		return departure;
	}
	public Date getDayDate() {
		return dayDate;
	}
	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	
	public Attendance(Integer id,Time arrival, Time departure, Date dayDate) {
		this.id=id;
		this.arrival = arrival;
		this.departure = departure;
		this.dayDate = dayDate;
	}
	
	public Attendance() {
	}
	
}
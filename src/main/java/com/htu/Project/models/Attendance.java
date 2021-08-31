package com.htu.Project.models;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Time arrival;
	private Time departure;
	private Date dayDate;
	
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
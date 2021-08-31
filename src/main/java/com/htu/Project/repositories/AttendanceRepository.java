package com.htu.Project.repositories;

import org.springframework.data.repository.CrudRepository;
import com.htu.Project.models.Attendance;

public interface AttendanceRepository extends CrudRepository <Attendance, Integer> {

}

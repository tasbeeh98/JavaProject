create table Attendance (id serial ,arrival time, departure time, day_date timestamp, employee_id integer,
	constraint fk_attendance_employee foreign key (employee_id) references Employee(id));
create table days_off (id serial ,description varchar,day_date timestamp, status varchar, employee_id integer,
	constraint fk_days_off_employee foreign key (employee_id) references Employee(id));
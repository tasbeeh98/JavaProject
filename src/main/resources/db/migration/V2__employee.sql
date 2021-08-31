create table Employee (id serial primary key, name varchar, phone_number varchar, email varchar, dep_id integer,
	constraint fk_department_employee foreign key (dep_id) references Department(id));
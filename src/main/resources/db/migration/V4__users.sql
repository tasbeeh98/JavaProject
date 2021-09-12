create table Users (id serial primary key,
					username varchar,
					passphrase varchar,
					constraint fk_user_employee foreign key (id) references Employee(id));
					);
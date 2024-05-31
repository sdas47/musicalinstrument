
create table if not exists CartItem (id int AUTO_INCREMENT  PRIMARY KEY, name varchar(255),
price numeric,instrument_id int);


create table if not exists Instrument (id int AUTO_INCREMENT  PRIMARY KEY, name varchar(255), seller varchar(255),
price numeric, location varchar(255), img varchar(255), description varchar(255));


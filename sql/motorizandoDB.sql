DROP TABLE IF EXISTS vehicle_booking;
DROP TABLE IF EXISTS maintenance;
DROP TABLE IF EXISTS service_order;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS vehicle_models;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS responsibility;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS contract;

CREATE TABLE brand (
	idbrand SERIAL,
	name VARCHAR(45) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,

	CONSTRAINT pk_idbrand PRIMARY KEY (idbrand)
);

CREATE TABLE category (
	idcategory SERIAL,
	category_name VARCHAR(45) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,

	CONSTRAINT pk_idcategory PRIMARY KEY (idcategory)
);

CREATE TABLE responsibility (
	idresponsibility SERIAL,
	sector VARCHAR(60) NOT NULL,
	hiring_date DATE CHECK(hiring_date >= NOW()) NOT NULL,
	firing_date DATE CHECK(firing_date > hiring_date),
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,

	CONSTRAINT pk_idresponsibility PRIMARY KEY (idresponsibility)
);


CREATE TABLE client (
	idclient SERIAL,
	name VARCHAR(150) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	phone VARCHAR(15) NOT NULL,
	birthday DATE NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL, 
	CNH_register VARCHAR(11) NOT NULL,
	CNH_mirror VARCHAR(10) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,

	CONSTRAINT pk_idclient PRIMARY KEY (idclient)
);

CREATE TABLE contract (
	idcontract SERIAL,
	contract_date DATE NOT NULL,
	contract_cancel_date DATE NOT NULL,
	penalty INT NOT NULL,
	payment_type VARCHAR(30) NOT NULL,
	contract_value DECIMAL(10,2) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,

	CONSTRAINT pk_idcontract PRIMARY KEY (idcontract)
);

CREATE TABLE vehicle_models (
	idvehicle_models SERIAL,
	model_name VARCHAR(45) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	brand_idbrand INT NOT NULL,

	CONSTRAINT pk_idvehicle_models PRIMARY KEY (idvehicle_models),
	CONSTRAINT fk_brand_idbrand FOREIGN KEY(brand_idbrand) REFERENCES brand
);


CREATE TABLE employees (
	idemployees SERIAL,
	name VARCHAR(150) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	phone VARCHAR(15) NOT NULL,
	birthday DATE NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	responsibility_idresponsibility INT NOT NULL,

	CONSTRAINT pk_idemployees PRIMARY KEY (idemployees),
	CONSTRAINT fk_responsibility_idresponsibility FOREIGN KEY(responsibility_idresponsibility) REFERENCES responsibility
);

CREATE TABLE vehicle (
	idvehicle SERIAL,
	manufaturing_year INT NOT NULL,
	transit_board VARCHAR(7) NOT NULL,
	chassis_id VARCHAR(17) NOT NULL,
	vehicle_power VARCHAR(10) NOT NULL,
	fuel_type VARCHAR(20) NOT NULL,
	responsibility_idresponsibility INT NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	vehicle_models_idvehicle_models INT NOT NULL,
	category_idcategory INT NOT NULL,

	CONSTRAINT pk_idvehicle PRIMARY KEY (idvehicle),
	CONSTRAINT fk_vehicle_models_idvehicle_models FOREIGN KEY(vehicle_models_idvehicle_models) REFERENCES vehicle_models,
	CONSTRAINT fk_category_idcategory FOREIGN KEY(category_idcategory) REFERENCES category
);


CREATE TABLE service_order (
	idservice_order SERIAL,
	description VARCHAR(150) NOT NULL,
	emission_date DATE NOT NULL,
	object_document VARCHAR(100) NOT NULL,
	unitary_value DECIMAL(10,2) NOT NULL,
	total_value DECIMAL(10,2) NOT NULL,
	equipment_purchased VARCHAR(200) NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	employees_idemployees INT NOT NULL,
	contract_idcontract INT NOT NULL,

	CONSTRAINT pk_idservice_order PRIMARY KEY (idservice_order),
	CONSTRAINT fk_employees_idemployees FOREIGN KEY(employees_idemployees) REFERENCES employees,
	CONSTRAINT fk_contract_idcontract FOREIGN KEY(contract_idcontract) REFERENCES contract
);

CREATE TABLE maintenance (
	idmaintenance SERIAL,
	maintenance_type VARCHAR(100) NOT NULL,
	changed_parts VARCHAR(100) NOT NULL,
	service_value DECIMAL(10,2) NOT NULL,
	isexternal BOOLEAN NOT NULL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	employees_idemployees INT,
	service_order_idservice_order INT NOT NULL,
	service_order_employees_employees_idemployees INT NOT NULL,
	vehicle_idvehicle INT NOT NULL,

	CONSTRAINT pk_idmaintenance PRIMARY KEY (idmaintenance),
	CONSTRAINT fk_employees_idemployees FOREIGN KEY(employees_idemployees) REFERENCES employees,
	CONSTRAINT fk_service_order_idservice_order FOREIGN KEY(service_order_idservice_order) REFERENCES service_order,
	CONSTRAINT fk_service_order_employees_employees_idemployees FOREIGN KEY(service_order_employees_employees_idemployees) REFERENCES service_order,
	CONSTRAINT fk_vehicle_idvehicle FOREIGN KEY(vehicle_idvehicle) REFERENCES vehicle
);


CREATE TABLE vehicle_booking (
	idvehicle_booking SERIAL,
	created_at DATE NOT NULL DEFAULT NOW(),
	updated_at DATE,
	deleted_at DATE,
	vehicle_idvehicle INT NOT NULL,
	client_idclient INT NOT NULL,
	contract_idcontract INT NOT NULL,

	CONSTRAINT pk_idvehicle_booking PRIMARY KEY (idvehicle_booking),
	CONSTRAINT fk_vehicle_idvehicle FOREIGN KEY(vehicle_idvehicle) REFERENCES vehicle,
	CONSTRAINT fk_client_idclient FOREIGN KEY(client_idclient) REFERENCES client,
	CONSTRAINT fk_contract_idcontract FOREIGN KEY(contract_idcontract) REFERENCES contract
);



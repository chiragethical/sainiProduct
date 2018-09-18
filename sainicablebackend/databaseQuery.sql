CREATE TABLE category(

	id int AUTO_INCREMENT,
	name VARCHAR(50),
	is_active BOOLEAN,
		
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);


CREATE TABLE product (
	id int AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id)
 	
);	
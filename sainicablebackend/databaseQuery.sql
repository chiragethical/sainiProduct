CREATE TABLE category(

	id int AUTO_INCREMENT,
	name VARCHAR(50),
	is_active BOOLEAN,
		
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);
INSERT INTO category (name,description,image_url,is_active ) VALUES('chirag','description of chirag','asd11.jpg',true);
INSERT INTO category (id, name, description)
VALUES
(1,'Electronics','Electronic devices'),
(2,'Books','All books');

INSERT INTO product (id, name, description, price, in_stock, created_at, category_id)
VALUES
(1,'Laptop','Gaming laptop',1500,true,CURRENT_TIMESTAMP,1),
(2,'Mouse','Wireless mouse',30,true,CURRENT_TIMESTAMP,1),
(3,'Keyboard','Mechanical keyboard',80,true,CURRENT_TIMESTAMP,1),
(4,'Spring Boot Book','Learn Spring Boot',45,true,CURRENT_TIMESTAMP,2),
(5,'Java Book','Advanced Java',50,true,CURRENT_TIMESTAMP,2);
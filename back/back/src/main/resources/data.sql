
/*INSERT INTO address (id, zip, city,flat_number,street) VALUES (1, 21000,'Novi Sad', '18','Djordja Rajkovica 15b');
INSERT INTO address (id, zip, city,flat_number,street) VALUES (2, 11000,'Beograd', '35','Bulevar Mihajla Pupina 18');
INSERT INTO address (id, zip, city,flat_number,street) VALUES (3, 32250,'Ivanjica', '','Druge proleterske brigade bb');
INSERT INTO address (id, zip, city,flat_number,street) VALUES (4, 32000,'Cacak', '15','Oslobodilacka 15');

INSERT INTO users (id, email, first_name, last_name, password,user_name, user_role,address_id)
              VALUES (1,'miroslav@maildrop.cc','Miroslav','Simic','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','miroslav','ADMIN',1);
INSERT INTO users (id, email, first_name, last_name, password,user_name, user_role,address_id)
              VALUES (2,'tamara@maildrop.cc','Tamara','Milosavljevic','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','tamara','USER',2);
INSERT INTO users (id, email, first_name, last_name, password,user_name, user_role,address_id)
              VALUES (3,'petar@maildrop.cc','Petar','Jovic','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','petar','USER',3);
*/
  
INSERT INTO users (id, email, first_name, last_name, password,user_name, user_role,address_id)
              VALUES (4,'andjelav@maildrop.cc','Andjela','Simic','andjelaandjela','andjela','ADMIN',1);
/*
INSERT INTO category(id,name) VALUES (1,'Buket');
INSERT INTO category(id,name) VALUES (2,'Aranzman');
INSERT INTO category(id,name) VALUES (3,'Groblje');
INSERT INTO category(id,name) VALUES (4,'Pojedinacno cvece');

INSERT INTO orders(id,contact,date,full_price,user_id) 
	VALUES (1,'0645629856','2022-5-5',5000,2);
INSERT INTO orders(id,contact,date,full_price,user_id) 
	VALUES (2,'0645644856','2022-5-15',2000,2);
INSERT INTO orders(id,contact,date,full_price,user_id) 
	VALUES (3,'0645628856','2022-5-20',2000,3);
	
INSERT INTO product(id,available,name,price,category_id)
	VALUES(1,1,'Buket sa ljiljanima',2000,1);
INSERT INTO product(id,available,name,price,category_id)
	VALUES(2,1,'Buket sa ruzama',3000,1);
INSERT INTO product(id,available,name,price,category_id)
	VALUES(3,1,'Aranzman poljsko cvece',3500,2);
INSERT INTO product(id,available,name,price,category_id)
	VALUES(4,0,'Suza',3500,3);
INSERT INTO product(id,available,name,price,category_id)
	VALUES(5,1,'Crvena ruza',250,4);
	
INSERT INTO order_item (id, quantity, order_id, product_id)
	VALUES (1,2,1,1);
INSERT INTO order_item(id, quantity, order_id, product_id)
	VALUES (2,1,2,2);
INSERT INTO order_item (id, quantity, order_id, product_id)
	VALUES (3,2,3,3);*/
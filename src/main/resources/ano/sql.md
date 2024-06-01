SELECT * FROM "dm8"."users" WHERE "username" IS "student1"


SELECT * FROM "dm8"."users" WHERE "username" = 'student1';

SELECT  id,user_name,password,email,phone,status,create_time  FROM user


insert into "dm8"."users" (username,password,email,phone,status,create_time, As "createTime") values 
("student2","student2password","student1@example.com","0987654322","1","2024-05-29")


INSERT INTO "dm8"."users" (username, password, email, phone, status, create_time)
VALUES ('student2', 'student2password', 'student1@example.com', '0987654322', '1', '2024-05-29');


INSERT INTO "dm8"."users" ("username", "password", "status", "create_time")
VALUES ('student3', 'student2password',  '1', '2024-05-29');

INSERT INTO "dm8"."users" 
VALUES ('student2', 'student2password', 'student1@example.com', '0987654322', '1', '2024-05-29');
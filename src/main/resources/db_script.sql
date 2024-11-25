# best practice: put drop in a file and create in another
-- in order for this type of comment to work, we need to leave one space after --
/* 
multi-line comment
ctrl enter to run the statement from the current line
*/

# 1. create user and grant privileges
-- DROP USER if exists "test"@"localhost";
-- CREATE USER "test"@"localhost" IDENTIFIED by "test";
-- grant all privileges on * . * to "test"@"localhost";

# 2. create a schema. requires ` (same key as ~)
-- CREATE SCHEMA `store`;
-- CREATE DATABASE `store`;
-- DROP SCHEMA `test`;

# 3. create table
-- drop table if exists store.product;
-- schema not needed if I double click its name on the left pannel
-- best practice to use `, even though you can without
-- drop table if exists `product`;

-- create table product(
-- `id` int,
-- `name` varchar(40),
-- `price` float,
-- `rating` float,
-- `outOfStock` boolean,
-- `numOfReviews` tinyint);

# 4. insert entries

-- insert into product (`id`, `name`, `price`, `rating`, `outOfStock`, `numOfReviews`) values (1, "Samsung TV QLED 7", 1100, 0, false, 0);
-- insert into product (`id`, `price`, `rating`, `outOfStock`) values (2, 1100, 0, false); -- by default, missing columns are null
-- insert into product (`id`, `name`, `price`, `rating`, `outOfStock`, `numOfReviews`) values (3, "Google Pixel Watch 3", 500, 4, true, 62);
-- insert into product (`id`, `name`, `price`, `rating`, `outOfStock`, `numOfReviews`) values (4, "Xiaomi MI 10T", 320, 3.2, false, 17);
-- insert into product (`id`, `name`, `price`, `rating`, `outOfStock`, `numOfReviews`) values (5, "TV preistoric", 20, 5, true, 120);

# 5. select 
# if you want regex: https://www.geeksforgeeks.org/mysql-regular-expressions-regexp/
# SELECT * FROM store.product;
 -- select count(*) FROM store.product where outOfStock is TRUE;
--  select id, name from product where rating > 3.5 and (name = "Pixel" or name like "%TV%");
--  select name from product where outofstock is not true and name not like "Google%3" order by rating asc;
--  select min(id) from product where price between 500 and 2000 and id in (3, 4, 1);

# 6. delete (or with truncate)
# DELETE from product; 
-- delete from product where name like "G___%" and id < 5 limit 2;

# 7. modify/update
# update product set name = "Xiaomi MI 10T Pro", numOfReviews = 10 where id = 4;

# 8. primary key

-- create table product(
-- `id` int auto_increment,
-- `name` varchar(40) not null,
-- `price` mediumint unsigned,
-- `rating` float default 0,
-- `outOfStock` boolean default false,
-- `numOfReviews` tinyint default 0,
-- PRIMARY KEY (`id`),
-- CHECK (rating <= 5 and rating >= 1));

-- insert into product (`name`, `price`) values ("Samsung TV QLED 7", 1100);
-- insert into product (`name`, `price`) values ("Pixel Watch 2", 200);

# 9. alter table
-- alter table product
-- 	add availableProducts bigint default 0,
--     drop column outOfStock,
--     modify column numOfReviews bigint unsigned default 0;

-- alter table product
-- 	add constraint `custom_constraint` check(...);

-- alter table product
-- 	drop primary key,
-- 	add primary key (id);
-- alter table product
-- 	drop primary key,
--     add primary key (id, name);

# 10. foreign key

-- create table orders (
-- `id` int auto_increment,
-- `productId` int ,
-- `orderTimestamp` bigint not null,
-- PRIMARY KEY (`id`),
-- FOREIGN KEY (`productId`) references product(`id`)
-- );

# i can't do the following:

-- drop table product;

-- alter table product
-- drop primary key;

-- insert into product (`name`, `price`, `rating`) values ("Samsung TV QLED 7", 500, 2);
-- insert into orders (`productId`, `orderTimestamp`) values (1, 19284127412);
# I can not remove product 1 unless I remove order 1

# 11. JOINS

-- drop table `enrollments`;
-- drop table `courses`;
-- drop table `students`;

-- create table `courses` (
-- `id` int auto_increment,
-- `name` varchar(50),
-- primary key (`id`));

-- create table `students` (
-- `id` int auto_increment,
-- `name` varchar(50),
-- `age` int,
-- primary key (`id`));

-- create table `enrollments` (
-- `student_id` int,
-- `course_id` int,
-- primary key (`student_id`, `course_id`),
-- foreign key (`student_id`) references students(`id`),
-- foreign key (`course_id`) references courses(`id`));

-- insert into courses (name) values ("Math");
-- insert into courses (name) values ("Programming");
-- insert into courses (name) values ("German language");

-- insert into students (name, age) values ("Maria", 30);
-- insert into students (name, age) values ("Paul", 25);
-- insert into students (name, age) values ("Gigi", 52);

-- insert into enrollments (student_id, course_id) values (1, 1);
-- insert into enrollments (student_id, course_id) values (1, 2);
-- insert into enrollments (student_id, course_id) values (2, 3);

# inner join
-- select students.name from students
-- inner join enrollments on students.id = enrollments.student_id
-- inner join courses on courses.id = enrollments.course_id
-- where courses.name = "Programming";

-- select distinct(students.name) from students
-- inner join enrollments on students.id = enrollments.student_id
-- inner join courses on courses.id = enrollments.course_id;

-- # left join
-- select students.name, courses.name from students
-- left join enrollments on students.id = enrollments.student_id
-- left join courses on courses.id = enrollments.course_id;


-- # right join
-- select students.name, courses.name from students
-- right join enrollments on students.id = enrollments.student_id
-- right join courses on courses.id = enrollments.course_id;


-- insert into courses (name) values ("German language");
-- insert into courses (name) values ("German language");
-- select count(*), courses.name from courses group by name;
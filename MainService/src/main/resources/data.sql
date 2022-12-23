insert into address (id, street, city, postal_code, state_province, country_region) values (1, '4th street', 'fairfield', '12345', 'Iowa', 'USA')
insert into address (id, street, city, postal_code, state_province, country_region) values (2, '4th street', 'fairfield', '12345', 'Iowa', 'USA')
insert into address (id, street, city, postal_code, state_province, country_region) values (3, '4th street', 'fairfield', '12345', 'Iowa', 'USA')


insert into registration_event (id, end_date, start_date) values (19,'2022-12-22 10:00:00','2022-12-10 12:30:00' )
insert into registration_event (id, end_date, start_date) values (241,'2022-12-23 16:43:00','2022-12-12 16:42:00' )
insert into registration_event (id, end_date, start_date) values (4,'2021-12-22 10:00:00','2021-12-10 17:30:00' )


insert into person ( id, last_name, email,first_name, password) values ( 5, 'Jean','abdel@gmail.con','Roody', '12345')
insert into person ( id, last_name, email,first_name, password) values ( 6, 'Emma','emma@gmail.con','Tippoh', '12345')
insert into person ( id, last_name, email,first_name, password) values ( 7, 'Papy','papy@gmail.con','kabeya', '12345')

insert into person ( id, last_name, email,first_name, password) values ( 14, 'Coolio','coolio@gmail.con','Malik', '12345')

insert into registration_group (id, registration_groups_id) values (8, 4)
insert into registration_group (id, registration_groups_id) values (9, 4)
insert into registration_group (id, registration_groups_id) values (10, 4)

insert into student (studentid, id, home_address_id, mailing_address_id) values (12763, 5, 1, 1 )
insert into student (studentid, id, home_address_id, mailing_address_id) values (12783, 6, 2, 2)
insert into student (studentid, id, home_address_id, mailing_address_id) values (12923, 7, 3, 3)

insert into academic_block (id, code, end_date, name, semester, start_date, academic_block_list_id) values (11,'2022-13A-12D',  '2023-12-15','1December 2022', 'Summer','2022-10-15', 8)
insert into academic_block (id, code, end_date, name, semester, start_date, academic_block_list_id) values (12,'2022-14A-12D',  '2023-12-15','2December 2022', 'Summer','2022-10-15', 9)
insert into academic_block (id, code, end_date, name, semester, start_date, academic_block_list_id) values (13,'2022-15A-12D',  '2023-12-15','3December 2022','Summer', '2022-10-15', 10)

insert into faculty (faculty_id, id, title) values(14, 14, 'professor')

insert into course(id, code, description, name ) values(17, 'CS544','Spring boot', 'Web Programming' )
insert into course_offering(id, available_seats, capacity, course_code, initials, number_of_registered_students, faculty_id, course_id, academic_block_id) values(16, 5, 25, 'CS544-2022-12A-12D-PS', 'PS', 20, 14, 17,11)

insert into registration_request (id, priority) values(20, 1)

insert into student_registration_request_list(student_id, registration_request_list_id) values(5, 20)

insert into course_offering_registration_request_list(course_offering_id, registration_request_list_id) values(16, 20 )

insert into registration_group_students(registration_group_id, students_id) values(8, 5)
insert into registration_group_students(registration_group_id, students_id) values(8, 6)

insert into registration(id, course_offering_id, student_id) values(22, 16, 5)
insert into registration_group(id, registration_groups_id) values(23, 4)
insert into registration_group_students(registration_group_id, students_id) values(23, 5)

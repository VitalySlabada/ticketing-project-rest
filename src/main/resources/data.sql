INSERT INTO roles(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, description)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Admin'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Manager'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Employee');


insert into users(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, enabled,
                  first_name, gender, last_name, user_name, role_id, pass_word)
values ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, true, 'ozzy', 'MALE', 'can', 'ozzy',
        2, '$2a$10$Q7ilQ6Hv11qpU0T7xfMzMeqxoPXkvhTVXxFqg0UL2xvLnhNqB7vba'),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, true, 'admin', 'MALE', 'admin', 'cydeo',
        1, '$2a$10$Q7ilQ6Hv11qpU0T7xfMzMeqxoPXkvhTVXxFqg0UL2xvLnhNqB7vba');

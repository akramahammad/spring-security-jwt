insert into user (id,name,password) values(1,'Akram','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6');
insert into role(id,name) values (1,'ROLE_admin');
insert into user_role (user_id,role_id) values (1,1);
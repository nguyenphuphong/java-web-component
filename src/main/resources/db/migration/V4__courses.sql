CREATE SEQUENCE sq_courses;

CREATE TABLE tb_courses (
    id INT NOT NULL DEFAULT sq_courses.nextval PRIMARY KEY,
    title varchar(255), 
    description varchar(2000),
    link_id INT
);

INSERT INTO tb_user_roles VALUES (1, 1);

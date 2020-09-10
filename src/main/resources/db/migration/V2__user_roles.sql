CREATE SEQUENCE sq_users;

CREATE TABLE tb_users (
    id INT NOT NULL DEFAULT sq_users.nextval PRIMARY KEY,
    email VARCHAR(255), password VARCHAR(255)
);

CREATE TABLE tb_roles (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE tb_user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL
);

INSERT INTO tb_users (email, password) VALUES ('nguyenphuphong@gmail.com', '112233');

INSERT INTO tb_roles VALUES (1, 'student');
INSERT INTO tb_roles VALUES (2, 'teacher');
INSERT INTO tb_roles VALUES (3, 'warden');
INSERT INTO tb_roles VALUES (4, 'principal');
INSERT INTO tb_roles VALUES (5, 'administrator');

INSERT INTO tb_user_roles VALUES (1, 5);

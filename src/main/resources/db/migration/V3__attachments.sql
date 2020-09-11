CREATE SEQUENCE sq_attachments;

CREATE TABLE tb_attachments (
    id INT NOT NULL DEFAULT sq_attachments.nextval PRIMARY KEY,
    new_id INT NOT NULL, path varchar(255)
);

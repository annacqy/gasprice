CREATE SEQUENCE department_id_seq START WITH 1;

CREATE TABLE department (
    id                INTEGER NOT NULL default nextval('department_id_seq'),
    name              VARCHAR(30) not null unique,
    description       VARCHAR(150),
    location          VARCHAR(100)
);

ALTER TABLE department ADD CONSTRAINT department_pk PRIMARY KEY ( id );
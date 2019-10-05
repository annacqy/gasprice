CREATE SEQUENCE employee_id_seq START WITH 1;

CREATE TABLE employee (
    id              INTEGER NOT NULL default nextval('employee_id_seq'),
    name            VARCHAR(30) not null unique,
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    address         VARCHAR(150),
    department_id   INTEGER
);

ALTER TABLE employee ADD CONSTRAINT employee_pk PRIMARY KEY ( id );

ALTER TABLE employee
    ADD CONSTRAINT employee_department_fk FOREIGN KEY ( department_id )
        REFERENCES department ( id );


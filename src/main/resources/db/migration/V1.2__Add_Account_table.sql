CREATE SEQUENCE account_id_seq START WITH 1;

CREATE TABLE account (
    id             INTEGER NOT NULL default nextval('account_id_seq'),
    account_type   VARCHAR(30),
    balance        NUMERIC(10, 2),
    employee_id    INTEGER NOT NULL
);

ALTER TABLE account ADD CONSTRAINT account_pk PRIMARY KEY ( id );

ALTER TABLE account
    ADD CONSTRAINT account_employee_fk FOREIGN KEY ( employee_id )
        REFERENCES employee ( id );

CREATE TABLE motherboard (
    id          SERIAL          NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    cost        DOUBLE          NOT NULL,
    url         TEXT            NOT NULL,
    socket      VARCHAR(255)    NOT NULL,
    size_form   VARCHAR(255)    NOT NULL,
    CONSTRAINT motherboard_pk PRIMARY KEY (id)
);

CREATE TABLE user (
    id          SERIAL          NOT NULL,
    email       VARCHAR(255)    NOT NULL,
    password    VARCHAR(255)    NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE role (
    id SERIAL NOT NULL,
    id_user BIGINT REFERENCES user (id) ON UPDATE CASCADE ON DELETE CASCADE,
    status varchar(255) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

CREATE TABLE processor (
    id          SERIAL          NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    cost        DOUBLE          NOT NULL,
    url         TEXT            NOT NULL,
    core        INT             NOT NULL,
    socket      VARCHAR(255)    NOT NULL,
    CONSTRAINT processor_pk PRIMARY KEY (id)
);

CREATE TABLE ram (
    id              SERIAL          NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    cost            DOUBLE          NOT NULL,
    url             TEXT            NOT NULL,
    frequency       VARCHAR(255)    NOT NULL,
    type            VARCHAR(255)    NOT NULL,
    memory          VARCHAR(255)    NOT NULL,
    CONSTRAINT ram_pk PRIMARY KEY (id)
);

CREATE TABLE power_supply (
    id       SERIAL          NOT NULL,
    name     VARCHAR(255)    NOT NULL,
    cost     DOUBLE          NOT NULL,
    url      TEXT            NOT NULL,
    power    VARCHAR(255)    NOT NULL,
    CONSTRAINT power_supply_pk PRIMARY KEY (id)
);

CREATE TABLE rom (
    id          SERIAL          NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    cost        DOUBLE          NOT NULL,
    url         TEXT            NOT NULL,
    type        VARCHAR(255)    NOT NULL,
    memory      VARCHAR(255)    NOT NULL,
    CONSTRAINT rom_pk PRIMARY KEY (id)
);

CREATE TABLE videocard (
    id          SERIAL          NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    cost        DOUBLE          NOT NULL,
    url         TEXT            NOT NULL,
    memory      VARCHAR(255)    NOT NULL,
    frequency   VARCHAR(255)    NOT NULL,
    CONSTRAINT motherboard_pk PRIMARY KEY (id)
);

CREATE TABLE hibernate_sequence (
    next_val BIGINT DEFAULT NULL
);
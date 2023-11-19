CREATE TABLE residentials
(
    id   SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE state_apartment
(
    id   SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(64)
);

CREATE TABLE apartments
(
    id                  BIGSERIAL NOT NULL PRIMARY KEY,
    number_of_apartment VARCHAR(32),
    residential         INT REFERENCES residentials (id),
    floor               VARCHAR(16),
    flat                VARCHAR(16),
    created_date        DATE,
    status_apartment    INT REFERENCES state_apartment (id),
    price               VARCHAR(64),
    client              VARCHAR(255),
    updated_status      VARCHAR(255)
);

CREATE TABLE contract_of_apartments
(
    id                 BIGSERIAL NOT NULL PRIMARY KEY,
    apartment_id       BIGINT REFERENCES apartments (id),
    number_of_contract VARCHAR(255)
);

CREATE TABLE roles
(
    id   SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(32)
);

CREATE TABLE users
(
    id           BIGSERIAL NOT NULL PRIMARY KEY,
    password     VARCHAR(255),
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    patronymic   VARCHAR(255),
    phone        VARCHAR(255),
    mail         VARCHAR(255),
    created_date DATE,
    role         INT REFERENCES roles (id)
);

CREATE TABLE managers
(
    id             BIGSERIAL NOT NULL PRIMARY KEY,
    user_id        BIGINT    NOT NULL REFERENCES users (id),
    count_of_deals INT
);
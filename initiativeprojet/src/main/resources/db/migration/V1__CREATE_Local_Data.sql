CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR (255),
    email VARCHAR(255),
    password VARCHAR(255),
    age INTEGER,
    role VARCHAR
);
CREATE TABLE parrain(
    id BIGINT
);
CREATE TABLE admin(
    id BIGINT
);
CREATE TABLE porteur(
    id BIGINT
);
CREATE TABLE projet(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255)
);
CREATE TABLE message(
    id SERIAL PRIMARY KEY
);
CREATE TABLE rendezvous(
    id SERIAL PRIMARY KEY,
    date TIMESTAMP
);
CREATE TABLE documents(
    id SERIAL PRIMARY KEY
);
CREATE TABLE role(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE users_roles(
     user_id BIGINT,
     role_id INT
);



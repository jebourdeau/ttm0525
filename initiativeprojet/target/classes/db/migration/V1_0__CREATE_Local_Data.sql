CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR (255),
    email VARCHAR(255),
    password VARCHAR(255),
    age INTEGER,
    role VARCHAR
);
CREATE TABLE parrain(
    id BIGINT,
    user_id BIGINT,
    entreprise TEXT
);
CREATE TABLE admin(
    id BIGINT,
    user_id BIGINT
);
CREATE TABLE porteur(
    id BIGINT,
    user_id BIGINT,
    parrain_id BIGINT
);
CREATE TABLE projet(
    id SERIAL PRIMARY KEY,
    porteur_id BIGINT,
    parrain_id BIGINT,
    user_id BIGINT,
    title VARCHAR(255),
    description VARCHAR(255)
);
CREATE TABLE message(
    id SERIAL PRIMARY KEY
);
CREATE TABLE rendezvous(
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    details TEXT,
    date TIMESTAMP,
    time TIMESTAMP
);
CREATE TABLE documents(
    id SERIAL PRIMARY KEY
);
CREATE TABLE role(
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    name VARCHAR(255)
);
CREATE TABLE users_roles(
     user_id BIGINT,
     role_id INT
);



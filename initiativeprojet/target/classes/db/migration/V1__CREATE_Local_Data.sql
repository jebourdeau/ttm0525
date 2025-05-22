CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR (255),
    email VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE parrain(
    entreprise VARCHAR(255),
    user_id BIGINT
);
CREATE TABLE Admins(
    user_id BIGINT
);
CREATE TABLE porteur(
    user_id BIGINT
);
CREATE TABLE projet(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255)
);
CREATE TABLE message(
    id SERIAL PRIMARY KEY
);
CREATE TABLE admin(
    User_id BIGINT
);
CREATE TABLE rendezvous(
    id SERIAL PRIMARY KEY,
    date TIMESTAMP
);
CREATE TABLE documents(
    id SERIAL PRIMARY KEY
);


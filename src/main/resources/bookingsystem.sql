CREATE DATABASE bookingsystem;

CREATE TABLE users (
    user_id serial PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20),  
    address VARCHAR(255),
    credit NUMERIC
);

CREATE TABLE country (
    country_id serial PRIMARY KEY,
    country_name VARCHAR(255)
);

CREATE TABLE package (
    package_id serial PRIMARY KEY,
    credit NUMERIC,
    price NUMERIC,
    is_available BOOLEAN DEFAULT TRUE,
    available_country_id,
    expired_date DATE
);

ALTER TABLE package ADD CONSTRAINT fk_country_id FOREIGN KEY (available_country_id) REFERENCES country (country_id );

-- Insert Users
INSERT INTO users (username, email, phone_number, address, credit)
VALUES ('JohnDoe', 'john.doe@example.com', '555-123-4567', '123 Main St, City, State 12345', 1000);
INSERT INTO users (username, email, phone_number, address, credit)
VALUES ('AliceSmith', 'alice.smith@example.com', '555-987-6543', '456 Elm St, Another City, State 54321', 750);
INSERT INTO users (username, email, phone_number, address, credit)
VALUES ('BobJohnson', 'bob.johnson@example.com', '555-555-5555', '789 Oak St, Third City, State 98765', 2000);
INSERT INTO users (username, email, phone_number, address, credit)
VALUES ('EllaBrown', 'ella.brown@example.com', '555-111-2222', '321 Birch St, Fourth City, State 11111', 300);
INSERT INTO users (username, email, phone_number, address, credit)
VALUES ('DavidLee', 'david.lee@example.com', '555-888-9999', '654 Pine St, Fifth City, State 88888', 150);

-- Insert Countries
INSERT INTO country (country_name)
VALUES ('Singapore');
INSERT INTO country (country_name)
VALUES ('Myanmar');
INSERT INTO country (country_name)
VALUES ('United Kingdom');
INSERT INTO country (country_name)
VALUES ('Australia');
INSERT INTO country (country_name)
VALUES ('Germany');

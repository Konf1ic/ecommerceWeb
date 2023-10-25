create database ecommerce;
use ecommerce;
CREATE TABLE account_supplier (
  username varchar(100) NOT NULL,
  password int DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  age int DEFAULT NULL,
  phone_number int DEFAULT NULL,
  address varchar(220) DEFAULT NULL,
  PRIMARY KEY (username));

 CREATE TABLE account_staff (
  username varchar(100) NOT NULL,
  password int DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  age int DEFAULT NULL,
  phone_number int DEFAULT NULL,
  address varchar(220) DEFAULT NULL,
  PRIMARY KEY (username));

CREATE TABLE account_buyer (
  username varchar(100) NOT NULL,
  password int DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  age int DEFAULT NULL,
  phone_number int DEFAULT NULL,
  address varchar(220) DEFAULT NULL,
  PRIMARY KEY (username))


CREATE DATABASE demo_db;

--Create table contacts
CREATE TABLE IF NOT EXISTS contacts
( id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

ТЕСТ ПРОЕКТУ

В Web-браузері запускаємо

http://localhost:8080/Spring-Web-MVC-Contact-1.0-SNAPSHOT/contacts

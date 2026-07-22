-- Create Database
CREATE DATABASE covid_db;

-- Select Database
USE covid_db;

-- Create covid_cases Table
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    population BIGINT
);

-- Create covid_deaths Table
CREATE TABLE covid_deaths (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50),
    report_date DATE,
    total_deaths INT,
    death_rate DECIMAL(5,2)
);

-- Create covid_vaccines Table
CREATE TABLE covid_vaccines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50),
    report_date DATE,
    total_vaccinated INT,
    vaccine_name VARCHAR(100)
);

-- Display All Tables
SHOW TABLES;

-- Display Table Structure
DESC covid_cases;
DESC covid_deaths;
DESC covid_vaccines;

-- Insert Data into covid_cases Table

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('India','2024-01-01',45000000,530000,44400000,1400000000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('India','2024-01-02',45002000,530010,44401000,1400000000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('USA','2024-01-01',103000000,1120000,101000000,331000000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('USA','2024-01-02',103003000,1120010,101002000,331000000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('UK','2024-01-01',25000000,230000,24700000,67000000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('UK','2024-01-02',25005000,230010,24703000,67000000);

-- Display Records
SELECT * FROM covid_cases;

-- Insert Data into covid_deaths Table

INSERT INTO covid_deaths
(country, report_date, total_deaths, death_rate)
VALUES
('India','2024-01-01',530000,1.18),
('USA','2024-01-01',1120000,1.09),
('UK','2024-01-01',230000,0.92);

SELECT * FROM covid_deaths;

-- Insert Data into covid_vaccines Table

INSERT INTO covid_vaccines
(country, report_date, total_vaccinated, vaccine_name)
VALUES
('India','2024-01-01',980000000,'Covishield'),
('USA','2024-01-01',250000000,'Pfizer'),
('UK','2024-01-01',55000000,'AstraZeneca');

SELECT * FROM covid_vaccines;

-- Update Confirmed Cases for India

UPDATE covid_cases
SET confirmed_cases = 45005000
WHERE country='India'
AND report_date='2024-01-02';

SELECT * FROM covid_cases
WHERE country='India';

-- Insert Wrong Record

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('IN','2024-01-03',45007000,530050,44405000,1400000000);

SELECT * FROM covid_cases;

-- Delete Wrong Record

DELETE FROM covid_cases
WHERE country='IN';

SELECT * FROM covid_cases;

-- Insert Duplicate Record

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES
('India','2024-01-01',45000000,530000,44400000,1400000000);

SELECT * FROM covid_cases;

-- Delete Duplicate Record

DELETE FROM covid_cases
WHERE id =
(
SELECT id
FROM
(
SELECT MAX(id) AS id
FROM covid_cases
WHERE country='India'
AND report_date='2024-01-01'
) AS temp
);

SELECT * FROM covid_cases;

-- Add Vaccination Rate Column

ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);

DESC covid_cases;

-- Update Vaccination Rate

UPDATE covid_cases
SET vaccination_rate = 72.50
WHERE country='India';

UPDATE covid_cases
SET vaccination_rate = 76.80
WHERE country='USA';

UPDATE covid_cases
SET vaccination_rate = 81.30
WHERE country='UK';

-- Display Final Data

SELECT * FROM covid_cases;
SELECT * FROM covid_deaths;
SELECT * FROM covid_vaccines;

-- Drop Tables (Optional)

-- DROP TABLE covid_cases;
-- DROP TABLE covid_deaths;
-- DROP TABLE covid_vaccines;

-- Drop Database (Optional)

-- DROP DATABASE covid_db;
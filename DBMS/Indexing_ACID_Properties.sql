-- Create Database
CREATE DATABASE covid_db;

-- Select Database
USE covid_db;

-- Create COVID Cases Table
CREATE TABLE covid_cases (
    country VARCHAR(50),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    population BIGINT,
    infection_rate DECIMAL(10,2)
);

-- Insert Sample Data
INSERT INTO covid_cases VALUES
('India','2024-01-01',45000000,530000,44400000,1400000000,3.21),
('USA','2024-01-01',103000000,1120000,101000000,331000000,31.12),
('UK','2024-01-01',25000000,230000,24700000,67000000,37.31),
('Canada','2024-01-01',5000000,50000,4900000,38000000,13.15);

--------------------------------------------------
-- Use Case 26
-- Create Indexes
--------------------------------------------------

-- Composite Index
CREATE INDEX idx_country_date
ON covid_cases(country, report_date);

-- Single Column Index
CREATE INDEX idx_date
ON covid_cases(report_date);

-- Display Indexes
SHOW INDEX FROM covid_cases;

--------------------------------------------------
-- Use Case 27
-- Create Covering Index
--------------------------------------------------

CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate);

-- Top 10 Countries by Infection Rate
SELECT
country,
infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;

--------------------------------------------------
-- Use Case 28
-- Analyze Query Execution Plan
--------------------------------------------------

-- Create Countries Table
CREATE TABLE countries (
    country VARCHAR(50) PRIMARY KEY,
    continent VARCHAR(50)
);

INSERT INTO countries VALUES
('India','Asia'),
('USA','North America'),
('UK','Europe'),
('Canada','North America');

-- Analyze Query
EXPLAIN
SELECT
c.country,
co.continent,
c.confirmed_cases
FROM covid_cases c
INNER JOIN countries co
ON c.country = co.country
WHERE c.report_date = '2024-01-01';

--------------------------------------------------
-- Use Case 29
-- ACID Transaction
--------------------------------------------------

-- Create Vaccine Table
CREATE TABLE covid_vaccines (
    country VARCHAR(50),
    report_date DATE,
    vaccine_name VARCHAR(50),
    doses_given INT
);

-- Start Transaction
START TRANSACTION;

INSERT INTO covid_vaccines
VALUES
('India','2024-01-01','Covishield',1000000);

INSERT INTO covid_vaccines
VALUES
('USA','2024-01-01','Pfizer',800000);

-- Save Changes
COMMIT;

-- Rollback Example

START TRANSACTION;

INSERT INTO covid_vaccines
VALUES
('UK','2024-01-01','AstraZeneca',500000);

-- Cancel Changes
ROLLBACK;

-- Display Vaccine Data
SELECT * FROM covid_vaccines;

--------------------------------------------------
-- Use Case 30
-- Isolation Levels
--------------------------------------------------

-- View Current Isolation Level
SELECT @@transaction_isolation;

-- Read Uncommitted
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

START TRANSACTION;

SELECT * FROM covid_cases;

COMMIT;

-- Read Committed
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;

START TRANSACTION;

SELECT * FROM covid_cases;

COMMIT;

-- Repeatable Read
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

START TRANSACTION;

SELECT * FROM covid_cases;

COMMIT;

-- Serializable
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

START TRANSACTION;

SELECT * FROM covid_cases;

COMMIT;
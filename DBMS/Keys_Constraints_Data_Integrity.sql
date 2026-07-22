-- Create Database
CREATE DATABASE covid_db;

-- Select Database
USE covid_db;

-- Create Countries Table
CREATE TABLE countries (
    country VARCHAR(50) PRIMARY KEY,
    population BIGINT,
    continent VARCHAR(50)
);

-- Insert Countries
INSERT INTO countries VALUES
('India',1400000000,'Asia'),
('USA',331000000,'North America'),
('UK',67000000,'Europe');

-- Create covid_cases Table
CREATE TABLE covid_cases (
    country VARCHAR(50) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    recoveries INT DEFAULT 0,
    deaths INT,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Composite Primary Key
    PRIMARY KEY(country, report_date),

    -- Foreign Key
    FOREIGN KEY(country) REFERENCES countries(country),

    -- Check Constraint
    CHECK(deaths <= confirmed_cases),

    -- Unique Constraint
    UNIQUE(country, report_date)
);

-- Display Table Structure
DESC covid_cases;

-- Display Countries Table
SELECT * FROM countries;

-- Insert Valid Records
INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('India','2024-01-01',45000000,44400000,530000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('USA','2024-01-01',103000000,101000000,1120000);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('UK','2024-01-01',25000000,24700000,230000);

-- Display Records
SELECT * FROM covid_cases;

-- Test Default Value (Recoveries = 0)
INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths)
VALUES
('India','2024-01-02',45005000,530500);

SELECT * FROM covid_cases;

-- Test Foreign Key (This Will Fail)
INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('Japan','2024-01-01',500000,490000,1000);

-- Test Check Constraint (This Will Fail)
INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('USA','2024-01-02',1000,900,1500);

-- Test Duplicate Record (This Will Fail)
INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths)
VALUES
('India','2024-01-01',45000000,44400000,530000);

-- Display Final Records
SELECT * FROM covid_cases;

-- Display Table Structure
DESC covid_cases;

-- Optional Commands

-- Drop covid_cases Table
-- DROP TABLE covid_cases;

-- Drop countries Table
-- DROP TABLE countries;

-- Drop Database
-- DROP DATABASE covid_db;
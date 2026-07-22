-- Create Database
CREATE DATABASE covid_db;

-- Select Database
USE covid_db;

-- Create Countries Table
CREATE TABLE countries (
    country VARCHAR(50) PRIMARY KEY,
    population BIGINT
);

-- Insert Data into Countries Table
INSERT INTO countries VALUES
('India',1400000000),
('USA',331000000),
('UK',67000000),
('Mumbai',20000000);

-- Create COVID Cases Table
CREATE TABLE covid_cases (
    country VARCHAR(50),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    vaccinated INT,
    population BIGINT,
    PRIMARY KEY(country, report_date)
);

-- Insert Data into COVID Cases Table
INSERT INTO covid_cases VALUES
('India','2024-01-01',45000000,530000,44400000,980000000,1400000000),
('India','2024-01-02',45100000,531000,44500000,981000000,1400000000),

('USA','2024-01-01',103000000,1120000,101000000,250000000,331000000),
('USA','2024-01-02',103500000,1121000,101300000,251000000,331000000),

('UK','2024-01-01',25000000,230000,24700000,55000000,67000000),
('UK','2024-01-02',25100000,230500,24800000,55500000,67000000),

('Mumbai','2024-01-01',5000,100,4800,15000000,20000000),
('Mumbai','2024-01-02',7000,120,6800,15100000,20000000),
('Mumbai','2024-01-03',6000,110,5900,15200000,20000000);

-- Create COVID Deaths Table
CREATE TABLE covid_deaths (
    country VARCHAR(50),
    report_date DATE,
    total_deaths INT
);

-- Insert Data into COVID Deaths Table
INSERT INTO covid_deaths VALUES
('India','2024-01-01',530000),
('USA','2024-01-01',1120000),
('UK','2024-01-01',230000),
('Canada','2024-01-01',40000);

--------------------------------------------------
-- Use Case 16
-- Find Countries with Above-Average Death Counts
--------------------------------------------------

SELECT country, deaths
FROM covid_cases
WHERE deaths >
(
    SELECT AVG(deaths)
    FROM covid_cases
);

-- Use Case 17
-- Find Countries Exceeding 1 Million Cases

SELECT DISTINCT country
FROM covid_cases
WHERE country IN
(
    SELECT country
    FROM covid_cases
    WHERE confirmed_cases > 1000000
);

--------------------------------------------------
-- Use Case 18
-- Track COVID Waves for Mumbai
--------------------------------------------------

SELECT
    c1.report_date,
    c1.confirmed_cases
FROM covid_cases c1
WHERE c1.country = 'Mumbai'
AND c1.confirmed_cases =
(
    SELECT MAX(c2.confirmed_cases)
    FROM covid_cases c2
    WHERE c2.country = c1.country
);

--------------------------------------------------
-- Use Case 19
-- Compare Vaccinated and Unvaccinated Population
--------------------------------------------------

SELECT
    country,
    vaccinated AS people_count,
    'Vaccinated' AS status
FROM covid_cases

UNION

SELECT
    country,
    (population - vaccinated) AS people_count,
    'Unvaccinated' AS status
FROM covid_cases;

--------------------------------------------------
-- Use Case 20
-- Countries Present in Deaths but Not Cases
--------------------------------------------------

SELECT country
FROM covid_deaths
WHERE country NOT IN
(
    SELECT country
    FROM covid_cases
);


-- Display Tables


SELECT * FROM countries;

SELECT * FROM covid_cases;

SELECT * FROM covid_deaths;
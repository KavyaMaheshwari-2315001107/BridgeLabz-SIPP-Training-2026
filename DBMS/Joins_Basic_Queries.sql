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

-- Insert Data into Countries Table
INSERT INTO countries VALUES
('India',1400000000,'Asia'),
('USA',331000000,'North America'),
('UK',67000000,'Europe');

-- Create COVID Cases Table
CREATE TABLE covid_cases (
    country VARCHAR(50),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,

    PRIMARY KEY(country, report_date),
    FOREIGN KEY(country) REFERENCES countries(country)
);

-- Insert Data into COVID Cases Table
INSERT INTO covid_cases VALUES
('India','2024-01-01',45000000,530000,44400000),
('USA','2024-01-01',103000000,1120000,101000000),
('UK','2024-01-01',25000000,230000,24700000),
('India','2024-01-02',45050000,530500,44450000),
('USA','2024-01-02',103300000,1121000,101200000),
('UK','2024-01-02',25050000,230500,24750000);

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
('UK','2024-01-01',230000);

-- Create COVID Vaccines Table
CREATE TABLE covid_vaccines (
    country VARCHAR(50),
    report_date DATE,
    vaccinated INT
);

-- Insert Data into COVID Vaccines Table
INSERT INTO covid_vaccines VALUES
('India','2024-01-01',980000000),
('USA','2024-01-01',250000000);

-- Display Countries Table
SELECT * FROM countries;

-- Display COVID Cases Table
SELECT * FROM covid_cases;

-- Display COVID Deaths Table
SELECT * FROM covid_deaths;

-- Display COVID Vaccines Table
SELECT * FROM covid_vaccines;

-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
SELECT
    c.country,
    co.continent,
    c.confirmed_cases
FROM covid_cases c
INNER JOIN countries co
ON c.country = co.country
WHERE c.report_date = '2024-01-01'
ORDER BY c.confirmed_cases DESC
LIMIT 1;

-- Use Case 2: Join COVID Deaths and Vaccination Data using LEFT JOIN
SELECT
    d.country,
    d.total_deaths,
    v.vaccinated
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country = v.country;

-- Use Case 3: Analyze Deaths by Continent
SELECT
    co.continent,
    SUM(c.deaths) AS total_deaths
FROM covid_cases c
INNER JOIN countries co
ON c.country = co.country
GROUP BY co.continent;

-- Use Case 4: Calculate Average Deaths Per Day
SELECT
    report_date,
    AVG(deaths) AS average_deaths
FROM covid_cases
GROUP BY report_date
ORDER BY report_date;

-- Use Case 5: Find Countries with Highest Infection Rates
SELECT
    c.country,
    c.confirmed_cases,
    co.population,
    (c.confirmed_cases * 100.0 / co.population) AS infection_rate
FROM covid_cases c
INNER JOIN countries co
ON c.country = co.country
WHERE c.report_date = '2024-01-02'
ORDER BY infection_rate DESC;
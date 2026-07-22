-- Create Database
CREATE DATABASE covid_db;

-- Select Database
USE covid_db;

-- Create covid_cases Table
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    time TIME,
    state VARCHAR(50),
    confirmed_indian_national INT,
    confirmed_foreign_national INT,
    recoveries INT,
    deaths INT,
    confirmed_cases INT
);

-- Display Table Structure
DESC covid_cases;

-- Insert Initial COVID Data
INSERT INTO covid_cases
(date, time, state, confirmed_indian_national, confirmed_foreign_national, recoveries, deaths, confirmed_cases)
VALUES
('2020-03-15', '10:00:00', 'India', 95, 5, 50, 2, 100);

-- Display Table Data
SELECT * FROM covid_cases;

-- Update Confirmed Cases
UPDATE covid_cases
SET confirmed_cases = 120
WHERE state = 'India'
AND date = '2020-03-15';

-- Display Updated Record
SELECT * FROM covid_cases
WHERE state = 'India';

-- Insert Incorrect Record
INSERT INTO covid_cases
(date, time, state, confirmed_indian_national, confirmed_foreign_national, recoveries, deaths, confirmed_cases)
VALUES
('2020-03-16', '10:00:00', 'IN', 100, 3, 60, 3, 130);

-- Display Records
SELECT * FROM covid_cases;

-- Delete Incorrect Record
DELETE FROM covid_cases
WHERE state = 'IN';

-- Display Records After Delete
SELECT * FROM covid_cases;

-- Add Vaccination Rate Column
ALTER TABLE covid_cases
ADD vaccination_rate FLOAT;

-- Display Updated Table Structure
DESC covid_cases;

-- Update Vaccination Rate
UPDATE covid_cases
SET vaccination_rate = 75.5
WHERE state = 'India';

-- Display Final Table
SELECT * FROM covid_cases;

-- Optional Commands

-- Drop Table
-- DROP TABLE covid_cases;

-- Drop Database
-- DROP DATABASE covid_db;
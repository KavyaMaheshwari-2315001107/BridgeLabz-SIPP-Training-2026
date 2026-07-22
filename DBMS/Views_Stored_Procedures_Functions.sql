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
    PRIMARY KEY(country, report_date)
);

-- Insert Sample Data
INSERT INTO covid_cases VALUES
('India','2024-01-01',45000000,530000,44400000),
('India','2024-01-02',45100000,531000,44500000),
('USA','2024-01-01',103000000,1120000,101000000),
('USA','2024-01-02',103500000,1121000,101300000),
('UK','2024-01-01',25000000,230000,24700000),
('UK','2024-01-02',25100000,230500,24800000);

--------------------------------------------------
-- Use Case 21
-- Create View for Latest COVID Data
--------------------------------------------------

CREATE VIEW latest_covid_data AS
SELECT
    country,
    report_date,
    confirmed_cases,
    deaths,
    recoveries
FROM covid_cases
WHERE report_date =
(
    SELECT MAX(c2.report_date)
    FROM covid_cases c2
    WHERE c2.country = covid_cases.country
);

-- Display View
SELECT * FROM latest_covid_data;

--------------------------------------------------
-- Use Case 22
-- Create Mortality Rate Function
--------------------------------------------------

DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(50),
    p_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(10,2);

    SELECT (deaths * 100.0 / confirmed_cases)
    INTO rate
    FROM covid_cases
    WHERE country = p_country
    AND report_date = p_date;

    RETURN rate;
END$$

DELIMITER ;

-- Call Function
SELECT CalculateMortalityRate('India','2024-01-02') AS Mortality_Rate;

--------------------------------------------------
-- Use Case 23
-- Create Stored Procedure
--------------------------------------------------

DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(50),
    IN p_date DATE,
    IN p_cases INT,
    IN p_deaths INT,
    IN p_recoveries INT
)
BEGIN

    UPDATE covid_cases
    SET
        confirmed_cases = p_cases,
        deaths = p_deaths,
        recoveries = p_recoveries
    WHERE country = p_country
    AND report_date = p_date;

END$$

DELIMITER ;

-- Call Procedure
CALL UpdateCovidStats(
'India',
'2024-01-02',
45200000,
532000,
44600000
);

SELECT * FROM covid_cases;

--------------------------------------------------
-- Use Case 24
-- Create Recovery Rate Function
--------------------------------------------------

DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(50)
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN

    DECLARE rate DECIMAL(10,2);

    SELECT (recoveries * 100.0 / confirmed_cases)
    INTO rate
    FROM covid_cases
    WHERE country = p_country
    ORDER BY report_date DESC
    LIMIT 1;

    RETURN rate;

END$$

DELIMITER ;

-- Call Function
SELECT CalculateRecoveryRate('India') AS Recovery_Rate;

--------------------------------------------------
-- Use Case 25
-- Create Audit Table
--------------------------------------------------

CREATE TABLE covid_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50),
    report_date DATE,
    old_cases INT,
    new_cases INT,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--------------------------------------------------
-- Create Trigger
--------------------------------------------------

DELIMITER $$

CREATE TRIGGER covid_update_trigger
BEFORE UPDATE
ON covid_cases
FOR EACH ROW
BEGIN

    INSERT INTO covid_audit(
        country,
        report_date,
        old_cases,
        new_cases
    )
    VALUES(
        OLD.country,
        OLD.report_date,
        OLD.confirmed_cases,
        NEW.confirmed_cases
    );

END$$

DELIMITER ;

-- Test Trigger
UPDATE covid_cases
SET confirmed_cases = 45300000
WHERE country = 'India'
AND report_date = '2024-01-02';

-- Display Audit Table
SELECT * FROM covid_audit;

-- Display COVID Cases
SELECT * FROM covid_cases;
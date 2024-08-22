CREATE TABLE henhouse_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
number_of_eggs INT,
number_of_workers INT
);

CREATE TABLE cheese_factory_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
kg_of_cheese DOUBLE PRECISION,
number_of_workers INT
);

CREATE TABLE cowshed_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
liters_of_milk DOUBLE PRECISION,
number_of_workers INT
);

CREATE TABLE guardhouse_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
number_of_fox_attacks INT,
number_of_workers INT
);

CREATE TABLE weekly_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
number_of_eggs_per_person DOUBLE PRECISION,
liters_of_milk_per_person DOUBLE PRECISION,
number_of_workers_per_fox DOUBLE PRECISION,
kg_of_cheese_per_person DOUBLE PRECISION
);

CREATE TABLE henhouse_weekly_report (
henhouse_report_id INT,
weekly_report_id INT,
PRIMARY KEY (henhouse_report_id, weekly_report_id)
);

CREATE TABLE cheese_factory_weekly_report (
cheese_factory_report_id INT,
weekly_report_id INT,
PRIMARY KEY (cheese_factory_report_id, weekly_report_id)
);

CREATE TABLE cowshed_weekly_report (
cowshed_report_id INT,
weekly_report_id INT,
PRIMARY KEY (cowshed_report_id, weekly_report_id)
);

CREATE TABLE guardhouse_weekly_report (
guardhouse_report_id INT,
weekly_report_id INT,
PRIMARY KEY (guardhouse_report_id, weekly_report_id)
);

CREATE TABLE monthly_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
number_of_eggs_per_person DOUBLE PRECISION,
liters_of_milk_per_person DOUBLE PRECISION,
number_of_workers_per_fox DOUBLE PRECISION,
kg_of_cheese_per_person DOUBLE PRECISION
);

CREATE TABLE weekly_monthly_report (
weekly_report_id INT,
monthly_report_id INT,
PRIMARY KEY (weekly_report_id, monthly_report_id)
);
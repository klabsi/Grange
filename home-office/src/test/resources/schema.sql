CREATE TABLE weekly_report (
id SERIAL PRIMARY KEY,
date_of_report DATE,
number_of_eggs_per_worker DOUBLE PRECISION,
liters_of_milk_per_worker DOUBLE PRECISION,
number_of_workers_per_fox DOUBLE PRECISION,
kg_of_cheese_per_worker DOUBLE PRECISION
);
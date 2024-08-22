create table henhouse_report (
id serial primary key,
date_of_report date,
number_of_eggs int,
number_of_workers int
);

create table cheese_factory_report (
id serial primary key,
date_of_report date,
kg_of_cheese double precision,
number_of_workers int
);

create table cowshed_report (
id serial primary key,
date_of_report date,
liters_of_milk double precision,
number_of_workers int
);

create table guardhouse_report (
id serial primary key,
date_of_report date,
number_of_fox_attacks int,
number_of_workers int
);

create table weekly_report (
id serial primary key,
date_of_report date,
number_of_eggs_per_person double precision,
liters_of_milk_per_person double precision,
number_of_workers_per_fox double precision,
kg_of_cheese_per_person double precision
);

create table henhouse_weekly_report (
henhouse_report_id int,
weekly_report_id int,
primary key (henhouse_report_id, weekly_report_id)
);

create table cheese_factory_weekly_report (
cheese_factory_report_id int,
weekly_report_id int,
primary key (cheese_factory_report_id, weekly_report_id)
);

create table cowshed_weekly_report (
cowshed_report_id int,
weekly_report_id int,
primary key (cowshed_report_id, weekly_report_id)
);

create table guardhouse_weekly_report (
guardhouse_report_id int,
weekly_report_id int,
primary key (guardhouse_report_id, weekly_report_id)
);

create table monthly_report (
id serial primary key,
date_of_report date,
number_of_eggs_per_person double precision,
liters_of_milk_per_person double precision,
number_of_workers_per_fox double precision,
kg_of_cheese_per_person double precision
);

create table weekly_monthly_report (
weekly_report_id int,
monthly_report_id int,
primary key (weekly_report_id, monthly_report_id)
);
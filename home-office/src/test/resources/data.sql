create sequence public.weekly_report_seq;
alter sequence weekly_report_seq restart with 3;

INSERT INTO weekly_report VALUES
(1, '2000-01-01', 1, 1, 1, 1),
(2, '2000-01-02', 1, 1, 1, 1)
;
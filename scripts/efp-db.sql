\c cljpgsql;

CREATE TABLE e21_months (
    month_id SERIAL PRIMARY KEY,
    number INTEGER NOT NULL,
    name VARCHAR(40) NOT NULL
);

INSERT INTO e21_months(number, name) VALUES
    (1, 'January'),
    (2, 'February'),
    (3, 'March'),
    (4, 'April'),
    (5, 'May'),
    (6, 'June'),
    (7, 'July'),
    (8, 'August'),
    (9, 'September'),
    (10, 'October'),
    (11, 'November'),
    (12, 'December');
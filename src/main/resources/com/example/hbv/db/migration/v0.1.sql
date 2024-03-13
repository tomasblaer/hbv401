CREATE TABLE tour (
    id INTEGER PRIMARY KEY,
    category TEXT,
    capacity INTEGER,
    date TEXT,
    name TEXT,
    guide INTEGER,
    info TEXT
);

CREATE TABLE user (
    id INTEGER PRIMARY KEY,
    name TEXT,
    username TEXT UNIQUE,
    password TEXT,
    phoneNumber TEXT,
    email TEXT,
    isAgent INTEGER
);

INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Tour 1', 10, '2024-05-01', 'Hiking in the mountains', 1, 'Hiking in the mountains');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Tour 2', 10, '2024-05-01', 'Hiking in the mountains', 1, 'Hiking in the mountains');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Tour 3', 10, '2024-05-01', 'Hiking in the mountains', 1, 'Hiking in the mountains');
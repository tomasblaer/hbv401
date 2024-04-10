CREATE TABLE IF NOT EXISTS tour (
    id INTEGER PRIMARY KEY,
    category TEXT,
    capacity INTEGER,
    date TEXT,
    name TEXT,
    guide INTEGER,
    info TEXT
);

CREATE TABLE IF NOT EXISTS user (
    id INTEGER PRIMARY KEY,
    name TEXT,
    username TEXT UNIQUE,
    password TEXT,
    phoneNumber TEXT,
    email TEXT,
    isAgent INTEGER
);

INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Hike', 10, '2024-05-01', 'Hiking up Úlfarsfell', 1, 'Relaxed hike with a great view of Reykjavik');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Hike', 10, '2024-07-01', 'Hiking up Esja', 1, 'Short hike with an experienced guide');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('City Tour', 20, '2024-06-01', 'Reykjavik DT Tour', 1, 'Tour around downtown Reykjavik');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Diving', 10, '2024-07-06', 'Diving in Vesturbæjarlaug', 1, 'Go diving with elders');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Sailing', 10, '2024-06-02', 'Kayaking in Eyjaförður', 1, 'Kayaking in the ocean with guides');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Northern Lights', 50, '2024-09-15', 'Northern Lights Expedition', 2, 'Guided tour to see the spectacular northern lights');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Glacier Hike', 8, '2024-08-20', 'Exploring Vatnajökull Glacier', 3, 'Experience hiking on the largest glacier in Iceland');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Whale Watching', 25, '2024-07-20', 'Whale Watching Tour', 4, 'Exciting boat trip to watch whales in their natural habitat');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Volcano Helicopter Flyover', 5, '2024-08-10', 'Helicopter Tour', 5, 'Helicopter tour over an active volcano in Iceland');
INSERT INTO tour (category, capacity, date, name, guide, info) VALUES ('Caving', 10, '2024-09-05', 'Langjökull Ice Cave Tour', 6, 'Discover the underground wonders of the Langjökull Ice Cave');

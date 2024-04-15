CREATE TABLE IF NOT EXISTS Tours (
    id INTEGER PRIMARY KEY,
    category TEXT,
    capacity INTEGER,
    date TEXT,
    name TEXT,
    info TEXT,
    guideId INTEGER REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Users (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phone_nr TEXT NOT NULL,
    isGuide INTEGER
);

CREATE TABLE IF NOT EXISTS Bookings (
    id INTEGER PRIMARY KEY,
    tourId INTEGER REFERENCES Tours(id) ON DELETE CASCADE,
    userId INTEGER REFERENCES Users(id) ON DELETE CASCADE
);

INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Hike', 10, '2024-05-01', 'Hiking up Úlfarsfell', 1, 'Relaxed hike with a great view of Reykjavik');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Hike', 10, '2024-07-01', 'Hiking up Esja', 1, 'Short hike with an experienced guide');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('City Tour', 20, '2024-06-01', 'Reykjavik DT Tour', 1, 'Tour around downtown Reykjavik');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Diving', 10, '2024-07-06', 'Diving in Vesturbæjarlaug', 1, 'Go diving with elders');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Sailing', 10, '2024-06-02', 'Kayaking in Eyjaförður', 1, 'Kayaking in the ocean with guides');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Northern Lights', 50, '2024-09-15', 'Northern Lights Expedition', 1, 'Guided tour to see the spectacular northern lights');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Glacier Hike', 8, '2024-08-20', 'Exploring Vatnajökull Glacier', 1, 'Experience hiking on the largest glacier in Iceland');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Whale Watching', 25, '2024-07-20', 'Whale Watching Tour', 1, 'Exciting boat trip to watch whales in their natural habitat');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Volcano Helicopter Flyover', 5, '2024-08-10', 'Helicopter Tour', 1, 'Helicopter tour over an active volcano in Iceland');
INSERT INTO Tours (category, capacity, date, name, guideId, info) VALUES ('Caving', 10, '2024-09-05', 'Langjökull Ice Cave Tour', 1, 'Discover the underground wonders of the Langjökull Ice Cave');

INSERT INTO Users (name, email, phone_nr, isGuide) VALUES ('Nonni', 'nonni@hi.is', '1234567', 1);
INSERT INTO Users (name, email, phone_nr, isGuide) VALUES ('Mikki', 'mms@hi.is', '7654321', 0);
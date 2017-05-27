-- SET NAMES utf8mb4;
DROP TABLE IF EXISTS Events;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Messages;

CREATE TABLE Users
(
    id int,
    number_of_days int,
    number_of_hours int
);

CREATE TABLE Messages
(
    id int,
    message VARCHAR(255),
    number_of_users int,
    category VARCHAR(255)
);

CREATE TABLE Events
(
    eventTime TIMESTAMP, 
    userId int,
    eventType VARCHAR(255)
);

LOAD DATA LOCAL INFILE 'data/UserInfo.csv' 
INTO TABLE Users
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
--    ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES -- Skip header
(id, number_of_days, number_of_hours);
SHOW warnings;

LOAD DATA LOCAL INFILE 'data/MessageList.csv' 
INTO TABLE Messages
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
--    ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES -- Skip header
(id, message, number_of_users, category);
SHOW warnings;

LOAD DATA LOCAL INFILE 'data/AllEvents.csv' 
INTO TABLE Events
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
--    ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES -- Skip header
(eventTime, userId, eventType);
SHOW warnings;



/*
LOAD DATA LOCAL INFILE 'data/users.csv' 
INTO TABLE Users
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    ESCAPED BY '' -- We need to to deal with use of "\" and unicode/emoji characters Rob Dodson \ʕ•ᴥ•ʔ/;
LINES TERMINATED BY '\n'
IGNORE 1 LINES -- Skip header
(id, created_at, name, user_username, image, headline, invited_by_id, followers_count, followings_count, votes_count, posts_count, maker_of_count, comments_count, profile_url);
SHOW warnings;

LOAD DATA LOCAL INFILE 'data/votes.csv' 
INTO TABLE Votes
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES -- Skip header
(id, created_at, user_id, post_id, user_username, name, tagline, discussion_url);
SHOW warnings;
*/
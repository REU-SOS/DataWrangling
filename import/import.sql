-- SET NAMES utf8mb4;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users
(
    id int,
    number_of_days int,
    number_of_hours int
);

LOAD DATA LOCAL INFILE 'data/UserInfo.csv' 
INTO TABLE Users
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
--    ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES -- Skip header
(id, number_of_days, number_of_hours);
SHOW warnings;
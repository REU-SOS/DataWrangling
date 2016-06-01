
DROP TABLE IF EXISTS Posts;

CREATE TABLE Posts
(
	id int, 
	created_at TIMESTAMP, 
	name varchar(255), 
	tagline varchar(1000), 
	user_id int, 
	user_username varchar(255), 
	votes_count int, 
	comments_count int, 
	redirect_url varchar(500), 
	discussion_url varchar(500)
);

-- 57243;2016-03-31 19:55:33.127923-07;We Are Heroes;The next-gen MOBA+ RPG for mobile devices;443077;anh;1;0;http://www.producthunt.com/l/b3443c7ac79b50;http://www.producthunt.com/posts/we-are-heroes-2
-- 57242;2016-03-31 19:53:36.614695-07;Tesla Model 3;The mass market electric car by Tesla is here ⚡️🚘;16056;erictwillis;44;18;http://www.producthunt.com/l/3843d5a8440dc8;http://www.producthunt.com/posts/tesla-model-3-2

LOAD DATA LOCAL INFILE 'data/posts--2016-04-01_14-36-24-UTC.csv'
INTO TABLE Posts
FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES -- Skip header
(id, created_at, name, tagline, user_id, user_username, votes_count, comments_count, redirect_url, discussion_url);
SHOW warnings;
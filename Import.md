[Prereqs](https://github.com/REU-SOS/DataWrangling/blob/master/Prereqs.md#installing-mysql) | [Basics Queries](https://github.com/REU-SOS/DataWrangling/blob/master/BasicQueries.md#basic) | [Importing Data](https://github.com/REU-SOS/DataWrangling/blob/master/Import.md#import) | [Advanced](https://github.com/REU-SOS/DataWrangling/blob/master/Advanced.md#advanced) | [Programming with Databases](https://github.com/REU-SOS/DataWrangling/blob/master/Programming.md#programming)

# Import

Let's examine and then extend the import.sql to import more data!

This makes sure we delete old data before importing fresh.
```sql
DROP TABLE IF EXISTS Posts;
```

This creates a new table. The syntax describes the table, and then a list of variable names and types.
Depending on your database manager, there variable types can vary.

```sql
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
```

This code will load data from the CSV into the table. 
This basically maps the columns that appear in the CSV file to the columns in the database table.

```sql
LOAD DATA LOCAL INFILE 'data/posts--2016-04-01_14-36-24-UTC.csv'
INTO TABLE Posts
FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES -- Skip header
(id, created_at, name, tagline, user_id, user_username, votes_count, comments_count, redirect_url, discussion_url);
SHOW warnings;
```

## Practice

* Import users
* Import votes

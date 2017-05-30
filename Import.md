[Prereqs](https://github.com/REU-SOS/DataWrangling/blob/master/Prereqs.md#installing-mysql) | [Basics Queries](https://github.com/REU-SOS/DataWrangling/blob/master/BasicQueries.md#basic) | [Importing Data](https://github.com/REU-SOS/DataWrangling/blob/master/Import.md#import) | [Advanced](https://github.com/REU-SOS/DataWrangling/blob/master/Advanced.md#advanced) | [Programming with Databases](https://github.com/REU-SOS/DataWrangling/blob/master/Programming.md#programming)

# Import

Let's examine and then extend the import.sql to import more data!

### Getting all the files imported

Each developer has a csv file, but we want to be able to load all of them.
One simple strategy is to combine these files together:

```bash
cat BlazeData_Dev_* > AllEvents.csv
```

However, that will add the header line multiple lines. But this will work.

```bash
awk FNR-1 BlazeData_Dev_*.csv > AllEvents.csv
```

Using a bash script is an [alternative approach](https://stackoverflow.com/a/8539153/547112).

### Adding a new import.

This makes sure we delete old data before importing fresh.

```sql
DROP TABLE IF EXISTS Events;
```

This creates a new table. The syntax describes the table, and then a list of variable names and types. Depending on your database manager, the column types can vary.

```sql
CREATE TABLE Events
(
    eventTime TIMESTAMP, 
    userId int,
    eventType VARCHAR(255)
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

### Warnings?

Notice that 

tail -n +2

```bash
tail -n +2 BlazeData_Dev_* > AllEvents.csv
```

## Practice

* Import users
* Import votes

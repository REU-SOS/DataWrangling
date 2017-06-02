[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Basic

After loading data, you can work with the data by running queries in the MySQL client. 

Start the MySQL client from your OS Shell.

```bash
$ mysql -u root -p
```

The first step in the MySQL client is to select the database you want to work with.

```sql
mysql> use DevInt;
```

You can list databases, tables, and attributes (columns) in the tables to learn more about your dataset.

```sql
# List databases
mysql> show databases;

# List tables (assuming a database is in use)
mysql> show tables;

# Show attributes (columns) of a table
mysql> describe Events;
```

## Example Queries

Ordering: How can we see the top 10 users with most days of activity?

```sql
select * from Users 
ORDER BY number_of_days DESC 
LIMIT 10;
```

Filtering: How many users have at least 10 days of activity?

```sql
select COUNT(*) from Users 
WHERE number_of_days > 10;
```

Filtering: How many events contain the commands related to viewing?

```sql
select COUNT(*) from Events 
WHERE eventType LIKE '%View.%';
```

Grouping: What are the top most popular events?

```sql
select eventType, COUNT(*) as frequency from Events 
GROUP BY eventType
ORDER BY frequency DESC
LIMIT 10
```

## Helpful Functions

Date Functions: `DAYOFWEEK` - returns the week day number (1 for Sunday,2 for Monday ... 7 for Saturday)

## Practice

* Do users typically "View" code or "Edit" code more often?
* How many users have used `Edit.GoToDefinition` at least once?
* What day of week has the events?
* Which is the earliest and latest events?
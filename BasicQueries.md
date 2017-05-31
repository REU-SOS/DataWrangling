[Prereqs](https://github.com/REU-SOS/DataWrangling/blob/master/Prereqs.md#installing-mysql) | [Basics Queries](https://github.com/REU-SOS/DataWrangling/blob/master/BasicQueries.md#basic) | [Importing Data](https://github.com/REU-SOS/DataWrangling/blob/master/Import.md#import) | [Advanced](https://github.com/REU-SOS/DataWrangling/blob/master/Advanced.md#advanced) | [Programming with Databases](https://github.com/REU-SOS/DataWrangling/blob/master/Programming.md#programming)

# Basic

In order to select the default database, always remember to start your session with:
```sql
use DevInt;
```

How can we see the top 10 users with most days of activity?

```sql
select * from Users 
ORDER BY number_of_days DESC 
LIMIT 10;
```

#### Let's try some other basic queries.

How many users have at least 10 days of activity?

```sql
select COUNT(*) from Users 
WHERE number_of_days > 10;
```

How many posts contain the phrase iphone?

```sql
select COUNT(*) from Posts 
WHERE tagline LIKE '%iphone%';
```

Grouping posts

```sql
select redirect_url, COUNT(*) as timesPosted from Posts 
GROUP BY redirect_url
HAVING timesPosted > 1;
```

## Practice

* How many posts contain at least 1 comment?
* What post has the highest comments?
* Which post created after March 1, 2016 has the highest votes?
* Who submits the most posts?

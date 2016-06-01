# Basic

Remember when we waited to check which post had the highest votes?

This is how we would do this in SQL:

```sql
select * from Posts 
ORDER BY votes_count DESC 
LIMIT 1;
```

#### Let's try some other basic queries.

How many posts have been voted on at least 10 times?

```sql
select COUNT(*) from Posts 
WHERE votes_count > 10;
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

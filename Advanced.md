[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Advanced

Advanced queries involve combining data from multiple tables and doing calculations on the data.

## Example Queries

Select users who have at least 100 days of activity, count frequency of their top commands.

```sql
select eventType, COUNT(*) frequency from Users, Events 
where Users.number_of_days > 100 AND
      Events.userId = Users.id
GROUP BY eventType
ORDER BY frequency DESC
LIMIT 10;
```

## Resources

### Joins 

See tutorial for aggregation and joins:

* http://swcarpentry.github.io/sql-novice-survey/06-agg/
* http://swcarpentry.github.io/sql-novice-survey/07-join/

### Indexes

If you need to look up information across tables, you will want to add indexes to improve performance of your search.

```sql
create index Events_userId on Events (userId);
```

## Practice

* Select average count of events for users who have at least 100 days of activities.
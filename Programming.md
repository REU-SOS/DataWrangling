[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Programming

We often need to be able to do more complex analysis that we cannot easily express in SQL.  It may also be easier to write a program that runs several small queries quickly and then combines the data rather than trying to write a SQL query do all the work.

This repo has a Java project (that you can open up in Eclipse) that shows how to make a connection to a SQL database.  It also shows how to work with a properties file for storing secrets, like your database user name and password.

Run `App` to connect to the database and display all of the `Events` data.

## Practice

* Implement a simple select statement in Java, and iterate over results.  

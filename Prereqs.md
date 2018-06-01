[Prereqs](Prereqs.md#databases) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Databases

Databases and database management systems (DBMS) provide functionality for storing, retrieving, updating, and deleting with data that are optimized for these standard CRUD (create-retrieve-update-delete) operations. Relational databases store information in tables that can be connected together by attribute values.  Tables have attributes (or columns) and each row in the table is a specific instance of a set of attributes. Using databases to store collected and cleansed data can be useful for complex queries, working with the data programatically, and using a standard storage for use by other applications.

Every database manager — Oracle, IBM DB2, PostgreSQL, MySQL, Microsoft Access, and SQLite — stores data in a different way, so a database created with one cannot be used directly by another. However, every database manager can import and export data in a variety of formats, like `.csv`, so it is possible to move information from one to another.

## Getting Started

** Install MySQL **

We'll use MySQL as a representative example of working with a Relational DBMS.  Make sure that you have [installed MySQL](https://github.com/REU-SOS/EngineeringBasics/blob/master/SpecializedTools.md#mysql).


**Run MySQL Server**

If the mysql command doesn't work in your local shell or you cannot connect to the database, you may need to [start your MySQL server](https://pages.github.ncsu.edu/engr-csc326-staff/326-course-page/install/#43-starting-mysql) [Requires NCSU login].

## Working with MySQL from the Command Line

MySQL, when run from the command line, is its own client.  From the command line, you have your standard shell prompt.  We'll represent this as **`$`**.  When in the MySQL client, you'll have a MySQL prompt.  We'll represent this as **`mysql>`**.  The prompts are there to help you determine if you should use the OS shell or the MySQL client.  Do NOT enter the prompts as part of the command!  You'll get an error.

Shell commands like `ls` won't work in the MySQL client.  SQL queries won't work in your OS shell.  If you're in the MySQL client and need to get back to your OS shell, type `exit`.  To start the MySQL client, enter one of the following commands.  If you installed MySQL using the `choco` or `brew`, the root password is empty string (just hit enter when prompted for the password).

```bash
# without credentials
$ mysql
# with credentials
$ mysql -u root -p
```

**NOTE:** If you could only connect to the MySQL client using `mysql -u root -p`, that means you'll need to add `-u root -p` every time you run the `mysql` command from the OS shell.

## Getting a Dataset

We're going to work with the Developer Interaction dataset provided by ABB.  Clone or download the https://github.com/abb-iss/DeveloperInteractionLogs/ repository.

## Creating a Database

Start the MySQL client using `mysql -u root -p`.

```sql
mysql> create database DevInt;
```

Exit the MySQL client.

## Set up the Data

```bash
$ cd DataWrangling/import
$ mkdir data
# copy your ABB data into the new folder "data" (path should result as DataWrangling/import/data)
```

**Import Data**

Make sure that you're in `DataWrangling/import`.

```bash
$ mysql -u root -p DevInt < import.sql 
```

If you're getting an error with "COMMAND NOT ALOWED", use this option:

```
$ mysql -u root -p DevInt --local-infile=1 < import.sql 
```

**Check Import Success**

Run `mysql -u root -p`. Inspect your data using the following MySQL statements.

```sql
mysql> use DevInt
mysql> show tables;
mysql> select count(*) from Users;
```

Uh-oh! Zero or just 1 rows? Never plan on import working right. Always check!

Turns out, newlines are terminated differently depending on your system, if you see this problem, we need to fix import.sql `LINES TERMINATED BY \n` to  `LINES TERMINATED BY \r\n`. This is a difference in *nix encoded newlines vs Windows style newlines.

Now run import and verifications steps above, again.  

We can check if our data looks right:
```sql
mysql> select * from Users LIMIT 10;
```

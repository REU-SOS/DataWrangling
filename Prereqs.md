[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Databases

Every database manager — Oracle, IBM DB2, PostgreSQL, MySQL, Microsoft Access, and SQLite — stores data in a different way, so a database created with one cannot be used directly by another. However, every database manager can import and export data in a variety of formats, like .csv, so it is possible to move information from one to another.

### Installing MySQL

```
brew install mysql
# Install workbench
brew tap caskroom/cask
brew install brew-cask
brew cask install mysqlworkbench
```

```
# Use my custom mysql installer :)
git clone https://github.com/CSC-326/AutoInstall
cd AutoInstall/choco/mysql/
choco install .\mysql.nuspec -y

choco install mysql.workbench -y
```

Depending on how install goes, we may need to help people make sure their mysql server is running.

### Setting up a Database

Running mysql client.

```bash
# without credentials
mysql
# with credentials
mysql -u root -p
```

Create database

```sql
create database DevInt;
```

```bash
cd DataWrangling/import
# copy your product hunt data into a new folder "data" (path should result as DataWrangling/import/data
```

Import data.

```bash
mysql DevInt < import.sql 
```

If you're getting an error with "COMMAND NOT ALOWED", use this option:

```
mysql DevInt --local-infile=1 < import.sql 
```

Run mysql client. Inspect your data.

```sql
mysql> use DevInt
mysql> show tables;
mysql> select count(*) from Users;
```

Uh-oh! Zero or just 1 rows? Never plan on import working right. Always check!

Turns out, newlines are terminated differently depending on your system, if you see this problem, we need to fix import.sql `LINES TERMINATED BY \n` to just `LINES TERMINATED BY \r\n`. This is a difference in unix encoded newlines vs windows style newlines.

Now run import and verifications steps above, again.

We can check if our data looks right:
```sql
select * from Users LIMIT 10;
```

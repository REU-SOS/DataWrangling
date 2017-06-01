[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Databases

Every database manager — Oracle, IBM DB2, PostgreSQL, MySQL, Microsoft Access, and SQLite — stores data in a different way, so a database created with one cannot be used directly by another. However, every database manager can import and export data in a variety of formats, like .csv, so it is possible to move information from one to another.

### Installing MySQL
Run the following on the appropriate shell for your OS.

**Mac**
```bash
brew install mysql
# enable services and start local server
brew tap homebrew/services
brew services start mysql
# Install workbench
brew tap caskroom/cask
brew install brew-cask
brew cask install mysqlworkbench
```

**Windows** (you may need to run your shell in Administrator mode)
```bash
# install mysql
choco install mysql

# Or, Use my custom mysql installer :)
git clone https://github.com/CSC-326/AutoInstall
cd AutoInstall/choco/mysql/
choco install .\mysql.nuspec -y

choco install mysql.workbench -y
```

**Executable Install**
You can also install MySQL from the website.  We have installation instructions used in one of our classes available - [Alternative see iTrust MySQL instructions](http://agile.csc.ncsu.edu/iTrust/wiki/doku.php?id=home_deployment_instructions).

**Run MySQL Server**
If the mysql command doesn't work in your local shell or you cannot connect to the database, you may need to [start your MySQL server](http://agile.csc.ncsu.edu/iTrust/wiki/doku.php?id=home_deployment_instructions#starting_mysql).

### Setting up a Database

MySQL, when run from the command line, is its own client.  From the command line, you have your standard shell prompt.  We'll represent this as **$**.  When in the MySQL client, you'll have a MySQL prompt.  We'll represent this as **mysql>**.  The prompts are there to help you determine if you should use the OS shell or the MySQL client.  Do NOT enter the prompts as part of the command!  You'll get an error.

Shell commands like `ls` won't work in the MySQL client.  SQL queries won't working in your OS shell.  If you're in the MySQL client and need to get back to your OS shell, type `exit`.  To start the MySQL client, enter one of the following commands.  If you installed MySQL using the `choco` or `brew`, the root password is empty string (just hit enter when prompted for the password).

```bash
# without credentials
$ mysql
# with credentials
$ mysql -u root -p
```

**NOTE:** If you could only connect to the MySQL client using `mysql -u root -p`, that means you'll need to add `-u root -p` everytime you run the `mysql` command from the OS shell.

**Create Database**

Start the MySQL client using `mysql -u root -p`.

```sql
mysql> create database DevInt;
```

Exit the MySQL client.

**Set up the Data**

```bash
$ cd DataWrangling/import
$ mkdir data
# copy your ABB data into the new folder "data" (path should result as DataWrangling/import/data
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

Turns out, newlines are terminated differently depending on your system, if you see this problem, we need to fix import.sql `LINES TERMINATED BY \n` to just `LINES TERMINATED BY \r\n`. This is a difference in unix encoded newlines vs windows style newlines.

Now run import and verifications steps above, again.  

We can check if our data looks right:
```sql
mysql> select * from Users LIMIT 10;
```

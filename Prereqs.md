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

```
# without credentials
mysql
# with credentials
mysql -u root -p
```

Create database

```sql
create database ProductHunt;
```

```bash
cd DataWrangling/import
# copy your product hunt data into a new folder "data" (path should result as DataWrangling/import/data
```

Import data.

```
mysql -u root -p ProductHunt < import.sql 
```

Run mysql client. Inspect your data.

```
mysql> use ProductHunt
mysql> show tables;
mysql> select count(*) from Posts;
```

Uh-oh! Zero rows? Never plan on import working right. Always check!

Turns out, newlines are terminated differently in this file, we need to fix import.sql `LINES TERMINATED BY \r\n` to just `LINES TERMINATED BY \n`. This is a difference in windows encoded newlines vs unix style newlines.

Now run import and verifications steps above, again.

We can check if our data looks right:
```
select * from Posts LIMIT 1;
```

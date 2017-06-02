[Prereqs](Prereqs.md#installing-mysql) | [Importing Data](Import.md#import) | [Basics Queries](BasicQueries.md#basic) |  [Advanced](Advanced.md#advanced) | [Programming with Databases](Programming.md#programming)

# Import

Let's examine and then extend `import.sql` to import more data!

### Getting all the files imported

Each developer has a csv file, but we want to be able to load all of them.  We need to combine them all together.

Change directory to `DataWrangling/import/data/`.

One simple strategy is to combine these files together in the OS shell:

```bash
cat BlazeData_Dev_* > AllEvents.csv
```

However, that will add the header line multiple lines, which won't work in our import. But this will work to combine the files together while removing all of the header lines.

```bash
awk FNR-1 BlazeData_Dev_*.csv > AllEvents.csv
```

Using a bash script is an [alternative approach](https://stackoverflow.com/a/8539153/547112).

### Adding a new import.

Update `import.sql` or create a new import file (e.g., `importEvents.sql`) in the `DataWrangling/import/` directory.  There are three parts to the import script.

 1. Delete old data before importing fresh.

    ```sql
    DROP TABLE IF EXISTS Events;
    ```

 2. Create a new table. The syntax describes the table, which includes the table name and a list of table attributes or columns. The attributes are given a name and a type.  Depending on your database manager, the column types can vary.

    ```sql
    CREATE TABLE Events
    (
        eventTime TIMESTAMP, 
        userId int,
        eventType VARCHAR(255)
    );
    ```

 3. Load CSV file into the table. The statement maps the columns that appear in the CSV file to the columns in the database table.  The token delimiter and line delimiter can be modified for your specific data set.

    ```sql
    LOAD DATA LOCAL INFILE 'data/AllEvents.csv' 
    INTO TABLE Events
    CHARACTER SET utf8mb4
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\n' -- Remember to use right line endings for your system.
    (eventTime, userId, eventType);
    SHOW warnings;
    ```

## Practice

* Import messages.  Either add to the `import.sql` file or create a new file `importMessages.sql`.  The messages are listed in `MessageList.csv`; the first row provides the column information.  

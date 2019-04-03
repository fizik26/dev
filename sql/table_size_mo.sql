# return the size in mo of your selected table ( parameter tablename )

SELECT CONCAT(ROUND(((cast(DATA_LENGTH as signed ) + cast(INDEX_LENGTH as signed )) / 1024 / 1024), 2), 'Mo') AS SizeMo FROM information_schema.TABLES WHERE table_name = 'tableName';

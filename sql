建表sql: SHOW CREATE TABLE `table`
查询有哪些表: SELECT * FROM information_schema.TABLES WHERE TABLE_SCHEMA = (SELECT DATABASE()) 
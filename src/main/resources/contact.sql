PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE contact (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), email VARCHAR(50), phone CHAR(10));
INSERT INTO "contact" VALUES(1,'testName','testEmail','1234567890');
DELETE FROM sqlite_sequence;
INSERT INTO "sqlite_sequence" VALUES('contact',1);
COMMIT;
 

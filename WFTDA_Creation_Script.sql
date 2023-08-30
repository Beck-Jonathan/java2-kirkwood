/*Copyright statement 
	 FILE:_Creation_Script.sql 
 	DATE:	2023-05-02 
AUTHORS:Jonathan Beck 
DESCRIPTION: 
A sql script for creating tables for My indivudual project

Modification History 
Date modified - Who did it - what was modified 
2023-03-24	Jonathan Beck		Initial Creation
2023-05-02  Jonathan Beck - Final version created */
DROP DATABASE IF EXISTS WFTDA ;
CREATE DATABASE WFTDA;
USE WFTDA;

/****************************************

create the ARENAS table

******************************************/

; 
 DROP TABLE IF EXISTS ARENAS;
CREATE TABLE  ARENAS
(arena_name varchar(50) NOT NULL UNIQUE    COMMENT 'The name of the arena'
,city varchar(50) NOT NULL     COMMENT 'City where the arena is located'
,state varchar(50) NOT NULL     COMMENT 'State wthere the arena is located'
,contact_phone varchar(12) NOT NULL     COMMENT 'Contact phone number for the arena'
,capacity int NOT NULL     COMMENT 'Seating capacity of the arena'
,CONSTRAINT ARENAS_pk PRIMARY KEY (arena_name)
)COMMENT 'The Teams Home Arena'
 ;
/****************************************

create the audit table for ARENAS table

******************************************/

; 
 DROP TABLE IF EXISTS ARENAS_audit;
CREATE TABLE ARENAS_audit
(arena_name varchar(50) NOT NULL UNIQUE    COMMENT 'The name of the arena'
,city varchar(50) NOT NULL     COMMENT 'City where the arena is located'
,state varchar(50) NOT NULL     COMMENT 'State wthere the arena is located'
,contact_phone varchar(12) NOT NULL     COMMENT 'Contact phone number for the arena'
,capacity int NOT NULL     COMMENT 'Seating capacity of the arena'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for ARENAS '
 ;
/****************************************

create the update stored procedure for ARENAS table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_ARENAS;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_ARENAS
 (IN old_arena_name_param varchar(50)
,IN old_city_param varchar(50)
,IN old_state_param varchar(50)
,IN old_contact_phone_param varchar(12)
,IN old_capacity_param int
,IN new_city_param varchar(50)
,IN new_state_param varchar(50)
,IN new_contact_phone_param varchar(12)
,IN new_capacity_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE ARENAS
 set city = new_city_param
,state = new_state_param
,contact_phone = new_contact_phone_param
,capacity = new_capacity_param
WHERE arena_name= old_arena_name_param
and city= old_city_param
and state= old_state_param
and contact_phone= old_contact_phone_param
and capacity= old_capacity_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for ARENAS table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_ARENAS;
 DELIMITER $$ 
 Create Procedure sp_delete_ARENAS
 (in arena_name_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM ARENAS
WHERE arena_name=arena_name_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for ARENAS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_ARENAS_by_arena_name;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_ARENAS_by_arena_name
 (in arena_name_param varchar(50)
)
begin 
 SELECT arena_name
, city
, state
, contact_phone
, capacity
 FROM ARENAS
WHERE arena_name=arena_name_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forARENAS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_ARENAS_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_ARENAS_all
 ()
BEGIN 
 SELECT arena_name
, city
, state
, contact_phone
, capacity
 FROM ARENAS
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for ARENAS table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_ARENAS;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_ARENAS
 (in arena_name_param varchar(50)
,in city_param varchar(50)
,in state_param varchar(50)
,in contact_phone_param varchar(12)
,in capacity_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO ARENAS
VALUES ( arena_name_param 
,city_param 
,state_param 
,contact_phone_param 
,capacity_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the TEAM table

******************************************/

; 
 DROP TABLE IF EXISTS TEAM;
CREATE TABLE  TEAM
(team_name varchar(50) NOT NULL UNIQUE    COMMENT 'The team Nickname'
,city varchar(50) NOT NULL     COMMENT 'City where the team is headquartered'
,state varchar(50) NOT NULL     COMMENT 'Seate where the team is headquarterd'
,division varchar(50) NOT NULL     COMMENT 'The Local Division this team is associated with'
,arena_name varchar(50) NOT NULL     COMMENT 'The arena ID'
,CONSTRAINT TEAM_pk PRIMARY KEY (team_name)
,CONSTRAINT fk_TEAM_ARENAS FOREIGN KEY (arena_name) references ARENAS (arena_name)
)COMMENT 'The Overall team'
 ;
/****************************************

create the audit table for TEAM table

******************************************/

; 
 DROP TABLE IF EXISTS TEAM_audit;
CREATE TABLE TEAM_audit
(team_name varchar(50) NOT NULL UNIQUE    COMMENT 'The team Nickname'
,city varchar(50) NOT NULL     COMMENT 'City where the team is headquartered'
,state varchar(50) NOT NULL     COMMENT 'Seate where the team is headquarterd'
,division varchar(50) NOT NULL     COMMENT 'The Local Division this team is associated with'
,arena_name varchar(50) NOT NULL     COMMENT 'The arena ID'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for TEAM '
 ;
/****************************************

create the update stored procedure for TEAM table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_TEAM;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_TEAM
 (IN old_team_name_param varchar(50)
,IN old_city_param varchar(50)
,IN old_state_param varchar(50)
,IN old_division_param varchar(12)
,IN old_arena_name_param int
,IN new_city_param varchar(50)
,IN new_state_param varchar(50)
,IN new_division_param varchar(12)
,IN new_arena_name_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE TEAM
 set city = new_city_param
,state = new_state_param
,division = new_division_param
,arena_name = new_arena_name_param
WHERE team_name= old_team_name_param
and city= old_city_param
and state= old_state_param
and division= old_division_param
and arena_name= old_arena_name_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for TEAM table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_TEAM;
 DELIMITER $$ 
 Create Procedure sp_delete_TEAM
 (in team_name_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM TEAM
WHERE team_name=team_name_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for TEAM table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_TEAM_by_team_name;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_TEAM_by_team_name
 (in team_name_param varchar(50)
)
begin 
 SELECT team_name
, city
, state
, division
, arena_name
 FROM TEAM
WHERE team_name=team_name_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forTEAM table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_TEAM_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_TEAM_all
 ()
BEGIN 
 SELECT team_name
, city
, state
, division
, arena_name
 FROM TEAM
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for TEAM table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_TEAM;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_TEAM
 (in team_name_param varchar(50)
,in city_param varchar(50)
,in state_param varchar(50)
,in division_param varchar(12)
,in arena_name_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO TEAM
VALUES ( team_name_param 
,city_param 
,state_param 
,division_param 
,arena_name_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the SKATER table

******************************************/

; 
 DROP TABLE IF EXISTS SKATER;
CREATE TABLE  SKATER
(derby_name varchar(50) NOT NULL UNIQUE    COMMENT 'Skaters chosen Derby Name'
,first_name varchar(50) NOT NULL     COMMENT 'Skater Name assigned at birth'
,last_name varchar(50) NOT NULL     COMMENT 'Skater Family Name'
,phone_number varchar(12) NOT NULL     COMMENT 'Skater Phone Number'
,team_affiliation varchar(50) NULL     COMMENT 'The particuar team this skater skates for'
,CONSTRAINT SKATER_pk PRIMARY KEY (derby_name)
,CONSTRAINT fk_SKATER_TEAM FOREIGN KEY (team_affiliation) references TEAM (team_Name)
)COMMENT 'Core ID information for each skater'
 ;
/****************************************

create the audit table for SKATER table

******************************************/

; 
 DROP TABLE IF EXISTS SKATER_audit;
CREATE TABLE SKATER_audit
(derby_name varchar(50) NOT NULL UNIQUE    COMMENT 'Skaters chosen Derby Name'
,first_name varchar(50) NOT NULL     COMMENT 'Skater Name assigned at birth'
,last_name varchar(50) NOT NULL     COMMENT 'Skater Family Name'
,phone_number varchar(12) NOT NULL     COMMENT 'Skater Phone Number'
,team_affiliation varchar(50) NULL     COMMENT 'The particuar team this skater skates for'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for SKATER '
 ;
/****************************************

create the update stored procedure for SKATER table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_SKATER;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_SKATER
 (IN old_derby_name_param varchar(50)
,IN old_first_name_param varchar(50)
,IN old_last_name_param varchar(50)
,IN old_phone_number_param varchar(12)
,IN old_team_affiliation_param int
,IN new_first_name_param varchar(50)
,IN new_last_name_param varchar(50)
,IN new_phone_number_param varchar(12)
,IN new_team_affiliation_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE SKATER
 set first_name = new_first_name_param
,last_name = new_last_name_param
,phone_number = new_phone_number_param
,team_affiliation = new_team_affiliation_param
WHERE derby_name= old_derby_name_param
and first_name= old_first_name_param
and last_name= old_last_name_param
and phone_number= old_phone_number_param
and team_affiliation= old_team_affiliation_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for SKATER table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_SKATER;
 DELIMITER $$ 
 Create Procedure sp_delete_SKATER
 (in derby_name_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM SKATER
WHERE derby_name=derby_name_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for SKATER table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_SKATER_by_derby_name;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_SKATER_by_derby_name
 (in derby_name_param varchar(50)
)
begin 
 SELECT derby_name
, first_name
, last_name
, phone_number
, team_affiliation
 FROM SKATER
WHERE derby_name=derby_name_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forSKATER table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_SKATER_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_SKATER_all
 ()
BEGIN 
 SELECT derby_name
, first_name
, last_name
, phone_number
, team_affiliation
 FROM SKATER
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for SKATER table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_SKATER;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_SKATER
 (in derby_name_param varchar(50)
,in first_name_param varchar(50)
,in last_name_param varchar(50)
,in phone_number_param varchar(12)
,in team_affiliation_param int
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO SKATER
VALUES ( derby_name_param 
,first_name_param 
,last_name_param 
,phone_number_param 
,team_affiliation_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the INVOICES_ISSUED table

******************************************/

; 
 DROP TABLE IF EXISTS INVOICES_ISSUED;
CREATE TABLE  INVOICES_ISSUED
(invoice_number int NOT NULL  AUTO_INCREMENT   COMMENT 'The league assigned invoice number'
,derby_name varchar(50) NOT NULL     COMMENT 'Skaters chosen Derby Name'
,practice_date date NOT NULL     COMMENT '"The Date of the practice attended, that this invoice is for"'
,date_issued date NOT NULL     COMMENT 'The date the invoice was issued'
,amount int NOT NULL     COMMENT 'The dollar amount of the invoice'
,receipt_date date NULL     COMMENT 'The date we received the payment'
,CONSTRAINT INVOICES_ISSUED_pk PRIMARY KEY (invoice_number)
,CONSTRAINT fk_INVOICES_ISSUED_SKATER FOREIGN KEY (derby_name) references SKATER (derby_Name)
)COMMENT 'A record of all invocies issued and their payment status.'
 ;
/****************************************

create the audit table for INVOICES_ISSUED table

******************************************/

; 
 DROP TABLE IF EXISTS INVOICES_ISSUED_audit;
CREATE TABLE INVOICES_ISSUED_audit
(invoice_number int NOT NULL     COMMENT 'The league assigned invoice number'
,derby_name varchar(50) NOT NULL     COMMENT 'Skaters chosen Derby Name'
,practice_date date NOT NULL     COMMENT '"The Date of the practice attended, that this invoice is for"'
,date_issued date NOT NULL     COMMENT 'The date the invoice was issued'
,amount int NOT NULL     COMMENT 'The dollar amount of the invoice'
,receipt_date date NULL     COMMENT 'The date we received the payment'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for INVOICES_ISSUED '
 ;
/****************************************

create the update stored procedure for INVOICES_ISSUED table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_INVOICES_ISSUED;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_INVOICES_ISSUED
 (IN old_invoice_number_param varchar(50)
,IN old_derby_name_param varchar(50)
,IN old_practice_date_param varchar(50)
,IN old_date_issued_param varchar(12)
,IN old_amount_param int
,IN old_receipt_date_param varchar(50)
,IN new_derby_name_param varchar(50)
,IN new_practice_date_param varchar(50)
,IN new_date_issued_param varchar(12)
,IN new_amount_param int
,IN new_receipt_date_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE INVOICES_ISSUED
 set derby_name = new_derby_name_param
,practice_date = new_practice_date_param
,date_issued = new_date_issued_param
,amount = new_amount_param
,receipt_date = new_receipt_date_param
WHERE invoice_number= old_invoice_number_param
and derby_name= old_derby_name_param
and practice_date= old_practice_date_param
and date_issued= old_date_issued_param
and amount= old_amount_param
and receipt_date= old_receipt_date_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for INVOICES_ISSUED table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_INVOICES_ISSUED;
 DELIMITER $$ 
 Create Procedure sp_delete_INVOICES_ISSUED
 (in invoice_number_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM INVOICES_ISSUED
WHERE invoice_number=invoice_number_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for INVOICES_ISSUED table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_INVOICES_ISSUED_by_invoice_number;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_INVOICES_ISSUED_by_invoice_number
 (in invoice_number_param varchar(50)
)
begin 
 SELECT invoice_number
, derby_name
, practice_date
, date_issued
, amount
, receipt_date
 FROM INVOICES_ISSUED
WHERE invoice_number=invoice_number_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forINVOICES_ISSUED table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_INVOICES_ISSUED_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_INVOICES_ISSUED_all
 ()
BEGIN 
 SELECT invoice_number
, derby_name
, practice_date
, date_issued
, amount
, receipt_date
 FROM INVOICES_ISSUED
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for INVOICES_ISSUED table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_INVOICES_ISSUED;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_INVOICES_ISSUED
 (in invoice_number_param varchar(50)
,in derby_name_param varchar(50)
,in practice_date_param varchar(50)
,in date_issued_param varchar(12)
,in amount_param int
,in receipt_date_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO INVOICES_ISSUED
VALUES ( invoice_number_param 
,derby_name_param 
,practice_date_param 
,date_issued_param 
,amount_param 
,receipt_date_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the MIXERS table

******************************************/

; 
 DROP TABLE IF EXISTS MIXERS;
CREATE TABLE  MIXERS
(game_id int NOT NULL UNIQUE AUTO_INCREMENT   COMMENT 'The internal id for this bout'
,arena_name varchar(50) NOT NULL     COMMENT 'The Arena this mixer bout took place in'
,event_date date NOT NULL     COMMENT 'The Date this mixer bout occured'
,CONSTRAINT MIXERS_pk PRIMARY KEY (game_id)
,CONSTRAINT fk_MIXERS_ARENAS FOREIGN KEY (arena_name) references ARENAS (arena_name)
)COMMENT 'A record of mixer bouts that have occured'
 ;
/****************************************

create the audit table for MIXERS table

******************************************/

; 
 DROP TABLE IF EXISTS MIXERS_audit;
CREATE TABLE MIXERS_audit
(game_id int NOT NULL UNIQUE    COMMENT 'The internal id for this bout'
,arena_name varchar(50) NOT NULL     COMMENT 'The Arena this mixer bout took place in'
,event_date date NOT NULL     COMMENT 'The Date this mixer bout occured'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for MIXERS '
 ;
/****************************************

create the update stored procedure for MIXERS table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_MIXERS;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_MIXERS
 (IN old_game_id_param varchar(50)
,IN old_arena_name_param varchar(50)
,IN old_event_date_param varchar(50)
,IN new_arena_name_param varchar(50)
,IN new_event_date_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE MIXERS
 set arena_name = new_arena_name_param
,event_date = new_event_date_param
WHERE game_id= old_game_id_param
and arena_name= old_arena_name_param
and event_date= old_event_date_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for MIXERS table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_MIXERS;
 DELIMITER $$ 
 Create Procedure sp_delete_MIXERS
 (in game_id_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM MIXERS
WHERE game_id=game_id_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for MIXERS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_MIXERS_by_game_id;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_MIXERS_by_game_id
 (in game_id_param varchar(50)
)
begin 
 SELECT game_id
, arena_name
, event_date
 FROM MIXERS
WHERE game_id=game_id_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forMIXERS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_MIXERS_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_MIXERS_all
 ()
BEGIN 
 SELECT game_id
, arena_name
, event_date
 FROM MIXERS
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for MIXERS table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_MIXERS;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_MIXERS
 (in game_id_param varchar(50)
,in arena_name_param varchar(50)
,in event_date_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO MIXERS
VALUES ( game_id_param 
,arena_name_param 
,event_date_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the MIXER_PARTICIPANTS table

******************************************/

; 
 DROP TABLE IF EXISTS MIXER_PARTICIPANTS;
CREATE TABLE  MIXER_PARTICIPANTS
(game_id int NOT NULL     COMMENT 'the internal_id for this bout'
,game_count int NOT NULL     COMMENT 'The assigned_id for a skater participating in this bout'
,derby_name varchar(50) NOT NULL     COMMENT 'Skaters chosen Derby Name'
,points_scored int NULL     COMMENT 'How many points this skater scored in this bout'
,CONSTRAINT MIXER_PARTICIPANTS_pk PRIMARY KEY (game_id,game_count)
,CONSTRAINT fk_MIXER_PARTICIPANTS_MIXERS FOREIGN KEY (game_id) references MIXERS (game_id)
,CONSTRAINT fk_MIXER_PARTICIPANTS_SKATER FOREIGN KEY (derby_name) references SKATER (derby_name)
)COMMENT 'A line item list of attendees per event.'
 ;
/****************************************

create the audit table for MIXER_PARTICIPANTS table

******************************************/

; 
 DROP TABLE IF EXISTS MIXER_PARTICIPANTS_audit;
CREATE TABLE MIXER_PARTICIPANTS_audit
(game_id int NOT NULL     COMMENT 'the internal_id for this bout'
,game_count int NOT NULL     COMMENT 'The assigned_id for a skater participating in this bout'
,derby_name varchar(50) NOT NULL     COMMENT 'Skaters chosen Derby Name'
,points_scored int NULL     COMMENT 'How many points this skater scored in this bout'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for MIXER_PARTICIPANTS '
 ;
/****************************************

create the update stored procedure for MIXER_PARTICIPANTS table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_MIXER_PARTICIPANTS;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_MIXER_PARTICIPANTS
 (IN old_game_id_param varchar(50)
,IN old_game_count_param varchar(50)
,IN old_derby_name_param varchar(50)
,IN old_points_scored_param varchar(12)
,IN new_derby_name_param varchar(50)
,IN new_points_scored_param varchar(12)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE MIXER_PARTICIPANTS
 set derby_name = new_derby_name_param
,points_scored = new_points_scored_param
WHERE game_id= old_game_id_param
and game_count= old_game_count_param
and derby_name= old_derby_name_param
and points_scored= old_points_scored_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for MIXER_PARTICIPANTS table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_MIXER_PARTICIPANTS;
 DELIMITER $$ 
 Create Procedure sp_delete_MIXER_PARTICIPANTS
 (in game_id_param varchar(50)
,in game_count_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM MIXER_PARTICIPANTS
WHERE game_id=game_id_param
and game_count=game_count_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for MIXER_PARTICIPANTS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_MIXER_PARTICIPANTS_by_game_id;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_MIXER_PARTICIPANTS_by_game_id
 (in game_id_param varchar(50)
,in game_count_param varchar(50)
)
begin 
 SELECT game_id
, game_count
, derby_name
, points_scored
 FROM MIXER_PARTICIPANTS
WHERE game_id=game_id_param
and game_count=game_count_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forMIXER_PARTICIPANTS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_MIXER_PARTICIPANTS_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_MIXER_PARTICIPANTS_all
 ()
BEGIN 
 SELECT game_id
, game_count
, derby_name
, points_scored
 FROM MIXER_PARTICIPANTS
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for MIXER_PARTICIPANTS table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_MIXER_PARTICIPANTS;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_MIXER_PARTICIPANTS
 (in game_id_param varchar(50)
,in game_count_param varchar(50)
,in derby_name_param varchar(50)
,in points_scored_param varchar(12)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO MIXER_PARTICIPANTS
VALUES ( game_id_param 
,game_count_param 
,derby_name_param 
,points_scored_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the VENDORS table

******************************************/

; 
 DROP TABLE IF EXISTS VENDORS;
CREATE TABLE  VENDORS
(vendor_name varchar(50) NOT NULL     COMMENT 'the name of the vendor'
,vendor_address varchar(100) NOT NULL     COMMENT 'The address of the vendor'
,vendor_city varchar(50) NOT NULL     COMMENT 'the city of the vendor'
,vendor_state varchar(50) NOT NULL     COMMENT 'the state of the vendor'
,vendor_contact_name varchar(50) NOT NULL UNIQUE    COMMENT 'the contact person at the vendor'
,vendor_phone_number varchar(14) NOT NULL UNIQUE    COMMENT 'the most useful phone number for this vendor'
,vendor_type  enum ('arena', 'food', 'equipment','ref')  NOT NULL     COMMENT 'an option select for what this vendor gets caregorized in for our accounting'
,CONSTRAINT VENDORS_pk PRIMARY KEY (vendor_name)
)COMMENT 'A table containing our vendors'
 ;
/****************************************

create the audit table for VENDORS table

******************************************/

; 
 DROP TABLE IF EXISTS VENDORS_audit;
CREATE TABLE VENDORS_audit
(vendor_name varchar(50) NOT NULL     COMMENT 'the name of the vendor'
,vendor_address varchar(100) NOT NULL     COMMENT 'The address of the vendor'
,vendor_city varchar(50) NOT NULL     COMMENT 'the city of the vendor'
,vendor_state varchar(50) NOT NULL     COMMENT 'the state of the vendor'
,vendor_contact_name varchar(50) NOT NULL UNIQUE    COMMENT 'the contact person at the vendor'
,vendor_phone_number varchar(14) NOT NULL UNIQUE    COMMENT 'the most useful phone number for this vendor'
,vendor_type  enum ('arena', 'food', 'equipment','ref')  NOT NULL     COMMENT 'an option select for what this vendor gets caregorized in for our accounting'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for VENDORS '
 ;
/****************************************

create the update stored procedure for VENDORS table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_VENDORS;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_VENDORS
 (IN old_vendor_name_param varchar(50)
,IN old_vendor_address_param varchar(50)
,IN old_vendor_city_param varchar(50)
,IN old_vendor_state_param varchar(12)
,IN old_vendor_contact_name_param int
,IN old_vendor_phone_number_param varchar(50)
,IN old_vendor_type_param varchar(50)
,IN new_vendor_address_param varchar(50)
,IN new_vendor_city_param varchar(50)
,IN new_vendor_state_param varchar(12)
,IN new_vendor_contact_name_param int
,IN new_vendor_phone_number_param varchar(50)
,IN new_vendor_type_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE VENDORS
 set vendor_address = new_vendor_address_param
,vendor_city = new_vendor_city_param
,vendor_state = new_vendor_state_param
,vendor_contact_name = new_vendor_contact_name_param
,vendor_phone_number = new_vendor_phone_number_param
,vendor_type = new_vendor_type_param
WHERE vendor_name= old_vendor_name_param
and vendor_address= old_vendor_address_param
and vendor_city= old_vendor_city_param
and vendor_state= old_vendor_state_param
and vendor_contact_name= old_vendor_contact_name_param
and vendor_phone_number= old_vendor_phone_number_param
and vendor_type= old_vendor_type_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for VENDORS table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_VENDORS;
 DELIMITER $$ 
 Create Procedure sp_delete_VENDORS
 (in vendor_name_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM VENDORS
WHERE vendor_name=vendor_name_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for VENDORS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_VENDORS_by_vendor_name;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_VENDORS_by_vendor_name
 (in vendor_name_param varchar(50)
)
begin 
 SELECT vendor_name
, vendor_address
, vendor_city
, vendor_state
, vendor_contact_name
, vendor_phone_number
, vendor_type
 FROM VENDORS
WHERE vendor_name=vendor_name_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forVENDORS table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_VENDORS_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_VENDORS_all
 ()
BEGIN 
 SELECT vendor_name
, vendor_address
, vendor_city
, vendor_state
, vendor_contact_name
, vendor_phone_number
, vendor_type
 FROM VENDORS
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for VENDORS table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_VENDORS;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_VENDORS
 (in vendor_name_param varchar(50)
,in vendor_address_param varchar(50)
,in vendor_city_param varchar(50)
,in vendor_state_param varchar(12)
,in vendor_contact_name_param int
,in vendor_phone_number_param varchar(50)
,in vendor_type_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO VENDORS
VALUES ( vendor_name_param 
,vendor_address_param 
,vendor_city_param 
,vendor_state_param 
,vendor_contact_name_param 
,vendor_phone_number_param 
,vendor_type_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the INVOICES_RECEIVED table

******************************************/

; 
 DROP TABLE IF EXISTS INVOICES_RECEIVED;
CREATE TABLE  INVOICES_RECEIVED
(invoice_sequence int NOT NULL UNIQUE AUTO_INCREMENT   COMMENT 'The Auto incremetned id of the Vendor'
,invoice_id varchar(250) NOT NULL     COMMENT 'The invoice_ID assigned by the issuer'
,vendor_name varchar(50) NOT NULL     COMMENT 'the id of the vendor that issued this'
,receipt_date date NOT NULL     COMMENT 'the date this invoice was received by us'
,amount int NOT NULL     COMMENT 'the amount due on the invoice'
,payment_date date NULL     COMMENT 'the date we paid this invoice'
,game_id int NOT NULL     COMMENT 'The bout that this invoice is associated with.'
,CONSTRAINT INVOICES_RECEIVED_pk PRIMARY KEY (invoice_sequence)
,CONSTRAINT fk_INVOICES_RECEIVED_VENDORS FOREIGN KEY (vendor_name) references VENDORS (vendor_name)
,CONSTRAINT fk_INVOICES_RECEIVED_MIXERS FOREIGN KEY (game_id) references MIXERS (game_id)
)COMMENT 'The invvoices and bills we have received'
 ;
/****************************************

create the audit table for INVOICES_RECEIVED table

******************************************/

; 
 DROP TABLE IF EXISTS INVOICES_RECEIVED_audit;
CREATE TABLE INVOICES_RECEIVED_audit
(invoice_sequence int NOT NULL UNIQUE    COMMENT 'The Auto incremetned id of the Vendor'
,invoice_id varchar(250) NOT NULL     COMMENT 'The invoice_ID assigned by the issuer'
,vendor_name varchar(50) NOT NULL     COMMENT 'the id of the vendor that issued this'
,receipt_date date NOT NULL     COMMENT 'the date this invoice was received by us'
,amount int NOT NULL     COMMENT 'the amount due on the invoice'
,payment_date date NULL     COMMENT 'the date we paid this invoice'
,game_id int NOT NULL     COMMENT 'The bout that this invoice is associated with.'
, action_type VARCHAR(50) NOT NULL COMMENT 'insert update or delete'
, action_date DATETIME NOT NULL COMMENT 'when it happened'
, action_user VARCHAR(255) NOT NULL COMMENT 'Who did it'
)COMMENT 'The audit table for INVOICES_RECEIVED '
 ;
/****************************************

create the update stored procedure for INVOICES_RECEIVED table

******************************************/

DROP PROCEDURE IF EXISTS sp_update_INVOICES_RECEIVED;
 DELIMITER $$ 
 CREATE PROCEDURE sp_update_INVOICES_RECEIVED
 (IN old_invoice_sequence_param varchar(50)
,IN old_invoice_id_param varchar(50)
,IN old_vendor_name_param varchar(50)
,IN old_receipt_date_param varchar(12)
,IN old_amount_param int
,IN old_payment_date_param varchar(50)
,IN old_game_id_param varchar(50)
,IN new_invoice_id_param varchar(50)
,IN new_vendor_name_param varchar(50)
,IN new_receipt_date_param varchar(12)
,IN new_amount_param int
,IN new_payment_date_param varchar(50)
,IN new_game_id_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0; 
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = TRUE;
START TRANSACTION ;

UPDATE INVOICES_RECEIVED
 set invoice_id = new_invoice_id_param
,vendor_name = new_vendor_name_param
,receipt_date = new_receipt_date_param
,amount = new_amount_param
,payment_date = new_payment_date_param
,game_id = new_game_id_param
WHERE invoice_sequence= old_invoice_sequence_param
and invoice_id= old_invoice_id_param
and vendor_name= old_vendor_name_param
and receipt_date= old_receipt_date_param
and amount= old_amount_param
and payment_date= old_payment_date_param
and game_id= old_game_id_param
;if SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count'
;END $$
DELIMITER ;

/****************************************

create the delete stored procedure  for INVOICES_RECEIVED table

******************************************/

DROP PROCEDURE IF EXISTS sp_delete_INVOICES_RECEIVED;
 DELIMITER $$ 
 Create Procedure sp_delete_INVOICES_RECEIVED
 (in invoice_sequence_param varchar(50)
)
BEGIN 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT TINYINT DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET SQL_ERROR = true;
START TRANSACTION ;

DELETE FROM INVOICES_RECEIVED
WHERE invoice_sequence=invoice_sequence_param
;
iF SQL_ERROR = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
SELECT update_count as 'update count';END $$
DELIMITER ;

/****************************************

create the retreive by primary key stored procedure  for INVOICES_RECEIVED table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_INVOICES_RECEIVED_by_invoice_sequence;
DELIMITER $$ 
 CREATE PROCEDURE sp_get_INVOICES_RECEIVED_by_invoice_sequence
 (in invoice_sequence_param varchar(50)
)
begin 
 SELECT invoice_sequence
, invoice_id
, vendor_name
, receipt_date
, amount
, payment_date
, game_id
 FROM INVOICES_RECEIVED
WHERE invoice_sequence=invoice_sequence_param
;
END $$
DELIMITER ;

/****************************************

create the retreive all stored procedure  forINVOICES_RECEIVED table

******************************************/

DROP PROCEDURE IF EXISTS sp_get_INVOICES_RECEIVED_all;
;DELIMITER $$ 
 CREATE PROCEDURE sp_get_INVOICES_RECEIVED_all
 ()
BEGIN 
 SELECT invoice_sequence
, invoice_id
, vendor_name
, receipt_date
, amount
, payment_date
, game_id
 FROM INVOICES_RECEIVED
;
END $$
DELIMITER ;

/****************************************

create the insert stored procedure  for INVOICES_RECEIVED table

******************************************/

DROP PROCEDURE IF EXISTS sp_insert_INVOICES_RECEIVED;
;DELIMITER $$ 
 CREATE PROCEDURE sp_insert_INVOICES_RECEIVED
 (in invoice_sequence_param varchar(50)
,in invoice_id_param varchar(50)
,in vendor_name_param varchar(50)
,in receipt_date_param varchar(12)
,in amount_param int
,in payment_date_param varchar(50)
,in game_id_param varchar(50)
)
begin 
 DECLARE SQL_ERROR TINYINT DEFAULT FALSE;
DECLARE UPDATE_COUNT tinyint default 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
SET sql_error = true;
START TRANSACTION ;

INSERT INTO INVOICES_RECEIVED
VALUES ( invoice_sequence_param 
,invoice_id_param 
,vendor_name_param 
,receipt_date_param 
,amount_param 
,payment_date_param 
,game_id_param 

)
;
if sql_error = FALSE then
SET update_count=row_count();
COMMIT;
ELSE
SET update_count=0;
ROLLBACK;
END IF;
select update_count as 'update count'
;END $$
DELIMITER ;

 /****************************************

create the insert statements for the Vendors table

******************************************/

Insert into Vendors (
Vendor_name
,vendor_address
,Vendor_city
,Vendor_state
,vendor_contact_name
,vendor_phone_number
,Vendor_type
)
Values 
('Play It Again Sports','3649 1st Ave SE','Cedar Rapids','IA','Brad O_Brien','(319) 366-8664','Equipment')
,('HY Vee','1843 Johnson Ave NW','Cedar Rapids','IA','John Fangman','(319) 365-0477','Food')
,('ImOn Ice Arena','1100 Rockford Rd SW','Cedar Rapids','IA','Erik Hudson','(319) 398-0100','Arena')
,('Jake Gerth','510 Rumley','Des Moines','IA','Jake Gerth','(541) 542-5424','Ref')
,('Jonathan Beck','2405 Spruce Wood','Dubuque','IA','Jonathan Beck','(223) 314-4521','Ref')
,('Magic Missle','6723 Boulder Dr','Cedar Rapids','IA','Magic Missle','(319) 542-5422','Ref')

;



USE WFTDA;



USE WFTDA;

/****************************************

create the insert statements for the Arenas table

******************************************/

Insert into Arenas (
Arena_name
,City
,State
,Contact_Phone
,Capacity
)
Values 
('Game On','Robins','IA','123-459-7824','400')
,('Peoria Civic Center','Peoria','IL','123-456-9982','500')
,('Brenton Skating Plaza','Des Moines','IA','224-442-6663','600')
,('Mercer Rec Center','Iowa City','IA','224-889-6632','700')
,('McElroy Auditorium','Waterloo','IA','789-456-2332','400')

;

USE WFTDA;

/****************************************

create the insert statements for the Team table

******************************************/

Insert into Team (
Team_Name
,City
,State
,Division
,Arena_name
)
Values 
('CR Rollergirls','Cedar Rapids','Iowa','Midwest League','Game On')
,('Peoria Prowlers','Peoria','Illinois','Midwest League','Peoria Civic Center')
,('Des Moines Roller Derby','Des Moines','Iowa','Midwest League','Brenton Skating Plaza')
,('OCCRD','Iowa City','Iowa','Midwest League','Mercer Rec Center')
,('Cedar Valley Roller Derby','Waterloo','Iowa','Midwest League','McElroy Auditorium')

;

USE WFTDA;

/****************************************

create the insert statements for the Skater table

******************************************/

Insert into Skater (
Derby_Name
,First_Name
,Last_name
,Phone_Number
,Team_Affiliation
)
Values 
('Slammy','Tiffany','Dodd','319-529-4612','CR Rollergirls')
,('Hit-em-hard','Amanda','Smith','319-782-3626','CR Rollergirls')
,('Jelly Roll Stitches','Caroline','Uthe','319-986-2322','CR Rollergirls')
,('Shark','Lisa','Watts','563-131-3625','CR Rollergirls')
,('Biohazard','Jasmine','Everet','319-334-7878','CR Rollergirls')
,('Switch Hammer','Sarah','Cavin','309-321-3232','Peoria Prowlers')
,('Grimm Cripling','Kat','Schmitt','309-941-5677','Peoria Prowlers')
,('PeanutButterAndJam','Megan','Bartlett','309-565-3287','Peoria Prowlers')
,('Blammy','Elizabeth','Hoffman','309-787-4664','Peoria Prowlers')
,('Road Rager','Hannah','Rama','309-852-6273','Peoria Prowlers')
,('Stingray','Emma','Decker','515-583-6759','Peoria Prowlers')
,('Mary Choppins','Mary','Haverman','515-852-6491','Des Moines Roller Derby')
,('Lady Sabotage','Jackie','Hopkinton','319-350-7809','Des Moines Roller Derby')
,('Barracuda Smoulder','Brandi','Cushman','515-831-4056','Des Moines Roller Derby')
,('Luna Steel','Laura','Schmidt','309-903-8700','Des Moines Roller Derby')
,('Hit and Run','Megan','Jamison','319-850-9155','OCCRD')
,('Whammy','Katie','Abbot','515-802-6642','OCCRD')
,('One Hit Wonder','Liz','Jenkins','515-628-2111','OCCRD')
,('Lord of the Rink','Hana','Watkins','319-844-4460','OCCRD')
,('Tequila Sheila','Katherine','Gott','319-854-3279','OCCRD')
,('Painbow','Isla','Scebold','563-215-2004','Cedar Valley Roller Derby')
,('Bambi Hunter','Jasmine','Smith','319-708-6504','Cedar Valley Roller Derby')
,('Blockingjay','Anna','Hamm','563-858-0413','Cedar Valley Roller Derby')
,('Meanhatten Zombie','Trinity','Adams','319-546-8106','Cedar Valley Roller Derby')
,('CrazySkates','Amy','Weber','319-705-6304','Cedar Valley Roller Derby')

;

USE WFTDA;

/****************************************

create the insert statements for the Invoices_issued table

******************************************/

Insert into Invoices_issued (
Derby_Name
,Practice_Date
,Date_Issued
,Amount
,Receipt_Date
)
Values 
('Slammy','22-11-1','22-12-1','30',null)
,('Hit-em-hard','22-11-2','22-12-2','30',null)
,('Jelly Roll Stitches','22-11-3','22-12-3','30','23-1-16')
,('Shark','22-11-4','22-12-4','30','23-3-6')
,('Biohazard','22-11-5','22-12-5','30','23-1-14')
,('Switch Hammer','22-11-6','22-12-6','30','23-2-25')
,('Grimm Cripling','22-11-7','22-12-7','30',null)
,('PeanutButterAndJam','22-11-8','22-12-8','30','22-12-20')
,('Blammy','22-11-9','22-12-9','30','22-10-30')
,('Road Rager','22-11-10','22-12-10','30','22-12-29')
,('Stingray','22-11-11','22-12-11','30','22-11-20')
,('Mary Choppins','22-11-12','22-12-12','30','22-11-2')
,('Lady Sabotage','22-11-13','22-12-13','30','23-2-23')
,('Barracuda Smoulder','22-11-14','22-12-14','30','23-1-18')
,('Luna Steel','22-11-15','22-12-15','30',null)
,('Hit and Run','22-11-16','22-12-16','30',null)
,('Whammy','22-11-17','22-12-17','30','23-1-4')
,('One Hit Wonder','22-11-18','22-12-18','30','22-12-3')
,('Lord of the Rink','22-11-19','22-12-19','30',null)
,('Tequila Sheila','22-11-20','22-12-20','30',null)
,('Painbow','22-11-21','22-12-21','30',null)
,('Bambi Hunter','22-11-22','22-12-22','30',null)
,('Blockingjay','22-11-23','22-12-23','30',null)
,('Meanhatten Zombie','22-11-24','22-12-24','30','22-12-16')
,('CrazySkates','22-11-25','22-12-25','30','23-1-25')
,('Slammy','22-12-2','23-1-1','30',null)
,('Hit-em-hard','22-12-3','23-1-2','30',null)
,('Jelly Roll Stitches','22-12-4','23-1-3','30','23-1-9')
,('Shark','22-12-5','23-1-4','30','22-12-12')
,('Biohazard','22-12-6','23-1-5','30','23-3-2')
,('Switch Hammer','22-12-7','23-1-6','30',null)
,('Grimm Cripling','22-12-8','23-1-7','30',null)
,('PeanutButterAndJam','22-12-9','23-1-8','30','22-12-5')
,('Blammy','22-12-10','23-1-9','30',null)
,('Road Rager','22-12-11','23-1-10','30','23-1-27')
,('Stingray','22-12-12','23-1-11','30','22-12-30')
,('Mary Choppins','22-12-13','23-1-12','30',null)
,('Lady Sabotage','22-12-14','23-1-13','30','23-1-12')
,('Barracuda Smoulder','22-12-15','23-1-14','30','22-12-26')
,('Luna Steel','22-12-16','23-1-15','30','23-1-6')
,('Hit and Run','22-12-17','23-1-16','30','23-2-9')
,('Whammy','22-12-18','23-1-17','30','23-2-6')
,('One Hit Wonder','22-12-19','23-1-18','30',null)
,('Lord of the Rink','22-12-20','23-1-19','30',null)
,('Tequila Sheila','22-12-21','23-1-20','30',null)
,('Painbow','22-12-22','23-1-21','30',null)
,('Bambi Hunter','22-12-23','23-1-22','30','23-2-27')
,('Blockingjay','22-12-24','23-1-23','30','23-1-27')
,('Meanhatten Zombie','22-12-25','23-1-24','30',null)
,('CrazySkates','22-12-26','23-1-25','30',null)
,('Slammy','23-1-2','23-2-1','30','23-1-31')
,('Hit-em-hard','23-1-3','23-2-2','30',null)
,('Jelly Roll Stitches','23-1-4','23-2-3','30','23-3-12')
,('Shark','23-1-5','23-2-4','30',null)
,('Biohazard','23-1-6','23-2-5','30',null)
,('Switch Hammer','23-1-7','23-2-6','30',null)
,('Grimm Cripling','23-1-8','23-2-7','30','23-2-12')
,('PeanutButterAndJam','23-1-9','23-2-8','30','23-3-2')
,('Blammy','23-1-10','23-2-9','30',null)
,('Road Rager','23-1-11','23-2-10','30','23-1-11')
,('Stingray','23-1-12','23-2-11','30',null)
,('Mary Choppins','23-1-13','23-2-12','30','23-3-7')
,('Lady Sabotage','23-1-14','23-2-13','30','23-2-1')
,('Barracuda Smoulder','23-1-15','23-2-14','30',null)
,('Luna Steel','23-1-16','23-2-15','30','23-2-10')
,('Hit and Run','23-1-17','23-2-16','30',null)
,('Whammy','23-1-18','23-2-17','30','23-1-18')
,('One Hit Wonder','23-1-19','23-2-18','30',null)
,('Lord of the Rink','23-1-20','23-2-19','30',null)
,('Tequila Sheila','23-1-21','23-2-20','30',null)
,('Painbow','23-1-22','23-2-21','30',null)
,('Bambi Hunter','23-1-23','23-2-22','30','23-1-29')
,('Blockingjay','23-1-24','23-2-23','30',null)
,('Meanhatten Zombie','23-1-25','23-2-24','30','23-3-11')
,('CrazySkates','23-1-26','23-2-25','30',null)
,('Slammy','23-2-2','23-3-4','30',null)
,('Hit-em-hard','23-2-3','23-3-5','30',null)
,('Jelly Roll Stitches','23-2-4','23-3-6','30',null)
,('Shark','23-2-5','23-3-7','30',null)
,('Biohazard','23-2-6','23-3-8','30',null)
,('Switch Hammer','23-2-7','23-3-9','30',null)
,('Grimm Cripling','23-2-8','23-3-10','30',null)
,('PeanutButterAndJam','23-2-9','23-3-11','30',null)
,('Blammy','23-2-10','23-3-12','30','23-2-11')
,('Road Rager','23-2-11','23-3-13','30',null)
,('Stingray','23-2-12','23-3-14','30',null)
,('Mary Choppins','23-2-13','23-3-15','30','23-3-12')
,('Lady Sabotage','23-2-14','23-3-16','30',null)
,('Barracuda Smoulder','23-2-15','23-3-17','30',null)
,('Luna Steel','23-2-16','23-3-18','30',null)
,('Hit and Run','23-2-17','23-3-19','30','23-3-10')
,('Whammy','23-2-18','23-3-20','30',null)
,('One Hit Wonder','23-2-19','23-3-21','30',null)
,('Lord of the Rink','23-2-20','23-3-22','30',null)
,('Tequila Sheila','23-2-21','23-3-23','30',null)
,('Painbow','23-2-22','23-3-24','30',null)
,('Bambi Hunter','23-2-23','23-3-25','30',null)
,('Blockingjay','23-2-24','23-3-26','30',null)
,('Meanhatten Zombie','23-2-25','23-3-27','30',null)
,('CrazySkates','23-2-26','23-3-28','30','23-2-20')
,('Slammy','23-3-5','23-4-4','30',null)
,('Hit-em-hard','23-3-6','23-4-5','30',null)
,('Jelly Roll Stitches','23-3-7','23-4-6','30',null)
,('Shark','23-3-8','23-4-7','30',null)
,('Biohazard','23-3-9','23-4-8','30',null)
,('Switch Hammer','23-3-10','23-4-9','30',null)
,('Grimm Cripling','23-3-11','23-4-10','30',null)
,('PeanutButterAndJam','23-3-12','23-4-11','30',null)
,('Blammy','23-3-13','23-4-12','30',null)
,('Road Rager','23-3-14','23-4-13','30',null)
,('Stingray','23-3-15','23-4-14','30',null)
,('Mary Choppins','23-3-16','23-4-15','30',null)
,('Lady Sabotage','23-3-17','23-4-16','30',null)
,('Barracuda Smoulder','23-3-18','23-4-17','30',null)
,('Luna Steel','23-3-19','23-4-18','30',null)
,('Hit and Run','23-3-20','23-4-19','30',null)
,('Whammy','23-3-21','23-4-20','30',null)
,('One Hit Wonder','23-3-22','23-4-21','30',null)
,('Lord of the Rink','23-3-23','23-4-22','30',null)
,('Tequila Sheila','23-3-24','23-4-23','30',null)
,('Painbow','23-3-25','23-4-24','30',null)
,('Bambi Hunter','23-3-26','23-4-25','30',null)
,('Blockingjay','23-3-27','23-4-26','30',null)
,('Meanhatten Zombie','23-3-28','23-4-27','30',null)
,('CrazySkates','23-3-29','23-4-28','30',null)

;

USE WFTDA;



/****************************************

create the insert statements for the Mixers table

******************************************/

Insert into Mixers (
Arena_name
,Event_Date
)
Values 
('Game On','23-12-2')
,('Peoria Civic Center','23-1-5')
,('Brenton Skating Plaza','25-3-23')

;

USE WFTDA;

/****************************************

create the insert statements for the Mixer_Participants table

******************************************/

Insert into Mixer_Participants (
Game_id
,Game_Count
,Derby_Name
,Points_Scored
)
Values 
('1','1','Slammy','12')
,('1','2','Hit-em-hard','8')
,('1','3','Jelly Roll Stitches','10')
,('1','4','Shark','10')
,('1','5','Biohazard','8')
,('1','6','Switch Hammer','14')
,('2','1','Grimm Cripling','9')
,('2','2','PeanutButterAndJam','13')
,('2','3','Blammy','13')
,('2','4','Road Rager','14')
,('2','5','Slammy','15')
,('2','6','Hit-em-hard','12')
,('3','1','Jelly Roll Stitches','15')
,('3','2','Shark','9')
,('3','3','Biohazard','6')
,('3','4','Switch Hammer','6')
,('3','5','Grimm Cripling','15')
,('3','6','PeanutButterAndJam','9')

;
/****************************************

create the insert statements for the Invoices_received table

******************************************/

Insert into Invoices_received (
Invoice_ID
,Vendor_name
,Receipt_date
,Amount
,Payment_Date,
game_id
)
Values 
('AF78421D','Play It Again Sports','22-12-7','250 ','22-4-1',1)
,('DF567DF4','HY Vee','22-12-8','100 ','22-4-1',1)
,('4454-54541','ImOn Ice Arena','22-12-9','700 ','22-4-1',1)
,('4455-56463','ImOn Ice Arena','22-12-10','300 ','22-4-1',1)
,('RoyalCheese','Jake Gerth','22-12-11','400 ',null,1)
,('D3981B0C0L','Jonathan Beck','22-12-12','300 ',null,1)
,('MFBL9842','Magic Missle','22-12-12','300 ',null,1)

;


/***************************************
create and run current_roster_count view
****************************************/
create  or replace view current_roster_count
as

select count(skater.derby_name), team.team_name
from skater 
inner join team
on skater.Team_Affiliation = team.Team_Name
group by team.team_name
;

select * from current_roster_count;

/***************************************
create and run outstanding_dues view
****************************************/
create  or replace view outstanding_dues
as

select skater.derby_name, sum(invoices_issued.amount)
from skater
inner join invoices_issued
on skater.derby_name = invoices_issued.derby_name
where Receipt_Date is null
group by skater.derby_name
order by sum(invoices_issued.amount)
;

select * from outstanding_dues

/***************************************
create trigger for insert into invoices
****************************************/
 DELIMITER $$
 DROP TRIGGER IF EXISTS tr_invoices_issued_after_insert $$
    CREATE TRIGGER tr_invoices_issued_after_insert
    AFTER insert ON invoices_issued
    for each row
    begin
    insert into invoices_issued_audit (
    Invoice_Number
    ,Derby_name
    ,Practice_Date
    , Date_Issued
    ,Amount
    ,Receipt_Date
    , action_type
    , action_date
    , action_user
    ) values (
     new.Invoice_Number -- 
    ,new.Derby_name
    ,new.Practice_Date
    , new.Date_Issued
    ,new.Amount
    ,new.Receipt_Date
    , 'insert' -- action_type
    , NOW() -- action_date
    ,  CURRENT_USER() -- action_user
    )
    ;
    end  $$
    DELIMITER ;
    ;
/***************************************
create trigger for update to invoices
****************************************/
 DELIMITER $$
 DROP TRIGGER IF EXISTS tr_invoices_issued_after_update $$
    CREATE TRIGGER tr_invoices_issued_after_update
    AFTER update ON invoices_issued
    for each row
    begin
    insert into invoices_issued_audit (
    Invoice_Number
    ,Derby_name
    ,Practice_Date
    , Date_Issued
    ,Amount
    ,Receipt_Date
    , action_type
    , action_date
    , action_user
    ) values (
     new.Invoice_Number -- 
    ,new.Derby_name
    ,new.Practice_Date
    , new.Date_Issued
    ,new.Amount
    ,new.Receipt_Date
    , 'update' -- action_type
    , NOW() -- action_date
    ,  CURRENT_USER() -- action_user
    )
    ;
    end  $$
    DELIMITER ;
    ;

/***************************************
create trigger for delete invoice
****************************************/
DELIMITER $$
 DROP TRIGGER IF EXISTS tr_invoices_issued_after_delete $$
    CREATE TRIGGER tr_invoices_issued_after_delete
    AFTER delete ON invoices_issued
    for each row
    begin
    insert into invoices_issued_audit (
    Invoice_Number
    ,Derby_name
    ,Practice_Date
    , Date_Issued
    ,Amount
    ,Receipt_Date
    , action_type
    , action_date
    , action_user
    ) values (
     old.Invoice_Number -- 
    ,old.Derby_name
    ,old.Practice_Date
    , old.Date_Issued
    ,old.Amount
    ,old.Receipt_Date
    , 'delete' -- action_type
    , NOW() -- action_date
    ,  CURRENT_USER() -- action_user
    )
    ;
    end  $$
    DELIMITER ;
    ;
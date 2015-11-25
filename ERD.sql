SET SESSION FOREIGN_KEY_CHECKS=0;


/* Create Tables */

CREATE TABLE board
(
	boardId int(4) NOT NULL AUTO_INCREMENT,
	userId int(10) NOT NULL,
	userName varchar(20),
	comment varchar(255),
	createday timestamp,
	PRIMARY KEY (boardId)
);


CREATE TABLE user
(
	userId int(10) NOT NULL AUTO_INCREMENT,
	userName varchar(20),
	password varchar(10) NOT NULL,
	sex int(1),
	createdat timestamp,
	PRIMARY KEY (userId)
);



/* Create Foreign Keys */

ALTER TABLE board
	ADD FOREIGN KEY (userId)
	REFERENCES user (userId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;




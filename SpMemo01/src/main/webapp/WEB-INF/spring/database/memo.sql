DROP TABLE tbl_memo ;
CREATE TABLE tbl_memo (
	id int(11) AUTO_INCREMENT PRIMARY KEY,
	memoCat CHAR(12),
	flag CHAR(8),
	date CHAR(10),
	subject VARCHAR(50),
	memoText TEXT


);
DESC tbl_memo;

DROP TABLE tbl_category;
CREATE TABLE tbl_category (
  C_KEY CHAR(12) PRIMARY KEY,
  C_VALUE VARCHAR(20)
);

INSERT INTO tbl_category VALUES ("CAT_THINK","오늘의 생각") ;			
INSERT INTO tbl_category VALUES ("CAT_WORK","오늘의 할일") ;
INSERT INTO tbl_category VALUES ("CAT_PROMISE","약속") ;
INSERT INTO tbl_category VALUES ("CAT_VISIT","방문할곳") ;
INSERT INTO tbl_category VALUES ("CAT_ETC","기타") ;

SELECT * FROM tbl_category;

CREATE TABLE tbl_flag (
	F_KEY CHAR(8),
	F_VALUE VARCHAR(20)
);

INSERT INTO tbl_flag VALUES("FLAG_TOP","중요");
INSERT INTO tbl_flag VALUES("FLAG_MID","보통");
INSERT INTO tbl_flag VALUES("FLAG_LOW","일반");

SELECT M.*,C_VALUE,F_VALUE FROM tbl_memo AS M
LEFT JOIN tbl_category AS c
	ON M.memoCat = c.C_KEY
LEFT JOIN tbl_flag AS f
	ON M.flag = f.F_KEY ;






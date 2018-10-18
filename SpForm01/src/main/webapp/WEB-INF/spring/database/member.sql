DROP TABLE tbl_member ;
-- member table을 생성
CREATE TABLE tbl_member (
	id int(11) AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(25),
	telno VARCHAR(25),
	addr VARCHAR(50),
	email VARCHAR(50)
);

DESC tbl_member ;
select * from tbl_member ;
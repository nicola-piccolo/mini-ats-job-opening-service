CREATE DATABASE job_opening;

CREATE USER 'job_opening_user'@'%' identified by 'SuPeRsEcReTpWd';

GRANT ALL PRIVILEGES ON job_opening.* TO 'job_opening_user'@'%';

USE job_opening

CREATE TABLE opening (
	id INT(10) UNSIGNED AUTO_INCREMENT,
	uid VARCHAR(36) NOT NULL,
	company_uid VARCHAR(36) NOT NULL,
	title VARCHAR(256) NOT NULL,
	head_count TINYINT(2) UNSIGNED,
	min_salary INT(10) UNSIGNED,
	max_salary INT(10) UNSIGNED,
	open TINYINT(1),
	deleted TINYINT(1),
	PRIMARY KEY (id)
) ENGINE=InnoDB;
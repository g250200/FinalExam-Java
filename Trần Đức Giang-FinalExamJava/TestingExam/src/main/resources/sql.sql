DROP DATABASE IF EXISTS TestingExam;
CREATE DATABASE TestingExam;
USE TestingExam;


CREATE TABLE Project(
	projectID TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    teamSize int not null
);

CREATE TABLE `User`(
	UserID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('Manager', 'Employee'),
     projectID TINYINT unsigned,
     FOREIGN KEY (projectID) REFERENCES `Project` (projectID) ON DELETE CASCADE on update cascade
);


INSERT INTO `Project`  (  projectID , teamSize	) 
VALUES
					(1,	3 ),
					(2,	5 );

INSERT INTO `User`  (UserID   , FullName, 			Email,				 `Password`,			`Role`, projectID		) 
VALUES
					(1,			N'Trần Đức Giang',	'g250200@gmail.com', 'Abc123',		'Employee',1	),
					(2,			N'Trung LD',	'trung@gmail.com', 'Trung123',			'Manager',1	),
                    (3,			N'adc','adc@gmail.com', 'Adc123',		'Manager',2	),
                    (4,			N'acc',	'accn@gmail.com', 		'Acc123',		'Employee',2	),
                    (5,			N'aac','aacn@gmail.com', 'Aac123',		'Employee',2	);
                    


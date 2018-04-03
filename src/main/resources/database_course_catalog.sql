create table teacher (
    id INT IDENTITY primary key,
    name varchar(512) NOT NULL,
    surname varchar(512) NOT NULL
);

create table course (
    id INT IDENTITY primary key,
    title varchar(512) NOT NULL,
    enable boolean NOT NULL,
    level integer NOT NULL,
	hours integer NOT NULL,
	teacher integer 
);
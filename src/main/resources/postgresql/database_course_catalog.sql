create table teacher (
    id serial primary key,
    name varchar NOT NULL,
    surname varchar NOT NULL
);

create table course (
    id serial primary key,
    title varchar NOT NULL,
    enable boolean NOT NULL,
    level integer NOT NULL,
	hours integer NOT NULL,
	teacher integer references teacher (id)
);
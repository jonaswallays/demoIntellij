create table if not exists book (id bigint NOT NULL AUTO_INCREMENT,
                                 book_title varchar(255),
                                 isbin varchar(255),
                                 authors varchar(255),
                                 publish_date date,
                                 publisher varchar(255),
                                 price double,
                                 stock int,
                                 PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
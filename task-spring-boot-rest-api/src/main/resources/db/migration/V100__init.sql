drop table if exists "address_book" CASCADE;
create sequence IF NOT EXISTS address_books_seq start with 6 increment by 1;

CREATE TABLE "ADDRESS_BOOK" (
    "ID_ADDRESS_BOOK" bigint not null, 
    "NAME" varchar(100) not null,
    "GENDER" varchar(1) not null,
    "BIRTHDATE" date not null,
     primary key ("ID_ADDRESS_BOOK")
);

insert into "ADDRESS_BOOK" ("ID_ADDRESS_BOOK", "NAME", "GENDER", "BIRTHDATE") values (1, 'Bill McKnight', 'M', '1977-03-16');
insert into "ADDRESS_BOOK" ("ID_ADDRESS_BOOK", "NAME", "GENDER", "BIRTHDATE") values (2, 'Paul Robinson', 'M', '1985-01-15');
insert into "ADDRESS_BOOK" ("ID_ADDRESS_BOOK", "NAME", "GENDER", "BIRTHDATE") values (3, 'Gemma Lane', 'F', '1991-11-20');
insert into "ADDRESS_BOOK" ("ID_ADDRESS_BOOK", "NAME", "GENDER", "BIRTHDATE") values (4, 'Sarah Stone', 'F', '1980-09-20');
insert into "ADDRESS_BOOK" ("ID_ADDRESS_BOOK", "NAME", "GENDER", "BIRTHDATE") values (5, 'Wes Jackson', 'M', '1974-08-14');

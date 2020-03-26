create table if not exists book
(
    id               bigint generated by default as identity
        constraint pk_book primary key,

    isbn             varchar(13)   not null
        constraint uk_book_isbn unique,

    title            varchar(200)  not null,
    subtitle         varchar(200),

    authors          varchar(200)  not null,

    publisher        varchar(200),
    publication_year integer,

    categories       varchar(500),

    description      varchar(2000),

    image_url        varchar(500),

    number_of_pages  integer,

    rating           varchar(5),

    price            numeric(7, 2) not null
);


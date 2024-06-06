CREATE TABLE tt_cat
(
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    gender VARCHAR NOT NULL,
    birthday DATE NOT NULL,
    species VARCHAR NOT NULL,
    PRIMARY KEY (id)
);
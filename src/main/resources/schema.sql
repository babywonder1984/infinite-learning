create table if not exists USER (
  id identity,
  username varchar(20) not null,
  password varchar(20) not null
);
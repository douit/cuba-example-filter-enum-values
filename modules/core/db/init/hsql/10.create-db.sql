-- begin CEFEV_PAYMENTS
create table CEFEV_PAYMENTS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PAYING_PARTY varchar(50),
    RECEIVING_PARTY varchar(50),
    --
    primary key (ID)
)^
-- end CEFEV_PAYMENTS

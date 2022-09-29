-- initial schema
create table sa_academic_year
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null
);

create table sa_university
(
    id                       bigint auto_increment
        primary key,
    approved                 bit          null,
    location                 varchar(255) null,
    name                     varchar(255) not null,
    current_academic_year_id bigint       null,
    constraint UK_jvorclvohl9goobjxqj9i1yfu
        unique (name),
    constraint FK4lh419ptrojwoa6rd4a0yu4ix
        foreign key (current_academic_year_id) references sa_academic_year (id)
);

create table sa_user
(
    id            bigint auto_increment
        primary key,
    email         varchar(255) not null,
    gender        varchar(255) not null,
    name          varchar(255) not null,
    password      varchar(255) not null,
    reg_no        varchar(255) not null,
    role          varchar(255) not null,
    university_id bigint       null,
    constraint UK_4fxvfkyanu28jrbvo8eak38q6
        unique (email),
    constraint UK_rstxxe6xc50pn6ourixvs3qoo
        unique (reg_no),
    constraint FKqdj7nxj2aa7x6b583aynchee8
        foreign key (university_id) references sa_university (id)
);

create table sa_association
(
    id                  bigint auto_increment
        primary key,
    name                varchar(255) not null,
    type                varchar(255) not null,
    creator_id          bigint       not null,
    head_association_id bigint       null,
    university_id       bigint       not null,
    constraint UK_ecqm9ab574b3j8qe466qmce9f
        unique (name),
    constraint FKejtco7m4cit5f95xva5f1090b
        foreign key (head_association_id) references sa_association (id),
    constraint FKhf1coiq4aqnkwxmsqyo1yrm1b
        foreign key (university_id) references sa_university (id),
    constraint FKi8k86x7r7sv8pkmtqlnpb9t8d
        foreign key (creator_id) references sa_user (id)
);

create table sa_dues_info
(
    academic_year_id bigint not null,
    association_id   bigint not null,
    amount           double not null,
    primary key (academic_year_id, association_id),
    constraint FK2yu3xpxlwupb5hjfcc4v3ko6
        foreign key (academic_year_id) references sa_academic_year (id),
    constraint FKk0fdqlvjp1rum0m9ehe23fi4g
        foreign key (association_id) references sa_association (id)
);

create table sa_membership
(
    association_id bigint       not null,
    user_id        bigint       not null,
    joined_year    varchar(255) not null,
    position       varchar(255) not null,
    primary key (association_id, user_id),
    constraint FKgb86ecekhdgrd2expu86qtmnc
        foreign key (user_id) references sa_user (id),
    constraint FKhct35gtpjglwee4jcdidxgcmx
        foreign key (association_id) references sa_association (id)
);

create table sa_dues_payment
(
    id                    bigint auto_increment
        primary key,
    amount                double      not null,
    date                  datetime(6) not null,
    status                int         not null,
    member_association_id bigint      not null,
    member_user_id        bigint      not null,
    constraint FKe7srl8sgp0xg83tycealuv3y7
        foreign key (member_association_id, member_user_id) references sa_membership (association_id, user_id)
);

create table spring_session
(
    PRIMARY_ID            char(36)     not null
        primary key,
    SESSION_ID            char(36)     not null,
    CREATION_TIME         bigint       not null,
    LAST_ACCESS_TIME      bigint       not null,
    MAX_INACTIVE_INTERVAL int          not null,
    EXPIRY_TIME           bigint       not null,
    PRINCIPAL_NAME        varchar(100) null,
    constraint SPRING_SESSION_IX1
        unique (SESSION_ID)
);

create index SPRING_SESSION_IX2
    on spring_session (EXPIRY_TIME);

create index SPRING_SESSION_IX3
    on spring_session (PRINCIPAL_NAME);

create table spring_session_attributes
(
    SESSION_PRIMARY_ID char(36)     not null,
    ATTRIBUTE_NAME     varchar(200) not null,
    ATTRIBUTE_BYTES    blob         not null,
    primary key (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
    constraint SPRING_SESSION_ATTRIBUTES_FK
        foreign key (SESSION_PRIMARY_ID) references spring_session (PRIMARY_ID)
            on delete cascade
);

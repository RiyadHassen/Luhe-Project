
    create table article (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        dislike_rate int default 0,
        like_rate int default 0,
        title varchar(255) not null,
        catagory_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table catagory (
       id bigint not null auto_increment,
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table article 
       add constraint FKhmorjm9lvcy8jlpl5a2xn5thv 
       foreign key (catagory_id) 
       references catagory (id)

    alter table article 
       add constraint FKbc2qerk3l47javnl2yvn51uoi 
       foreign key (user_id) 
       references user (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table article (
       id bigint not null auto_increment,
        content longtext not null,
        created_at datetime,
        dislike_rate int default 0,
        like_rate int default 0,
        title varchar(255) not null,
        catagory_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table catagory (
       id bigint not null auto_increment,
        type varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table article 
       add constraint FKhmorjm9lvcy8jlpl5a2xn5thv 
       foreign key (catagory_id) 
       references catagory (id)

    alter table article 
       add constraint FKbc2qerk3l47javnl2yvn51uoi 
       foreign key (user_id) 
       references user (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

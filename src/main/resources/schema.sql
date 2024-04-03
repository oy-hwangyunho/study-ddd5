drop table if exists middle_category;
drop table if exists large_category;

create table large_category
(
    large_category_id bigint not null auto_increment comment '대카테고리 seq',
    d_cat_cd varchar(255) comment '대카테고리 code',
    title varchar(255) comment '대카테고리 name',
    priority integer comment '우선순위',
    use_yn char not null comment '사용여부',
    created_at datetime(6) not null comment '등록일',
    updated_at datetime(6) not null comment '수정일',
    primary key (large_category_id),
    unique key large_category_unique (d_cat_cd)
) engine=InnoDB default charset=utf8;

create table middle_category (
    middle_category_id bigint not null auto_increment comment '중카테고리 seq',
    d_cat_cd varchar(255) comment '중카테고리 code',
    title varchar(255) comment '중카테고리 name',
    large_category_id bigint comment '대카테고리_seq',
    priority integer comment '우선순위',
    use_yn char not null comment '사용여부',
    created_at datetime(6) not null comment '등록일',
    updated_at datetime(6) not null comment '수정일',
    primary key (middle_category_id),
    unique key middle_category_unique (d_cat_cd)
) engine=InnoDB default charset=utf8;

alter table middle_category add constraint FK80ti8nek4uv8vn4vjhpre6mwg foreign key (large_category_id) references large_category (large_category_id)


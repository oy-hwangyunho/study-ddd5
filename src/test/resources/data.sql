drop table if exists middle_category;
drop table if exists large_category;
create table large_category (large_category_id bigint not null auto_increment, created_at datetime not null, updated_at datetime not null, d_cat_cd varchar(255), title varchar(255), priority integer, use_yn varchar(255), primary key (large_category_id)) engine=InnoDB default charset=utf8;
create table middle_category (middle_category_id bigint not null auto_increment, created_at datetime not null, updated_at datetime not null, d_cat_cd varchar(255), title varchar(255), large_category_id bigint, priority integer, use_yn varchar(255), primary key (middle_category_id)) engine=InnoDB default charset=utf8;
alter table middle_category add constraint FKo0e4j8vf52n8xd6yt9xhhy313 foreign key (large_category_id) references large_category (large_category_id);

insert into large_category (d_cat_cd, title, priority, use_yn, created_at, updated_at)
values ('001', '상의', 1, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001001', '반소매 티셔츠', 1, 1, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001010', '긴소매 티셔츠', 1, 2, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001011', '민소매 티셔츠', 1, 3, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001002', '셔츠/블라우스', 1, 4, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001003', '피케/카라 티셔츠', 1, 5, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001005', '맨투맨/스웨트셔츠', 1, 6, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001004', '후드 티셔츠', 1, 7, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001006', '니트/스웨터', 1, 8, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('001008', '기타 상의', 1, 9, 'Y', now(), now());


insert into large_category (d_cat_cd, title, priority, use_yn, created_at, updated_at)
values ('002', '아우터', 2, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002022', '후드 집업', 2, 1, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002001', '블루종/MA-1', 2, 2, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002002', '레더/라이더스 재킷', 2, 3, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002017', '트러커 재킷', 2, 4, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002003', '슈트/블레이저 재킷', 2, 5, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002020', '카디건', 2, 6, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002019', '아노락 재킷', 2, 7, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002023', '플리스/뽀글이', 2, 8, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002018', '트레이닝 재킷', 2, 9, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002004', '스타디움 재킷', 2, 10, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002008', '환절기 코트', 2, 11, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002007', '겨울 싱글 코트', 2, 12, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002024', '겨울 더블 코트', 2, 13, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002009', '겨울 기타 코트', 2, 14, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002013', '롱패딩/롱헤비 아우터', 2, 15, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002012', '숏패딩/숏헤비 아우터', 2, 16, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002016', '패딩 베스트', 2, 17, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002021', '베스트', 2, 18, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002014', '사파리/헌팅 재킷', 2, 19, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002006', '나일론/코치  재킷', 2, 20, 'Y', now(), now());
insert into middle_category (d_cat_cd, title, large_category_id, priority, use_yn, created_at, updated_at)
values ('002015', '기타 아우터', 2, 21, 'Y', now(), now());

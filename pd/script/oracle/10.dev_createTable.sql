create table sys_datasource_t(
	id varchar2(30),
	name varchar2(30),
	database_type varchar2(10),
	url varchar2(200),
	username varchar2(30),
	password varchar2(200)
);

create table SYS_MENU_T
(
  parent_id VARCHAR2(30),
  id        VARCHAR2(30),
  cn        VARCHAR2(50),
  en        VARCHAR2(50),
  index_id  VARCHAR2(30),
  url       VARCHAR2(200),
  is_active VARCHAR2(1) default 'Y',
  detail    VARCHAR2(100)
);

create table app_datastage_t(
	id varchar2(30),
	name varchar2(30),
	detail varchar2(1000),
	from_ds varchar2(30),
	from_sql varchar2(1000),
	to_ds varchar2(30),
	to_sql varchar2(1000)
);

create table dev_request_t(
	id varchar2(30),
	name varchar2(30)
);

create table APP_PERSON_INFO_T
(
  id          VARCHAR2(30) not null,
  name        VARCHAR2(30) not null,
  sex         VARCHAR2(10),
  birthday    DATE,
  description VARCHAR2(300)
);

create table APP_PERSON_T
(
  id          VARCHAR2(30),
  name        VARCHAR2(30),
  sex         VARCHAR2(10),
  birthday    DATE,
  father_id   VARCHAR2(30),
  mother_id   VARCHAR2(30),
  description VARCHAR2(300)
);
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
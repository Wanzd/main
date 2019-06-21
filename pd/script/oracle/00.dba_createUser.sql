-- 创建临时用户
CREATE USER dev IDENTIFIED BY dev;

-- 授权
GRANT CREATE SESSION TO dev;

CREATE TABLESPACE dev_tableSpace DATAFILE 'dev_tableSpace0.dat' SIZE 10M AUTOEXTEND ON;
CREATE TEMPORARY TABLESPACE dev_tableSpace_temp TEMPFILE 'dev_tableSpace_temp0.dat' SIZE 5M AUTOEXTEND ON;

DROP USER dev;
CREATE USER dev IDENTIFIED BY dev
DEFAULT TABLESPACE dev_tableSpace
TEMPORARY TABLESPACE dev_tableSpace_temp;

-- 授权
grant create session to dev;
grant create table to dev;

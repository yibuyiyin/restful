# spring-restful-demo
restful example of Java spring.

# table sql
```sql
create database if not exists demo charset=utf8mb4 collate=utf8mb4_general_ci;
use demo;
create table if not exists demo (
    id int unsigned not null auto_increment,
    name varchar(32) not null comment '名称',
    ctime timestamp default current_timestamp not null comment '创建时间',
    primary key(id)
) engine=innoDB charset=utf8mb4;
```

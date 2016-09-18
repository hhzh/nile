CREATE DATABASE nile;
USE nile;

-- 用户表
CREATE TABLE user(
`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`name` VARCHAR(50) NOT NULL COMMENT '用户名',
`phone` CHAR(11) NOT NULL COMMENT '手机号',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
KEY `idx_user_phone`(`phone`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 图书表
CREATE TABLE book(
`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '图书ID',
`name` VARCHAR(50) NOT NULL COMMENT '书名',
`author` VARCHAR(50) COMMENT '作者',
`publishing_company` VARCHAR(50) NOT NULL COMMENT '出版社',
`price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书表';


insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1000','Tom','13912346780','2016-09-14 17:46:11','2016-09-14 17:46:11');
insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1001','Lily','13912345678','2016-09-14 17:47:06','2016-09-14 17:47:06');



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

-- 作者
CREATE TABLE author(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '作者ID',
  `name` VARCHAR(50) NOT NULL COMMENT '姓名',
  `profile` VARCHAR(200) COMMENT '简介',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='作者表';


-- 图书种类表
CREATE TABLE category(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '图书种类ID',
  `name` VARCHAR(50) NOT NULL COMMENT '图书种类名',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书种类表';

-- 图书表
CREATE TABLE book(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` VARCHAR(50) NOT NULL COMMENT '书名',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `publisher` VARCHAR(30) NOT NULL COMMENT '出版社',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 图书作者中间表
CREATE TABLE book_author (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `book_id` BIGINT NOT NULL COMMENT '图书id',
  `author_id` BIGINT NOT NULL COMMENT '作者id',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书作者表';

-- 图书种类中间表
CREATE TABLE book_category (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `book_id` BIGINT NOT NULL COMMENT '图书id',
  `category_id` BIGINT NOT NULL COMMENT '图书种类id',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书种类中间表';

-- 订单表
CREATE TABLE order (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `name` VARCHAR(50) NOT NULL COMMENT '订单名',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `status` VARCHAR(20) NOT NULL COMMENT '订单状态',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单表';


insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1000','Tom','13912346780','2016-09-14 17:46:11','2016-09-14 17:46:11');
insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1001','Lily','13912345678','2016-09-14 17:47:06','2016-09-14 17:47:06');

INSERT INTO `book` VALUES (1,'深入理解java虚拟机',86.50,'机械工业出版社'),(2,'疯狂workflow讲义',73.00,'电子工业出版社'),(3,'三国演义',56.00,'机械工业出版社'),(4,'三国演义',56.00,'清华大学出版社');

INSERT INTO `author` VALUES (1,'周志明','程序猿'),(2,'杨恩雄','程序员'),(3,'Tony','外国人'),(4,'罗贯中','古代人');

INSERT INTO `category` VALUES (1,'计算机网络'),(2,'文学'),(3,'小说');

INSERT INTO book_author (id,book_id,author_id) VALUES (1,1,1),(2,2,2),(3,3,4),(4,4,4);

INSERT INTO book_category (id,book_id,category_id) VALUES (1,1,1),(2,2,1),(3,3,2),(4,3,3),(5,4,2),(6,4,3);

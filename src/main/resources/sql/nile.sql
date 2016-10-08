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
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='作者表';

-- 出版社表
CREATE TABLE publisher(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '出版社ID',
  `name` VARCHAR(50) NOT NULL COMMENT '出版社名',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='出版社表';

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
  `author_id` BIGINT COMMENT '作者ID',
  `publisher_id` BIGINT NOT NULL COMMENT '出版社ID',
  `category_id` BIGINT NOT NULL COMMENT '图书种类ID',
PRIMARY KEY (`id`),
CONSTRAINT `fk_book_author` FOREIGN KEY (`author_id`) REFERENCES `author`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_book_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_book_category` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 订单表
CREATE TABLE order(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `name` VARCHAR(50) NOT NULL COMMENT '订单名',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `status` VARCHAR(10) NOT NULL COMMENT '订单状态',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单表';


insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1000','Tom','13912346780','2016-09-14 17:46:11','2016-09-14 17:46:11');
insert into `user` (`id`, `name`, `phone`, `create_time`, `update_time`) values('1001','Lily','13912345678','2016-09-14 17:47:06','2016-09-14 17:47:06');

INSERT INTO `author` VALUES (1,'周志明'),(2,'杨恩雄'),(3,'Tony'),(4,'罗贯中');

INSERT INTO `category` VALUES (1,'计算机网络'),(2,'文学'),(3,'小说');

INSERT INTO `publisher` VALUES (1,'机械工业出版社'),(2,'电子工业出版社'),(3,'清华大学出版社');

INSERT INTO `book` VALUES (1,'深入理解java虚拟机',86.50,1,1,1),(2,'疯狂workflow讲义',73.00,2,1,1),(3,'三国演义',56.00,4,3,2),(4,'三国演义',56.00,4,3,3);



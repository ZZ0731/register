####################
--	用户
####################
-- ----------------------------
-- Table structure for zz_user
-- ----------------------------
DROP TABLE IF EXISTS `zz_user`;
CREATE TABLE `zz_user` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	`code` varchar(20) COMMENT '账号',
	`name` varchar(255) COMMENT '用户名称',	
	`password` 	varchar(32) COMMENT '密码',	
	`age` int(100) COMMENT '年龄',
	`create_date` date COMMENT '创建日期',	
	`modify_date` date COMMENT '修改日期',	
	`sex` varchar(2) COMMENT '性别',
	`address` varchar(100) COMMENT '地址'	,	
	PRIMARY KEY (`id`)
)  CHARSET=utf8;
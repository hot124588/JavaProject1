CREATE TABLE user_info (
	user_id INT PRIMARY KEY COMMENT '用户ID',
	username VARCHAR(50) NOT NULL COMMENT '用户名',
	password_hash VARCHAR(255) NOT NULL COMMENT '密码哈希',
	email VARCHAR(100) NOT NULL COMMENT '邮箱',
	create_by INT COMMENT '创建人',
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '用户信息表';
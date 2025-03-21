CREATE TABLE error_handling (
	error_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '错误ID',
	user_id INT COMMENT '用户ID',
	error_code VARCHAR(50) NOT NULL COMMENT '错误代码',
	error_message TEXT NOT NULL COMMENT '错误信息',
	error_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '错误发生时间',
	create_by INT COMMENT '创建人',
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '错误处理信息表';
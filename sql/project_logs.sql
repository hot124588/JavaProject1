CREATE TABLE project_logs (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	log_level VARCHAR(50) NOT NULL COMMENT '日志级别',
	log_message TEXT NOT NULL COMMENT '日志信息',
	log_time DATETIME NOT NULL COMMENT '日志时间',
	module_name VARCHAR(255) COMMENT '模块名称',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目日志信息表';
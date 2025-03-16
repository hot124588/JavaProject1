CREATE TABLE project_configurations (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	config_key VARCHAR(255) NOT NULL COMMENT '配置项键',
	config_value VARCHAR(255) NOT NULL COMMENT '配置项值',
	description VARCHAR(255) COMMENT '配置项描述',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目配置信息表';
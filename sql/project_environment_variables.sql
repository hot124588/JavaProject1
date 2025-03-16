CREATE TABLE project_environment_variables (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	variable_name VARCHAR(255) NOT NULL COMMENT '环境变量名称',
	variable_value VARCHAR(255) NOT NULL COMMENT '环境变量值',
	environment_type VARCHAR(50) NOT NULL COMMENT '环境类型，如开发、测试、生产',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目环境变量配置表';
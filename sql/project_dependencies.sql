CREATE TABLE project_dependencies (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	dependency_name VARCHAR(255) NOT NULL COMMENT '依赖库名称',
	version VARCHAR(50) NOT NULL COMMENT '依赖库版本',
	status VARCHAR(50) NOT NULL COMMENT '依赖库状态',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目依赖库信息表';
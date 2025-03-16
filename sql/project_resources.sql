CREATE TABLE project_resources (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	resource_name VARCHAR(255) NOT NULL COMMENT '资源名称',
	resource_type VARCHAR(50) NOT NULL COMMENT '资源类型',
	allocation_status VARCHAR(50) NOT NULL COMMENT '资源分配状态',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目资源信息表';
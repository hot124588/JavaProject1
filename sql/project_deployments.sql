CREATE TABLE project_deployments (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	deployment_id VARCHAR(255) NOT NULL COMMENT '部署唯一标识',
	server_environment VARCHAR(255) NOT NULL COMMENT '服务器环境',
	deployment_time DATETIME NOT NULL COMMENT '部署时间',
	status VARCHAR(50) NOT NULL COMMENT '部署状态',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目部署信息表';
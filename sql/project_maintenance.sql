CREATE TABLE project_maintenance (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	maintenance_id VARCHAR(255) NOT NULL COMMENT '维护唯一标识',
	action_type VARCHAR(50) NOT NULL COMMENT '维护操作类型，如升级、回滚、备份',
	action_time DATETIME NOT NULL COMMENT '维护操作时间',
	status VARCHAR(50) NOT NULL COMMENT '维护操作状态',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目维护信息表';
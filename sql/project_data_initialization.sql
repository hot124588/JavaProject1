CREATE TABLE project_data_initialization (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	initialization_id VARCHAR(255) NOT NULL COMMENT '初始化唯一标识',
	data_info TEXT NOT NULL COMMENT '初始化数据信息',
	initialization_time DATETIME NOT NULL COMMENT '初始化时间',
	status VARCHAR(50) NOT NULL COMMENT '初始化状态',
	create_by VARCHAR(50) COMMENT '创建人',
	create_time DATETIME COMMENT '创建时间',
	update_by VARCHAR(50) COMMENT '修改人',
	update_time DATETIME COMMENT '修改时间'
) COMMENT '项目数据初始化信息表';
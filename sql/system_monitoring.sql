CREATE TABLE system_monitoring (
	monitor_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '监控ID',
	response_time DECIMAL(5, 2) COMMENT '响应时间',
	memory_usage DECIMAL(5, 2) COMMENT '内存使用情况',
	cpu_usage DECIMAL(5, 2) COMMENT 'CPU使用情况',
	monitor_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '监控时间',
	create_by INT COMMENT '创建人',
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '系统监控信息表';
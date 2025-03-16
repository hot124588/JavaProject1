package com.feisuanyz.service;

import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

/**
 * 启动管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface StartService {

    /**
     * 配置环境变量: 根据environmentType从project_environment_variables表中获取已有的环境变量，
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    Boolean configureVariable(EnvironmentVariableDTO environmentVariableDTO);

    /**
     * 加载配置文件: 根据environmentType和fileName从project_config_files表中读取配置文件内容
     *
     * @param configFileQuery 配置文件查询对象
     * @return
     */
    String loadConfigFile(ConfigFileQuery configFileQuery);

    /**
     * 初始化应用上下文: 根据environmentType从application_context表中获取已有的应用上下文，
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    Boolean initializeContext(ApplicationContextDTO applicationContextDTO);

    /**
     * 权限校验: 校验用户是否拥有访问指定资源的权限
     *
     * @param userId
     * @param resourceName
     * @return
     */
    Boolean validatePermission(Long userId, String resourceName);

    /**
     * 数据源连接安全性检查: 检查当前配置的数据源连接安全性
     *
     * @return
     */
    Boolean checkDatasourceSecurity();
}

package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ConfigFileDO;
import com.feisuanyz.pojo.domain.EnvironmentVariableDO;
import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.ConfigFileDTO;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import com.feisuanyz.pojo.query.EnvironmentVariableQuery;
import java.lang.Boolean;

/**
 * 模块名称:环境适应管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface EnvironmentService {

    /**
     * 接口名称:获取环境变量配置
     *
     * @param environmentVariableQuery 接口名称:获取环境变量配置
     * @return
     */
    PageResult<EnvironmentVariableDO> getEnvironmentVariables1(EnvironmentVariableQuery environmentVariableQuery);

    /**
     * 接口名称:添加环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    Boolean addEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO);

    /**
     * 接口名称:更新环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    Boolean updateEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO);

    /**
     * 接口名称:删除环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    Boolean deleteEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO);

    /**
     * 接口名称:获取配置文件信息
     *
     * @param configFileQuery 配置文件查询对象
     * @return
     */
    PageResult<ConfigFileDO> getConfigFiles2(ConfigFileQuery configFileQuery);

    /**
     * 接口名称:添加配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    Boolean addConfigFile(ConfigFileDTO configFileDTO);

    /**
     * 接口名称:更新配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    Boolean updateConfigFile(ConfigFileDTO configFileDTO);

    /**
     * 接口名称:删除配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    Boolean deleteConfigFile(ConfigFileDTO configFileDTO);

    /**
     * 接口名称:获取应用上下文信息
     *
     * @param applicationContextQuery 应用上下文信息查询条件
     * @return
     */
    PageResult<ApplicationContextDO> getApplicationContexts(ApplicationContextQuery applicationContextQuery);

    /**
     * 接口名称:添加应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    Boolean addApplicationContext(ApplicationContextDTO applicationContextDTO);

    /**
     * 接口名称:更新应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    Boolean updateApplicationContext(ApplicationContextDTO applicationContextDTO);

    /**
     * 接口名称:删除应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    Boolean deleteApplicationContext(ApplicationContextDTO applicationContextDTO);
}

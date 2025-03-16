package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ProjectConfigFilesDO;
import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.domain.ProjectDependenciesDO;
import com.feisuanyz.pojo.domain.ProjectDeploymentsDO;
import com.feisuanyz.pojo.domain.ProjectEnvironmentVariablesDO;
import com.feisuanyz.pojo.domain.ProjectLogsDO;
import com.feisuanyz.pojo.domain.ProjectMaintenanceDO;
import com.feisuanyz.pojo.domain.ProjectResourcesDO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFilesQuery;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.pojo.query.DependenciesQuery;
import com.feisuanyz.pojo.query.DeploymentsQuery;
import com.feisuanyz.pojo.query.EnvironmentVariablesQuery;
import com.feisuanyz.pojo.query.LogsQuery;
import com.feisuanyz.pojo.query.MaintenanceQuery;
import com.feisuanyz.pojo.query.ResourcesQuery;

/**
 * PerformanceOptimizationService
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface PerformanceOptimizationService {

    /**
     * environment-variables
     *
     * @param query 项目环境变量查询条件
     * @return
     */
    PageResult<ProjectEnvironmentVariablesDO> getEnvironmentVariables(EnvironmentVariablesQuery query);

    /**
     * config-files
     *
     * @param query 配置文件信息查询条件
     * @return
     */
    PageResult<ProjectConfigFilesDO> getConfigFiles(ConfigFilesQuery query);

    /**
     * dependencies
     *
     * @param query 项目依赖库查询条件
     * @return
     */
    PageResult<ProjectDependenciesDO> getDependencies(DependenciesQuery query);

    /**
     * application-context
     *
     * @param query 应用上下文信息查询条件
     * @return  应用上下文实体对象
     */
    ApplicationContextDO getApplicationContext(ApplicationContextQuery query);

    /**
     * logs
     *
     * @param query 日志信息查询条件
     * @return
     */
    PageResult<ProjectLogsDO> getLogs(LogsQuery query);

    /**
     * resources
     *
     * @param query 项目资源查询条件
     * @return
     */
    PageResult<ProjectResourcesDO> getResources(ResourcesQuery query);

    /**
     * deployments
     *
     * @param query 部署信息查询条件
     * @return
     */
    PageResult<ProjectDeploymentsDO> getDeployments(DeploymentsQuery query);

    /**
     * maintenance
     *
     * @param query 维护信息查询条件
     * @return
     */
    PageResult<ProjectMaintenanceDO> getMaintenance(MaintenanceQuery query);

    /**
     * data-initialization
     *
     * @param query 数据初始化信息查询条件
     * @return
     */
    PageResult<ProjectDataInitializationDO> getDataInitialization(DataInitializationQuery query);
}

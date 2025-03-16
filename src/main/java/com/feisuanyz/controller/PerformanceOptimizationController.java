package com.feisuanyz.controller;

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
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFilesQuery;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.pojo.query.DependenciesQuery;
import com.feisuanyz.pojo.query.DeploymentsQuery;
import com.feisuanyz.pojo.query.EnvironmentVariablesQuery;
import com.feisuanyz.pojo.query.LogsQuery;
import com.feisuanyz.pojo.query.MaintenanceQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.ResourcesQuery;
import com.feisuanyz.service.PerformanceOptimizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * PerformanceOptimizationController
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "PerformanceOptimizationController")
@RequestMapping("performance-optimization")
@RestController
public class PerformanceOptimizationController {

    @Autowired
    private PerformanceOptimizationService performanceOptimizationService;

    /**
     * environment-variables
     *
     * @param query 项目环境变量查询条件
     * @return
     */
    @RequestMapping(value = "/environment-variables", method = RequestMethod.GET)
    @Operation(summary = "environment-variables")
    public RestResult<PageResult<ProjectEnvironmentVariablesDO>> getEnvironmentVariables(@Validated(QueryGroup.class) EnvironmentVariablesQuery query) {
        PageResult<ProjectEnvironmentVariablesDO> result = performanceOptimizationService.getEnvironmentVariables(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * config-files
     *
     * @param query 配置文件信息查询条件
     * @return
     */
    @RequestMapping(value = "/config-files", method = RequestMethod.GET)
    @Operation(summary = "config-files")
    public RestResult<PageResult<ProjectConfigFilesDO>> getConfigFiles(@Validated(QueryGroup.class) ConfigFilesQuery query) {
        PageResult<ProjectConfigFilesDO> result = performanceOptimizationService.getConfigFiles(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * dependencies
     *
     * @param query 项目依赖库查询条件
     * @return
     */
    @RequestMapping(value = "/dependencies", method = RequestMethod.GET)
    @Operation(summary = "dependencies")
    public RestResult<PageResult<ProjectDependenciesDO>> getDependencies(@Validated(QueryGroup.class) DependenciesQuery query) {
        PageResult<ProjectDependenciesDO> result = performanceOptimizationService.getDependencies(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * application-context
     *
     * @param query 应用上下文信息查询条件
     * @return
     */
    @RequestMapping(value = "/application-context", method = RequestMethod.GET)
    @Operation(summary = "application-context")
    public RestResult<ApplicationContextDO> getApplicationContext(@Validated(QueryGroup.class) ApplicationContextQuery query) {
        ApplicationContextDO result = performanceOptimizationService.getApplicationContext(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * logs
     *
     * @param query 日志信息查询条件
     * @return
     */
    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    @Operation(summary = "logs")
    public RestResult<PageResult<ProjectLogsDO>> getLogs(@Validated(QueryGroup.class) LogsQuery query) {
        PageResult<ProjectLogsDO> result = performanceOptimizationService.getLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * resources
     *
     * @param query 项目资源查询条件
     * @return
     */
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @Operation(summary = "resources")
    public RestResult<PageResult<ProjectResourcesDO>> getResources(@Validated(QueryGroup.class) ResourcesQuery query) {
        PageResult<ProjectResourcesDO> result = performanceOptimizationService.getResources(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * deployments
     *
     * @param query 部署信息查询条件
     * @return
     */
    @RequestMapping(value = "/deployments", method = RequestMethod.GET)
    @Operation(summary = "deployments")
    public RestResult<PageResult<ProjectDeploymentsDO>> getDeployments(@Validated(QueryGroup.class) DeploymentsQuery query) {
        PageResult<ProjectDeploymentsDO> result = performanceOptimizationService.getDeployments(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * maintenance
     *
     * @param query 维护信息查询条件
     * @return
     */
    @RequestMapping(value = "/maintenance", method = RequestMethod.GET)
    @Operation(summary = "maintenance")
    public RestResult<PageResult<ProjectMaintenanceDO>> getMaintenance(@Validated(QueryGroup.class) MaintenanceQuery query) {
        PageResult<ProjectMaintenanceDO> result = performanceOptimizationService.getMaintenance(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * data-initialization
     *
     * @param query 数据初始化信息查询条件
     * @return
     */
    @RequestMapping(value = "/data-initialization", method = RequestMethod.GET)
    @Operation(summary = "data-initialization")
    public RestResult<PageResult<ProjectDataInitializationDO>> getDataInitialization(@Validated(QueryGroup.class) DataInitializationQuery query) {
        PageResult<ProjectDataInitializationDO> result = performanceOptimizationService.getDataInitialization(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

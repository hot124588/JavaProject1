package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ProjectConfigFilesDO;
import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.domain.ProjectDependenciesDO;
import com.feisuanyz.pojo.domain.ProjectDeploymentsDO;
import com.feisuanyz.pojo.domain.ProjectLogsDO;
import com.feisuanyz.pojo.domain.ProjectMaintenanceDO;
import com.feisuanyz.pojo.domain.ProjectResourcesDO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFilesQuery;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.pojo.query.DeploymentsQuery;
import com.feisuanyz.pojo.query.LogsQuery;
import com.feisuanyz.pojo.query.MaintenanceQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * 监控管理:监控管理模块的控制器
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "监控管理:监控管理模块的控制器")
@RequestMapping("monitor")
@RestController
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    /**
     * 获取应用运行状态:根据环境类型获取应用上下文信息
     *
     * @param applicationContextQuery 应用上下文信息查询条件
     * @return
     */
    @RequestMapping(value = "/application-context", method = RequestMethod.GET)
    @Operation(summary = "获取应用运行状态:根据环境类型获取应用上下文信息")
    public RestResult<ApplicationContextDO> getApplicationContext1(@Validated(QueryGroup.class) ApplicationContextQuery applicationContextQuery) {
        ApplicationContextDO result = monitorService.getApplicationContext1(applicationContextQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取配置文件信息:根据环境类型获取配置文件信息
     *
     * @param configFilesQuery 配置文件信息查询条件
     * @return
     */
    @RequestMapping(value = "/config-files", method = RequestMethod.GET)
    @Operation(summary = "获取配置文件信息:根据环境类型获取配置文件信息")
    public RestResult<List<ProjectConfigFilesDO>> getConfigFiles1(@Validated(QueryGroup.class) ConfigFilesQuery configFilesQuery) {
        List<ProjectConfigFilesDO> result = monitorService.getConfigFiles1(configFilesQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取依赖库信息:获取所有依赖库信息
     *
     * @return
     */
    @RequestMapping(value = "/dependencies", method = RequestMethod.GET)
    @Operation(summary = "获取依赖库信息:获取所有依赖库信息")
    public RestResult<List<ProjectDependenciesDO>> getDependencies1() {
        List<ProjectDependenciesDO> result = monitorService.getDependencies1();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取日志信息:根据条件获取日志信息
     *
     * @param logsQuery 日志信息查询条件
     * @return
     */
    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    @Operation(summary = "获取日志信息:根据条件获取日志信息")
    public RestResult<List<ProjectLogsDO>> getLogs1(@Validated(QueryGroup.class) LogsQuery logsQuery) {
        List<ProjectLogsDO> result = monitorService.getLogs1(logsQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取资源信息:获取所有资源信息
     *
     * @return
     */
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @Operation(summary = "获取资源信息:获取所有资源信息")
    public RestResult<List<ProjectResourcesDO>> getResources1() {
        List<ProjectResourcesDO> result = monitorService.getResources1();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取部署信息:根据条件获取部署信息
     *
     * @param deploymentsQuery 部署信息查询条件
     * @return
     */
    @RequestMapping(value = "/deployments", method = RequestMethod.GET)
    @Operation(summary = "获取部署信息:根据条件获取部署信息")
    public RestResult<List<ProjectDeploymentsDO>> getDeployments1(@Validated(QueryGroup.class) DeploymentsQuery deploymentsQuery) {
        List<ProjectDeploymentsDO> result = monitorService.getDeployments1(deploymentsQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取维护信息:根据条件获取维护信息
     *
     * @param maintenanceQuery 维护信息查询条件
     * @return
     */
    @RequestMapping(value = "/maintenance", method = RequestMethod.GET)
    @Operation(summary = "获取维护信息:根据条件获取维护信息")
    public RestResult<List<ProjectMaintenanceDO>> getMaintenance1(@Validated(QueryGroup.class) MaintenanceQuery maintenanceQuery) {
        List<ProjectMaintenanceDO> result = monitorService.getMaintenance1(maintenanceQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取数据初始化信息:根据条件获取数据初始化信息
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return
     */
    @RequestMapping(value = "/data-initialization", method = RequestMethod.GET)
    @Operation(summary = "获取数据初始化信息:根据条件获取数据初始化信息")
    public RestResult<List<ProjectDataInitializationDO>> getDataInitialization1(@Validated(QueryGroup.class) DataInitializationQuery dataInitializationQuery) {
        List<ProjectDataInitializationDO> result = monitorService.getDataInitialization1(dataInitializationQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取实时运行数据:获取应用的实时运行状态数据
     *
     * @return
     */
    @RequestMapping(value = "/real-time-data", method = RequestMethod.GET)
    @Operation(summary = "获取实时运行数据:获取应用的实时运行状态数据")
    public RestResult<String> getRealTimeData() {
        String result = monitorService.getRealTimeData();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

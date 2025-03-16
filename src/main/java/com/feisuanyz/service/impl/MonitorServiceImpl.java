package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ApplicationContextMapper;
import com.feisuanyz.dao.ProjectConfigFilesMapper;
import com.feisuanyz.dao.ProjectDataInitializationMapper;
import com.feisuanyz.dao.ProjectDependenciesMapper;
import com.feisuanyz.dao.ProjectDeploymentsMapper;
import com.feisuanyz.dao.ProjectLogsMapper;
import com.feisuanyz.dao.ProjectMaintenanceMapper;
import com.feisuanyz.dao.ProjectResourcesMapper;
import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ProjectConfigFilesDO;
import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.domain.ProjectDependenciesDO;
import com.feisuanyz.pojo.domain.ProjectDeploymentsDO;
import com.feisuanyz.pojo.domain.ProjectLogsDO;
import com.feisuanyz.pojo.domain.ProjectMaintenanceDO;
import com.feisuanyz.pojo.domain.ProjectResourcesDO;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFilesQuery;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.pojo.query.DeploymentsQuery;
import com.feisuanyz.pojo.query.LogsQuery;
import com.feisuanyz.pojo.query.MaintenanceQuery;
import com.feisuanyz.service.MonitorService;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.io.File;
import lombok.Data;

/**
 * 监控管理:监控管理模块的控制器的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private ProjectConfigFilesMapper projectConfigFilesMapper;

    @Autowired
    private ProjectResourcesMapper projectResourcesMapper;

    @Autowired
    private ProjectLogsMapper projectLogsMapper;

    @Autowired
    private ProjectMaintenanceMapper projectMaintenanceMapper;

    @Autowired
    private ApplicationContextMapper applicationContextMapper;

    @Autowired
    private ProjectDeploymentsMapper projectDeploymentsMapper;

    @Autowired
    private ProjectDependenciesMapper projectDependenciesMapper;

    @Autowired
    private ProjectDataInitializationMapper projectDataInitializationMapper;

    @Override
    public ApplicationContextDO getApplicationContext1(ApplicationContextQuery applicationContextQuery) {
        QueryWrapper<ApplicationContextDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("environment_type", applicationContextQuery.getEnvironmentType());
        ApplicationContextDO applicationContextDO = applicationContextMapper.selectOne(queryWrapper);
        return applicationContextDO;
    }

    @Override
    public List<ProjectConfigFilesDO> getConfigFiles1(ConfigFilesQuery configFilesQuery) {
        QueryWrapper<ProjectConfigFilesDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("environment_type", configFilesQuery.getEnvironmentType());
        List<ProjectConfigFilesDO> projectConfigFilesDOS = projectConfigFilesMapper.selectList(queryWrapper);
        return projectConfigFilesDOS;
    }

    @Override
    public List<ProjectDependenciesDO> getDependencies1() {
        List<ProjectDependenciesDO> projectDependenciesDOS = projectDependenciesMapper.selectList(Wrappers.emptyWrapper());
        return projectDependenciesDOS;
    }

    @Override
    public List<ProjectLogsDO> getLogs1(LogsQuery logsQuery) {
        QueryWrapper<ProjectLogsDO> queryWrapper = Wrappers.query();
        if (logsQuery.getLogLevel() != null && !logsQuery.getLogLevel().isEmpty()) {
            queryWrapper.eq("log_level", logsQuery.getLogLevel());
        }
        if (logsQuery.getModuleName() != null && !logsQuery.getModuleName().isEmpty()) {
            queryWrapper.eq("module_name", logsQuery.getModuleName());
        }
        if (logsQuery.getStartTime() != null) {
            queryWrapper.ge("log_time", logsQuery.getStartTime());
        }
        if (logsQuery.getEndTime() != null) {
            queryWrapper.le("log_time", logsQuery.getEndTime());
        }
        List<ProjectLogsDO> projectLogsDOS = projectLogsMapper.selectList(queryWrapper);
        return projectLogsDOS;
    }

    @Override
    public List<ProjectResourcesDO> getResources1() {
        List<ProjectResourcesDO> projectResourcesDOS = projectResourcesMapper.selectList(Wrappers.emptyWrapper());
        return projectResourcesDOS;
    }

    @Override
    public List<ProjectDeploymentsDO> getDeployments1(DeploymentsQuery deploymentsQuery) {
        QueryWrapper<ProjectDeploymentsDO> queryWrapper = Wrappers.query();
        if (deploymentsQuery.getServerEnvironment() != null && !deploymentsQuery.getServerEnvironment().isEmpty()) {
            queryWrapper.eq("server_environment", deploymentsQuery.getServerEnvironment());
        }
        if (deploymentsQuery.getStartTime() != null) {
            queryWrapper.ge("deployment_time", deploymentsQuery.getStartTime());
        }
        if (deploymentsQuery.getEndTime() != null) {
            queryWrapper.le("deployment_time", deploymentsQuery.getEndTime());
        }
        List<ProjectDeploymentsDO> projectDeploymentsDOS = projectDeploymentsMapper.selectList(queryWrapper);
        return projectDeploymentsDOS;
    }

    @Override
    public List<ProjectMaintenanceDO> getMaintenance1(MaintenanceQuery maintenanceQuery) {
        QueryWrapper<ProjectMaintenanceDO> queryWrapper = Wrappers.query();
        if (maintenanceQuery.getActionType() != null && !maintenanceQuery.getActionType().isEmpty()) {
            queryWrapper.eq("action_type", maintenanceQuery.getActionType());
        }
        if (maintenanceQuery.getStartTime() != null) {
            queryWrapper.ge("action_time", maintenanceQuery.getStartTime());
        }
        if (maintenanceQuery.getEndTime() != null) {
            queryWrapper.le("action_time", maintenanceQuery.getEndTime());
        }
        List<ProjectMaintenanceDO> projectMaintenanceDOS = projectMaintenanceMapper.selectList(queryWrapper);
        return projectMaintenanceDOS;
    }

    @Override
    public List<ProjectDataInitializationDO> getDataInitialization1(DataInitializationQuery dataInitializationQuery) {
        QueryWrapper<ProjectDataInitializationDO> queryWrapper = Wrappers.query();
        if (dataInitializationQuery.getStartTime() != null) {
            queryWrapper.ge("initialization_time", dataInitializationQuery.getStartTime());
        }
        if (dataInitializationQuery.getEndTime() != null) {
            queryWrapper.le("initialization_time", dataInitializationQuery.getEndTime());
        }
        List<ProjectDataInitializationDO> projectDataInitializationDOS = projectDataInitializationMapper.selectList(queryWrapper);
        return projectDataInitializationDOS;
    }

    @Override
    public String getRealTimeData() {
        // 这里假设实时运行数据可以通过某个方式获取，例如调用某个服务或者查询某个数据库表
        // 实际业务中需要替换为具体的获取逻辑
        String realTimeData = "实时运行状态数据";
        return realTimeData;
    }
}

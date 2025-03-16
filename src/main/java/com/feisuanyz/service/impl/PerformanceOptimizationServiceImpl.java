package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ApplicationContextMapper;
import com.feisuanyz.dao.ProjectConfigFilesMapper;
import com.feisuanyz.dao.ProjectConfigurationsMapper;
import com.feisuanyz.dao.ProjectDataInitializationMapper;
import com.feisuanyz.dao.ProjectDependenciesMapper;
import com.feisuanyz.dao.ProjectDeploymentsMapper;
import com.feisuanyz.dao.ProjectEnvironmentVariablesMapper;
import com.feisuanyz.dao.ProjectLogsMapper;
import com.feisuanyz.dao.ProjectMaintenanceMapper;
import com.feisuanyz.dao.ProjectResourcesMapper;
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
import com.feisuanyz.service.PerformanceOptimizationService;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.File;
import lombok.Data;

/**
 * PerformanceOptimizationServiceImpl
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class PerformanceOptimizationServiceImpl implements PerformanceOptimizationService {

    @Autowired
    private ProjectConfigurationsMapper projectConfigurationsMapper;

    @Autowired
    private ProjectConfigFilesMapper projectConfigFilesMapper;

    @Autowired
    private ProjectResourcesMapper projectResourcesMapper;

    @Autowired
    private ProjectEnvironmentVariablesMapper projectEnvironmentVariablesMapper;

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
    public PageResult<ProjectEnvironmentVariablesDO> getEnvironmentVariables(EnvironmentVariablesQuery query) {
        IPage<ProjectEnvironmentVariablesDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectEnvironmentVariablesDO> wrapper = new QueryWrapper<>();
        wrapper.eq("environment_type", query.getEnvironmentType());
        IPage<ProjectEnvironmentVariablesDO> resultPage = projectEnvironmentVariablesMapper.selectPage(page, wrapper);
        PageResult<ProjectEnvironmentVariablesDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectConfigFilesDO> getConfigFiles(ConfigFilesQuery query) {
        IPage<ProjectConfigFilesDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectConfigFilesDO> wrapper = new QueryWrapper<>();
        wrapper.eq("environment_type", query.getEnvironmentType());
        IPage<ProjectConfigFilesDO> resultPage = projectConfigFilesMapper.selectPage(page, wrapper);
        PageResult<ProjectConfigFilesDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectDependenciesDO> getDependencies(DependenciesQuery query) {
        IPage<ProjectDependenciesDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectDependenciesDO> wrapper = new QueryWrapper<>();
        wrapper.eq("status", query.getStatus());
        IPage<ProjectDependenciesDO> resultPage = projectDependenciesMapper.selectPage(page, wrapper);
        PageResult<ProjectDependenciesDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public ApplicationContextDO getApplicationContext(ApplicationContextQuery query) {
        QueryWrapper<ApplicationContextDO> wrapper = new QueryWrapper<>();
        wrapper.eq("environment_type", query.getEnvironmentType());
        ApplicationContextDO applicationContextDO = applicationContextMapper.selectOne(wrapper);
        return applicationContextDO;
    }

    @Override
    public PageResult<ProjectLogsDO> getLogs(LogsQuery query) {
        IPage<ProjectLogsDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectLogsDO> wrapper = new QueryWrapper<>();
        wrapper.eq("log_level", query.getLogLevel());
        wrapper.eq("module_name", query.getModuleName());
        IPage<ProjectLogsDO> resultPage = projectLogsMapper.selectPage(page, wrapper);
        PageResult<ProjectLogsDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectResourcesDO> getResources(ResourcesQuery query) {
        IPage<ProjectResourcesDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectResourcesDO> wrapper = new QueryWrapper<>();
        wrapper.eq("resource_type", query.getResourceType());
        wrapper.eq("allocation_status", query.getAllocationStatus());
        IPage<ProjectResourcesDO> resultPage = projectResourcesMapper.selectPage(page, wrapper);
        PageResult<ProjectResourcesDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectDeploymentsDO> getDeployments(DeploymentsQuery query) {
        IPage<ProjectDeploymentsDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectDeploymentsDO> wrapper = new QueryWrapper<>();
        wrapper.eq("server_environment", query.getServerEnvironment());
        wrapper.eq("status", query.getStatus());
        IPage<ProjectDeploymentsDO> resultPage = projectDeploymentsMapper.selectPage(page, wrapper);
        PageResult<ProjectDeploymentsDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectMaintenanceDO> getMaintenance(MaintenanceQuery query) {
        IPage<ProjectMaintenanceDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectMaintenanceDO> wrapper = new QueryWrapper<>();
        wrapper.eq("action_type", query.getActionType());
        wrapper.eq("status", query.getStatus());
        IPage<ProjectMaintenanceDO> resultPage = projectMaintenanceMapper.selectPage(page, wrapper);
        PageResult<ProjectMaintenanceDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }

    @Override
    public PageResult<ProjectDataInitializationDO> getDataInitialization(DataInitializationQuery query) {
        IPage<ProjectDataInitializationDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ProjectDataInitializationDO> wrapper = new QueryWrapper<>();
        wrapper.eq("status", query.getStatus());
        IPage<ProjectDataInitializationDO> resultPage = projectDataInitializationMapper.selectPage(page, wrapper);
        PageResult<ProjectDataInitializationDO> pageResult = new PageResult<>(resultPage);
        return pageResult;
    }
}

package com.feisuanyz.service;

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
import java.lang.String;
import java.util.List;

/**
 * 监控管理:监控管理模块的控制器
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface MonitorService {

    /**
     * 获取应用运行状态:根据环境类型获取应用上下文信息
     *
     * @param applicationContextQuery 应用上下文信息查询条件
     * @return  应用上下文实体对象
     */
    ApplicationContextDO getApplicationContext1(ApplicationContextQuery applicationContextQuery);

    /**
     * 获取配置文件信息:根据环境类型获取配置文件信息
     *
     * @param configFilesQuery 配置文件信息查询条件
     * @return
     */
    List<ProjectConfigFilesDO> getConfigFiles1(ConfigFilesQuery configFilesQuery);

    /**
     * 获取依赖库信息:获取所有依赖库信息
     *
     * @return
     */
    List<ProjectDependenciesDO> getDependencies1();

    /**
     * 获取日志信息:根据条件获取日志信息
     *
     * @param logsQuery 日志信息查询条件
     * @return
     */
    List<ProjectLogsDO> getLogs1(LogsQuery logsQuery);

    /**
     * 获取资源信息:获取所有资源信息
     *
     * @return
     */
    List<ProjectResourcesDO> getResources1();

    /**
     * 获取部署信息:根据条件获取部署信息
     *
     * @param deploymentsQuery 部署信息查询条件
     * @return
     */
    List<ProjectDeploymentsDO> getDeployments1(DeploymentsQuery deploymentsQuery);

    /**
     * 获取维护信息:根据条件获取维护信息
     *
     * @param maintenanceQuery 维护信息查询条件
     * @return
     */
    List<ProjectMaintenanceDO> getMaintenance1(MaintenanceQuery maintenanceQuery);

    /**
     * 获取数据初始化信息:根据条件获取数据初始化信息
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return
     */
    List<ProjectDataInitializationDO> getDataInitialization1(DataInitializationQuery dataInitializationQuery);

    /**
     * 获取实时运行数据:获取应用的实时运行状态数据
     *
     * @return
     */
    String getRealTimeData();
}

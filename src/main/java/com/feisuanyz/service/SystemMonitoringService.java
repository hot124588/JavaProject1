package com.feisuanyz.service;

import com.feisuanyz.pojo.dto.SystemMonitoringDTO;
import com.feisuanyz.pojo.query.SystemMonitoringQuery;
import java.lang.Boolean;
import java.lang.Object;

/**
 * 系统监控管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface SystemMonitoringService {

    /**
     * 获取系统监控信息
     *
     * @param systemMonitoringQuery 获取系统监控信息查询对象
     * @return
     */
    Object systemMonitoringInfo(SystemMonitoringQuery systemMonitoringQuery);

    /**
     * 添加系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    Boolean addSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO);

    /**
     * 更新系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    Boolean updateSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO);

    /**
     * 删除系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    Boolean deleteSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO);
}

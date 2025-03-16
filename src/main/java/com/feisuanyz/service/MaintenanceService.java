package com.feisuanyz.service;

import com.feisuanyz.pojo.dto.MaintenanceDTO;
import java.lang.Boolean;

/**
 * 维护管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface MaintenanceService {

    /**
     * upgrade
     *
     * @param maintenanceDTO 维护操作实体类
     * @return
     */
    Boolean upgradeApplication(MaintenanceDTO maintenanceDTO);

    /**
     * backup
     *
     * @param maintenanceDTO 维护操作实体类
     * @return
     */
    Boolean backupApplication(MaintenanceDTO maintenanceDTO);
}

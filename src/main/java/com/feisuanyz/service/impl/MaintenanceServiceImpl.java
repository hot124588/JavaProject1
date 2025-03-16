package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ProjectMaintenanceMapper;
import com.feisuanyz.pojo.dto.MaintenanceDTO;
import com.feisuanyz.service.MaintenanceService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.domain.ProjectMaintenanceDO;
import java.util.Date;

/**
 * 维护管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private ProjectMaintenanceMapper projectMaintenanceMapper;

    @Override
    public Boolean upgradeApplication(MaintenanceDTO maintenanceDTO) {
        QueryWrapper<ProjectMaintenanceDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("maintenance_id", maintenanceDTO.getMaintenanceId());
        queryWrapper.eq("action_type", "upgrade");
        queryWrapper.eq("status", "completed");
        ProjectMaintenanceDO existingRecord = projectMaintenanceMapper.selectOne(queryWrapper);
        if (existingRecord != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProjectMaintenanceDO projectMaintenanceDO = new ProjectMaintenanceDO();
        projectMaintenanceDO.setMaintenanceId(maintenanceDTO.getMaintenanceId());
        projectMaintenanceDO.setActionType("upgrade");
        projectMaintenanceDO.setActionTime(new Date());
        projectMaintenanceDO.setStatus("completed");
        projectMaintenanceDO.setCreateBy("system");
        projectMaintenanceDO.setCreateTime(new Date());
        projectMaintenanceDO.setUpdateBy("system");
        projectMaintenanceDO.setUpdateTime(new Date());
        int result = projectMaintenanceMapper.insert(projectMaintenanceDO);
        return result > 0;
    }

    @Override
    public Boolean backupApplication(MaintenanceDTO maintenanceDTO) {
        QueryWrapper<ProjectMaintenanceDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("maintenance_id", maintenanceDTO.getMaintenanceId());
        queryWrapper.eq("action_type", "backup");
        queryWrapper.eq("status", "completed");
        ProjectMaintenanceDO existingRecord = projectMaintenanceMapper.selectOne(queryWrapper);
        if (existingRecord != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProjectMaintenanceDO projectMaintenanceDO = new ProjectMaintenanceDO();
        projectMaintenanceDO.setMaintenanceId(maintenanceDTO.getMaintenanceId());
        projectMaintenanceDO.setActionType("backup");
        projectMaintenanceDO.setActionTime(new Date());
        projectMaintenanceDO.setStatus("completed");
        projectMaintenanceDO.setCreateBy("system");
        projectMaintenanceDO.setCreateTime(new Date());
        projectMaintenanceDO.setUpdateBy("system");
        projectMaintenanceDO.setUpdateTime(new Date());
        int result = projectMaintenanceMapper.insert(projectMaintenanceDO);
        return result > 0;
    }
}

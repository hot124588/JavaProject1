package com.feisuanyz.service.impl;

import com.feisuanyz.dao.SystemMonitoringMapper;
import com.feisuanyz.pojo.dto.SystemMonitoringDTO;
import com.feisuanyz.pojo.query.SystemMonitoringQuery;
import com.feisuanyz.service.SystemMonitoringService;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.feisuanyz.pojo.domain.SystemMonitoringDO;
import com.feisuanyz.flow.function.javaai.utils.PageResult;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feisuanyz.constant.ResultCodeConstant;

/**
 * 系统监控管理的实现
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Service
public class SystemMonitoringServiceImpl implements SystemMonitoringService {

    @Autowired
    private SystemMonitoringMapper systemMonitoringMapper;

    @Override
    public Object systemMonitoringInfo(SystemMonitoringQuery systemMonitoringQuery) {
        if (systemMonitoringQuery.getMonitorId() != null) {
            SystemMonitoringDO monitoringDO = systemMonitoringMapper.selectById(systemMonitoringQuery.getMonitorId());
            if (monitoringDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            return monitoringDO;
        } else {
            IPage<SystemMonitoringDO> page = new Page<>(systemMonitoringQuery.getPageIndex(), systemMonitoringQuery.getPageSize());
            IPage<SystemMonitoringDO> monitoringPage = systemMonitoringMapper.selectPage(page, Wrappers.emptyWrapper());
            PageResult<SystemMonitoringDO> pageResult = new PageResult<>(monitoringPage.getTotal(), monitoringPage.getRecords());
            return pageResult;
        }
    }

    @Override
    public Boolean addSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO) {
        SystemMonitoringDO monitoringDO = new SystemMonitoringDO();
        monitoringDO.setResponseTime(systemMonitoringDTO.getResponseTime());
        monitoringDO.setMemoryUsage(systemMonitoringDTO.getMemoryUsage());
        monitoringDO.setCpuUsage(systemMonitoringDTO.getCpuUsage());
        int result = systemMonitoringMapper.insert(monitoringDO);
        return result > 0;
    }

    @Override
    public Boolean updateSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO) {
        SystemMonitoringDO monitoringDO = systemMonitoringMapper.selectById(systemMonitoringDTO.getMonitorId());
        if (monitoringDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        monitoringDO.setResponseTime(systemMonitoringDTO.getResponseTime());
        monitoringDO.setMemoryUsage(systemMonitoringDTO.getMemoryUsage());
        monitoringDO.setCpuUsage(systemMonitoringDTO.getCpuUsage());
        int result = systemMonitoringMapper.updateById(monitoringDO);
        return result > 0;
    }

    @Override
    public Boolean deleteSystemMonitoring(SystemMonitoringDTO systemMonitoringDTO) {
        SystemMonitoringDO monitoringDO = systemMonitoringMapper.selectById(systemMonitoringDTO.getMonitorId());
        if (monitoringDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = systemMonitoringMapper.deleteById(systemMonitoringDTO.getMonitorId());
        return result > 0;
    }
}

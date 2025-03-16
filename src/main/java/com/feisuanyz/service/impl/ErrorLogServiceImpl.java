package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ErrorLogMapper;
import com.feisuanyz.pojo.domain.ErrorLogDO;
import com.feisuanyz.pojo.dto.ErrorLogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.ErrorLogQuery;
import com.feisuanyz.service.ErrorLogService;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Date;

/**
 * 错误处理管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class ErrorLogServiceImpl implements ErrorLogService {

    @Autowired
    private ErrorLogMapper errorLogMapper;

    @Override
    public Boolean addErrorLog(ErrorLogDTO errorLogDTO) {
        ErrorLogDO errorLogDO = new ErrorLogDO();
        errorLogDO.setLogLevel(errorLogDTO.getLogLevel());
        errorLogDO.setLogMessage(errorLogDTO.getExceptionMessage());
        errorLogDO.setLogTime(new Date());
        errorLogDO.setModuleName(errorLogDTO.getModuleName());
        errorLogDO.setCreateBy("system");
        errorLogDO.setCreateTime(new Date());
        int result = errorLogMapper.insert(errorLogDO);
        return result > 0;
    }

    @Override
    public PageResult<ErrorLogDO> listErrorLogs(ErrorLogQuery errorLogQuery) {
        QueryWrapper<ErrorLogDO> queryWrapper = Wrappers.query();
        if (errorLogQuery.getLogLevel() != null) {
            queryWrapper.eq("log_level", errorLogQuery.getLogLevel());
        }
        if (errorLogQuery.getModuleName() != null) {
            queryWrapper.eq("module_name", errorLogQuery.getModuleName());
        }
        if (errorLogQuery.getStartTime() != null) {
            queryWrapper.ge("log_time", errorLogQuery.getStartTime());
        }
        if (errorLogQuery.getEndTime() != null) {
            queryWrapper.le("log_time", errorLogQuery.getEndTime());
        }
        IPage<ErrorLogDO> page = new Page<>(errorLogQuery.getPageIndex(), errorLogQuery.getPageSize());
        IPage<ErrorLogDO> errorLogPage = errorLogMapper.selectPage(page, queryWrapper);
        PageResult<ErrorLogDO> pageResult = new PageResult<>(errorLogPage);
        return pageResult;
    }

    @Override
    public Boolean deleteErrorLog(Integer logId) {
        int result = errorLogMapper.deleteById(logId);
        return result > 0;
    }
}

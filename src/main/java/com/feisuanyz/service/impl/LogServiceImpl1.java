package com.feisuanyz.service.impl;

import com.feisuanyz.dao.LogMapper;
import com.feisuanyz.pojo.domain.LogDO;
import com.feisuanyz.pojo.dto.LogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.LogQuery;
import com.feisuanyz.service.LogService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feisuanyz.constant.ResultCodeConstant;

/**
 * 日志管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class LogServiceImpl1 implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Boolean addLog(LogDTO logDTO) {
        LogDO logDO = new LogDO();
        logDO.setLogLevel(logDTO.getLogLevel());
        logDO.setLogMessage(logDTO.getLogMessage());
        logDO.setLogTime(logDTO.getLogTime());
        logDO.setModuleName(logDTO.getModuleName());
        logDO.setCreateBy(logDTO.getCreateBy());
        logDO.setCreateTime(logDTO.getCreateTime());
        logDO.setUpdateBy(logDTO.getUpdateBy());
        logDO.setUpdateTime(logDTO.getUpdateTime());
        int result = logMapper.insert(logDO);
        return result > 0;
    }

    @Override
    public Boolean deleteLog(LogDTO logDTO) {
        LogDO logDO = logMapper.selectById(logDTO.getLogId());
        if (logDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = logMapper.deleteById(logDTO.getLogId());
        return result > 0;
    }

    @Override
    public PageResult<LogDO> queryLogs(LogQuery logQuery) {
        QueryWrapper<LogDO> queryWrapper = new QueryWrapper<>();
        if (logQuery.getLogLevel() != null) {
            queryWrapper.eq("log_level", logQuery.getLogLevel());
        }
        if (logQuery.getModuleName() != null) {
            queryWrapper.eq("module_name", logQuery.getModuleName());
        }
        if (logQuery.getCreateTimeStart() != null) {
            queryWrapper.ge("create_time", logQuery.getCreateTimeStart());
        }
        if (logQuery.getCreateTimeEnd() != null) {
            queryWrapper.le("create_time", logQuery.getCreateTimeEnd());
        }
        IPage<LogDO> page = new Page<>(logQuery.getPageIndex(), logQuery.getPageSize());
        IPage<LogDO> logPage = logMapper.selectPage(page, queryWrapper);
        PageResult<LogDO> pageResult = new PageResult<>(logPage);
        return pageResult;
    }

    @Override
    public Boolean updateLog(LogDTO logDTO) {
        LogDO logDO = logMapper.selectById(logDTO.getLogId());
        if (logDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        logDO.setLogLevel(logDTO.getLogLevel());
        logDO.setLogMessage(logDTO.getLogMessage());
        logDO.setLogTime(logDTO.getLogTime());
        logDO.setModuleName(logDTO.getModuleName());
        logDO.setUpdateBy(logDTO.getUpdateBy());
        logDO.setUpdateTime(logDTO.getUpdateTime());
        int result = logMapper.updateById(logDO);
        return result > 0;
    }
}

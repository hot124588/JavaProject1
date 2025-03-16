package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ErrorHandlingMapper;
import com.feisuanyz.dao.UserActivityLogMapper;
import com.feisuanyz.pojo.domain.ErrorHandlingDO;
import com.feisuanyz.pojo.domain.UserActivityLogDO;
import com.feisuanyz.pojo.dto.ErrorHandlingDTO;
import com.feisuanyz.pojo.dto.UserActivityLogDTO;
import com.feisuanyz.pojo.query.ErrorHandlingQuery;
import com.feisuanyz.pojo.query.UserActivityLogQuery;
import com.feisuanyz.pojo.vo.PageResult;
import com.feisuanyz.service.LogService;
import java.lang.Boolean;
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
 * 日志与错误处理管理的实现
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private ErrorHandlingMapper errorHandlingMapper;

    @Autowired
    private UserActivityLogMapper userActivityLogMapper;

    @Override
    public Boolean recordUserActivity(UserActivityLogDTO logDTO) {
        UserActivityLogDO logDO = new UserActivityLogDO();
        logDO.setUserId(logDTO.getUserId());
        logDO.setActivityDescription(logDTO.getActivityDescription());
        // 假设需要设置活动时间
        logDO.setActivityTime(new Date());
        int result = userActivityLogMapper.insert(logDO);
        return result > 0;
    }

    @Override
    public PageResult<UserActivityLogDO> queryUserActivityLogs(UserActivityLogQuery query) {
        IPage<UserActivityLogDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<UserActivityLogDO> wrapper = Wrappers.query();
        wrapper.eq("user_id", query.getUserId());
        IPage<UserActivityLogDO> userLogPage = userActivityLogMapper.selectPage(page, wrapper);
        PageResult<UserActivityLogDO> pageResult = new PageResult<>(userLogPage.getRecords(), userLogPage.getTotal(), userLogPage.getCurrent(), userLogPage.getSize());
        return pageResult;
    }

    @Override
    public Boolean recordSystemError(ErrorHandlingDTO errorDTO) {
        ErrorHandlingDO errorDO = new ErrorHandlingDO();
        errorDO.setUserId(errorDTO.getUserId());
        errorDO.setErrorCode(errorDTO.getErrorCode());
        errorDO.setErrorMessage(errorDTO.getErrorMessage());
        // 假设需要设置错误发生时间
        errorDO.setErrorTime(new Date());
        int result = errorHandlingMapper.insert(errorDO);
        return result > 0;
    }

    @Override
    public PageResult<ErrorHandlingDO> querySystemErrorLogs(ErrorHandlingQuery query) {
        IPage<ErrorHandlingDO> page = new Page<>(query.getPageIndex(), query.getPageSize());
        QueryWrapper<ErrorHandlingDO> wrapper = Wrappers.query();
        if (query.getUserId() != null) {
            wrapper.eq("user_id", query.getUserId());
        }
        if (query.getErrorCode() != null) {
            wrapper.eq("error_code", query.getErrorCode());
        }
        IPage<ErrorHandlingDO> errorLogPage = errorHandlingMapper.selectPage(page, wrapper);
        PageResult<ErrorHandlingDO> pageResult = new PageResult<>(errorLogPage.getRecords(), errorLogPage.getTotal(), errorLogPage.getCurrent(), errorLogPage.getSize());
        return pageResult;
    }
}

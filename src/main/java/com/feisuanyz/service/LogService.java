package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ErrorHandlingDO;
import com.feisuanyz.pojo.domain.UserActivityLogDO;
import com.feisuanyz.pojo.dto.ErrorHandlingDTO;
import com.feisuanyz.pojo.dto.UserActivityLogDTO;
import com.feisuanyz.pojo.query.ErrorHandlingQuery;
import com.feisuanyz.pojo.query.UserActivityLogQuery;
import com.feisuanyz.pojo.vo.PageResult;
import java.lang.Boolean;

/**
 * 日志与错误处理管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface LogService {

    /**
     * 记录用户活动
     *
     * @param logDTO 用户活动日志入参对象
     * @return
     */
    Boolean recordUserActivity(UserActivityLogDTO logDTO);

    /**
     * 查询用户活动日志
     *
     * @param query 用户活动日志查询对象
     * @return
     */
    PageResult<UserActivityLogDO> queryUserActivityLogs(UserActivityLogQuery query);

    /**
     * 记录系统错误
     *
     * @param errorDTO 系统错误日志入参对象
     * @return
     */
    Boolean recordSystemError(ErrorHandlingDTO errorDTO);

    /**
     * 查询系统错误日志
     *
     * @param query 系统错误日志查询对象
     * @return
     */
    PageResult<ErrorHandlingDO> querySystemErrorLogs(ErrorHandlingQuery query);
}

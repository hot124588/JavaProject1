package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.LogDO;
import com.feisuanyz.pojo.dto.LogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.LogQuery;
import java.lang.Boolean;

/**
 * 日志管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface LogService1 {

    /**
     * 新增日志:记录日志信息到数据库
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    Boolean addLog(LogDTO logDTO);

    /**
     * 删除日志:删除日志信息
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    Boolean deleteLog(LogDTO logDTO);

    /**
     * 查询日志:根据查询条件检索日志信息
     *
     * @param logQuery 查询日志的入参对象
     * @return
     */
    PageResult<LogDO> queryLogs(LogQuery logQuery);

    /**
     * 修改日志:更新日志信息到数据库
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    Boolean updateLog(LogDTO logDTO);
}

package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ErrorLogDO;
import com.feisuanyz.pojo.dto.ErrorLogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.ErrorLogQuery;
import java.lang.Boolean;
import java.lang.Integer;

/**
 * 错误处理管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface ErrorLogService {

    /**
     * add
     *
     * @param errorLogDTO 错误日志DTO
     * @return
     */
    Boolean addErrorLog(ErrorLogDTO errorLogDTO);

    /**
     * list
     *
     * @param errorLogQuery 错误日志查询条件
     * @return
     */
    PageResult<ErrorLogDO> listErrorLogs(ErrorLogQuery errorLogQuery);

    /**
     * delete
     *
     * @param logId
     * @return
     */
    Boolean deleteErrorLog(Integer logId);
}

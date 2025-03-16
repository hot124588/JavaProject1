package com.feisuanyz.controller;

import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.domain.ErrorHandlingDO;
import com.feisuanyz.pojo.domain.UserActivityLogDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.ErrorHandlingDTO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UserActivityLogDTO;
import com.feisuanyz.pojo.query.ErrorHandlingQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.UserActivityLogQuery;
import com.feisuanyz.pojo.vo.PageResult;
import com.feisuanyz.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志与错误处理管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Tag(name = "日志与错误处理管理")
@RequestMapping("log")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 记录用户活动
     *
     * @param logDTO 用户活动日志入参对象
     * @return
     */
    @RequestMapping(value = "/recordActivity", method = RequestMethod.POST)
    @Operation(summary = "记录用户活动")
    @ResponseBody
    public RestResult<Boolean> recordUserActivity(@RequestBody @Validated(CreateGroup.class) UserActivityLogDTO logDTO) {
        Boolean result = logService.recordUserActivity(logDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询用户活动日志
     *
     * @param query 用户活动日志查询对象
     * @return
     */
    @RequestMapping(value = "/activityLogs", method = RequestMethod.GET)
    @Operation(summary = "查询用户活动日志")
    public RestResult<PageResult<UserActivityLogDO>> queryUserActivityLogs(@Validated(QueryGroup.class) UserActivityLogQuery query) {
        PageResult<UserActivityLogDO> result = logService.queryUserActivityLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 记录系统错误
     *
     * @param errorDTO 系统错误日志入参对象
     * @return
     */
    @RequestMapping(value = "/recordError", method = RequestMethod.POST)
    @Operation(summary = "记录系统错误")
    @ResponseBody
    public RestResult<Boolean> recordSystemError(@RequestBody @Validated(CreateGroup.class) ErrorHandlingDTO errorDTO) {
        Boolean result = logService.recordSystemError(errorDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询系统错误日志
     *
     * @param query 系统错误日志查询对象
     * @return
     */
    @RequestMapping(value = "/errorLogs", method = RequestMethod.GET)
    @Operation(summary = "查询系统错误日志")
    public RestResult<PageResult<ErrorHandlingDO>> querySystemErrorLogs(@Validated(QueryGroup.class) ErrorHandlingQuery query) {
        PageResult<ErrorHandlingDO> result = logService.querySystemErrorLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

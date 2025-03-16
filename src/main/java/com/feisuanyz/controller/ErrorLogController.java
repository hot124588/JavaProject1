package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ErrorLogDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.ErrorLogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.query.ErrorLogQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.ErrorLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * 错误处理管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "错误处理管理")
@RequestMapping("error-log")
@RestController
public class ErrorLogController {

    @Autowired
    private ErrorLogService errorLogService;

    /**
     * add
     *
     * @param errorLogDTO 错误日志DTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "add")
    @ResponseBody
    public RestResult<Boolean> addErrorLog(@RequestBody @Validated(CreateGroup.class) ErrorLogDTO errorLogDTO) {
        Boolean result = errorLogService.addErrorLog(errorLogDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * list
     *
     * @param errorLogQuery 错误日志查询条件
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "list")
    public RestResult<PageResult<ErrorLogDO>> listErrorLogs(@Validated(QueryGroup.class) ErrorLogQuery errorLogQuery) {
        PageResult<ErrorLogDO> result = errorLogService.listErrorLogs(errorLogQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * delete
     *
     * @param logId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "delete")
    public RestResult<Boolean> deleteErrorLog(@Validated(DeleteGroup.class) Integer logId) {
        Boolean result = errorLogService.deleteErrorLog(logId);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.LogDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.LogDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.LogQuery;
import com.feisuanyz.pojo.query.QueryGroup;
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
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * 日志管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "日志管理")
@RequestMapping("log")
@RestController
public class LogController1 {

    @Autowired
    private LogService logService;

    /**
     * 新增日志:记录日志信息到数据库
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "新增日志:记录日志信息到数据库")
    @ResponseBody
    public RestResult<Boolean> addLog(@RequestBody @Validated(CreateGroup.class) LogDTO logDTO) {
        Boolean result = logService.addLog(logDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除日志:删除日志信息
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除日志:删除日志信息")
    @ResponseBody
    public RestResult<Boolean> deleteLog(@RequestBody @Validated(DeleteGroup.class) LogDTO logDTO) {
        Boolean result = logService.deleteLog(logDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询日志:根据查询条件检索日志信息
     *
     * @param logQuery 查询日志的入参对象
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @Operation(summary = "查询日志:根据查询条件检索日志信息")
    public RestResult<PageResult<LogDO>> queryLogs(@Validated(QueryGroup.class) LogQuery logQuery) {
        PageResult<LogDO> result = logService.queryLogs(logQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改日志:更新日志信息到数据库
     *
     * @param logDTO 日志信息的入参对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "修改日志:更新日志信息到数据库")
    @ResponseBody
    public RestResult<Boolean> updateLog(@RequestBody @Validated(UpdateGroup.class) LogDTO logDTO) {
        Boolean result = logService.updateLog(logDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

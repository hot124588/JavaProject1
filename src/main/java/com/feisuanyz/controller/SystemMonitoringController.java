package com.feisuanyz.controller;

import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.SystemMonitoringDTO;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.SystemMonitoringQuery;
import com.feisuanyz.service.SystemMonitoringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统监控管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Tag(name = "系统监控管理")
@RequestMapping("system-monitoring")
@RestController
public class SystemMonitoringController {

    @Autowired
    private SystemMonitoringService systemMonitoringService;

    /**
     * 获取系统监控信息
     *
     * @param systemMonitoringQuery 获取系统监控信息查询对象
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "获取系统监控信息")
    public RestResult<Object> systemMonitoringInfo(@Validated(QueryGroup.class) SystemMonitoringQuery systemMonitoringQuery) {
        Object result = systemMonitoringService.systemMonitoringInfo(systemMonitoringQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 添加系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "添加系统监控信息")
    @ResponseBody
    public RestResult<Boolean> addSystemMonitoring(@RequestBody @Validated(CreateGroup.class) SystemMonitoringDTO systemMonitoringDTO) {
        Boolean result = systemMonitoringService.addSystemMonitoring(systemMonitoringDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 更新系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "更新系统监控信息")
    @ResponseBody
    public RestResult<Boolean> updateSystemMonitoring(@RequestBody @Validated(UpdateGroup.class) SystemMonitoringDTO systemMonitoringDTO) {
        Boolean result = systemMonitoringService.updateSystemMonitoring(systemMonitoringDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除系统监控信息
     *
     * @param systemMonitoringDTO 系统监控信息添加/更新/删除对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除系统监控信息")
    @ResponseBody
    public RestResult<Boolean> deleteSystemMonitoring(@RequestBody @Validated(DeleteGroup.class) SystemMonitoringDTO systemMonitoringDTO) {
        Boolean result = systemMonitoringService.deleteSystemMonitoring(systemMonitoringDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

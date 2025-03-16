package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ConfigFileDO;
import com.feisuanyz.pojo.domain.EnvironmentVariableDO;
import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.ConfigFileDTO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import com.feisuanyz.pojo.query.EnvironmentVariableQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.EnvironmentService;
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
 * 模块名称:环境适应管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "模块名称:环境适应管理")
@RequestMapping("environment")
@RestController
public class EnvironmentController {

    @Autowired
    private EnvironmentService environmentService;

    /**
     * 接口名称:获取环境变量配置
     *
     * @param environmentVariableQuery 接口名称:获取环境变量配置
     * @return
     */
    @RequestMapping(value = "/variables", method = RequestMethod.GET)
    @Operation(summary = "接口名称:获取环境变量配置")
    public RestResult<PageResult<EnvironmentVariableDO>> getEnvironmentVariables1(@Validated(QueryGroup.class) EnvironmentVariableQuery environmentVariableQuery) {
        PageResult<EnvironmentVariableDO> result = environmentService.getEnvironmentVariables1(environmentVariableQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:添加环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    @RequestMapping(value = "/variables", method = RequestMethod.POST)
    @Operation(summary = "接口名称:添加环境变量配置")
    @ResponseBody
    public RestResult<Boolean> addEnvironmentVariable(@RequestBody @Validated(CreateGroup.class) EnvironmentVariableDTO environmentVariableDTO) {
        Boolean result = environmentService.addEnvironmentVariable(environmentVariableDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:更新环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    @RequestMapping(value = "/variables", method = RequestMethod.PUT)
    @Operation(summary = "接口名称:更新环境变量配置")
    public RestResult<Boolean> updateEnvironmentVariable(@Validated(UpdateGroup.class) EnvironmentVariableDTO environmentVariableDTO) {
        Boolean result = environmentService.updateEnvironmentVariable(environmentVariableDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:删除环境变量配置
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    @RequestMapping(value = "/variables", method = RequestMethod.DELETE)
    @Operation(summary = "接口名称:删除环境变量配置")
    public RestResult<Boolean> deleteEnvironmentVariable(@Validated(DeleteGroup.class) EnvironmentVariableDTO environmentVariableDTO) {
        Boolean result = environmentService.deleteEnvironmentVariable(environmentVariableDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:获取配置文件信息
     *
     * @param configFileQuery 配置文件查询对象
     * @return
     */
    @RequestMapping(value = "/files", method = RequestMethod.GET)
    @Operation(summary = "接口名称:获取配置文件信息")
    public RestResult<PageResult<ConfigFileDO>> getConfigFiles2(@Validated(QueryGroup.class) ConfigFileQuery configFileQuery) {
        PageResult<ConfigFileDO> result = environmentService.getConfigFiles2(configFileQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:添加配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    @RequestMapping(value = "/files", method = RequestMethod.POST)
    @Operation(summary = "接口名称:添加配置文件信息")
    @ResponseBody
    public RestResult<Boolean> addConfigFile(@RequestBody @Validated(CreateGroup.class) ConfigFileDTO configFileDTO) {
        Boolean result = environmentService.addConfigFile(configFileDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:更新配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    @RequestMapping(value = "/files", method = RequestMethod.PUT)
    @Operation(summary = "接口名称:更新配置文件信息")
    public RestResult<Boolean> updateConfigFile(@Validated(UpdateGroup.class) ConfigFileDTO configFileDTO) {
        Boolean result = environmentService.updateConfigFile(configFileDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:删除配置文件信息
     *
     * @param configFileDTO 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
     * @return
     */
    @RequestMapping(value = "/files", method = RequestMethod.DELETE)
    @Operation(summary = "接口名称:删除配置文件信息")
    public RestResult<Boolean> deleteConfigFile(@Validated(DeleteGroup.class) ConfigFileDTO configFileDTO) {
        Boolean result = environmentService.deleteConfigFile(configFileDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:获取应用上下文信息
     *
     * @param applicationContextQuery 应用上下文信息查询条件
     * @return
     */
    @RequestMapping(value = "/context", method = RequestMethod.GET)
    @Operation(summary = "接口名称:获取应用上下文信息")
    public RestResult<PageResult<ApplicationContextDO>> getApplicationContexts(@Validated(QueryGroup.class) ApplicationContextQuery applicationContextQuery) {
        PageResult<ApplicationContextDO> result = environmentService.getApplicationContexts(applicationContextQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:添加应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    @RequestMapping(value = "/context", method = RequestMethod.POST)
    @Operation(summary = "接口名称:添加应用上下文信息")
    @ResponseBody
    public RestResult<Boolean> addApplicationContext(@RequestBody @Validated(CreateGroup.class) ApplicationContextDTO applicationContextDTO) {
        Boolean result = environmentService.addApplicationContext(applicationContextDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:更新应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    @RequestMapping(value = "/context", method = RequestMethod.PUT)
    @Operation(summary = "接口名称:更新应用上下文信息")
    public RestResult<Boolean> updateApplicationContext(@Validated(UpdateGroup.class) ApplicationContextDTO applicationContextDTO) {
        Boolean result = environmentService.updateApplicationContext(applicationContextDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:删除应用上下文信息
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    @RequestMapping(value = "/context", method = RequestMethod.DELETE)
    @Operation(summary = "接口名称:删除应用上下文信息")
    public RestResult<Boolean> deleteApplicationContext(@Validated(DeleteGroup.class) ApplicationContextDTO applicationContextDTO) {
        Boolean result = environmentService.deleteApplicationContext(applicationContextDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

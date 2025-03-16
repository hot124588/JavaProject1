package com.feisuanyz.controller;

import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.StartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * 启动管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "启动管理")
@RequestMapping("start")
@RestController
public class StartController {

    @Autowired
    private StartService startService;

    /**
     * 配置环境变量: 根据environmentType从project_environment_variables表中获取已有的环境变量，
     *
     * @param environmentVariableDTO 环境变量入参对象
     * @return
     */
    @RequestMapping(value = "/configure-variable", method = RequestMethod.POST)
    @Operation(summary = "配置环境变量: 根据environmentType从project_environment_variables表中获取已有的环境变量，")
    @ResponseBody
    public RestResult<Boolean> configureVariable(@RequestBody @Validated(CreateGroup.class) EnvironmentVariableDTO environmentVariableDTO) {
        Boolean result = startService.configureVariable(environmentVariableDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 加载配置文件: 根据environmentType和fileName从project_config_files表中读取配置文件内容
     *
     * @param configFileQuery 配置文件查询对象
     * @return
     */
    @RequestMapping(value = "/load-config-file", method = RequestMethod.GET)
    @Operation(summary = "加载配置文件: 根据environmentType和fileName从project_config_files表中读取配置文件内容")
    public RestResult<String> loadConfigFile(@Validated(QueryGroup.class) ConfigFileQuery configFileQuery) {
        String result = startService.loadConfigFile(configFileQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 初始化应用上下文: 根据environmentType从application_context表中获取已有的应用上下文，
     *
     * @param applicationContextDTO 应用上下文入参对象
     * @return
     */
    @RequestMapping(value = "/initialize-context", method = RequestMethod.POST)
    @Operation(summary = "初始化应用上下文: 根据environmentType从application_context表中获取已有的应用上下文，")
    @ResponseBody
    public RestResult<Boolean> initializeContext(@RequestBody @Validated(CreateGroup.class) ApplicationContextDTO applicationContextDTO) {
        Boolean result = startService.initializeContext(applicationContextDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 权限校验: 校验用户是否拥有访问指定资源的权限
     *
     * @param userId
     * @param resourceName
     * @return
     */
    @RequestMapping(value = "/validate-permission", method = RequestMethod.GET)
    @Operation(summary = "权限校验: 校验用户是否拥有访问指定资源的权限")
    public RestResult<Boolean> validatePermission(@Validated Long userId, @Validated String resourceName) {
        Boolean result = startService.validatePermission(userId, resourceName);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 数据源连接安全性检查: 检查当前配置的数据源连接安全性
     *
     * @return
     */
    @RequestMapping(value = "/check-datasource-security", method = RequestMethod.GET)
    @Operation(summary = "数据源连接安全性检查: 检查当前配置的数据源连接安全性")
    public RestResult<Boolean> checkDatasourceSecurity() {
        Boolean result = startService.checkDatasourceSecurity();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

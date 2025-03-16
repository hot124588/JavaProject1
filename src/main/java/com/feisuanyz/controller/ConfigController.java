package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ConfigDO;
import com.feisuanyz.pojo.dto.ConfigDTO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.ConfigQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.ConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.feisuanyz.constant.ResultCodeConstant;

/**
 * 配置管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "配置管理")
@RequestMapping("config")
@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    /**
     * 获取所有配置项:查询所有配置项信息
     *
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Operation(summary = "获取所有配置项:查询所有配置项信息")
    public RestResult<List<ConfigDO>> getAllConfigs() {
        List<ConfigDO> result = configService.getAllConfigs();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取配置项:如果配置项不存在，返回失败信息；查询配置项信息
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "获取配置项:如果配置项不存在，返回失败信息；查询配置项信息")
    public RestResult<ConfigDO> getConfigInfo(@Validated(QueryGroup.class) ConfigQuery configQuery) {
        ConfigDO result = configService.getConfigInfo(configQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 新增配置项:如果配置项已存在，返回失败信息；将配置项数据保存到数据库
     *
     * @param configDTO 配置项DTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "新增配置项:如果配置项已存在，返回失败信息；将配置项数据保存到数据库")
    @ResponseBody
    public RestResult<Boolean> addConfig(@RequestBody @Validated(CreateGroup.class) ConfigDTO configDTO) {
        Boolean result = configService.addConfig(configDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改配置项:如果配置项不存在，返回失败信息；更新配置项的值和描述
     *
     * @param configDTO 配置项DTO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "修改配置项:如果配置项不存在，返回失败信息；更新配置项的值和描述")
    @ResponseBody
    public RestResult<Boolean> updateConfig(@RequestBody @Validated(UpdateGroup.class) ConfigDTO configDTO) {
        Boolean result = configService.updateConfig(configDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除配置项:如果配置项不存在，返回失败信息；删除配置项信息
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除配置项:如果配置项不存在，返回失败信息；删除配置项信息")
    public RestResult<Boolean> deleteConfig(@Validated(DeleteGroup.class) ConfigQuery configQuery) {
        Boolean result = configService.deleteConfig(configQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

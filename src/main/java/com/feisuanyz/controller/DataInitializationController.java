package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DataInitializationDTO;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.DataInitializationService;
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
 * 数据初始化管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "数据初始化管理")
@RequestMapping("data-initialization")
@RestController
public class DataInitializationController {

    @Autowired
    private DataInitializationService dataInitializationService;

    /**
     * 初始化项目数据: 检查初始化唯一标识是否已存在
     *
     * @param dataInitializationDTO 初始化项目数据的入参对象
     * @return
     */
    @RequestMapping(value = "/initialize", method = RequestMethod.POST)
    @Operation(summary = "初始化项目数据: 检查初始化唯一标识是否已存在")
    @ResponseBody
    public RestResult<Boolean> initializeProjectData(@RequestBody @Validated(CreateGroup.class) DataInitializationDTO dataInitializationDTO) {
        Boolean result = dataInitializationService.initializeProjectData(dataInitializationDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取初始化数据详情: 根据初始化唯一标识查询数据库
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "获取初始化数据详情: 根据初始化唯一标识查询数据库")
    public RestResult<ProjectDataInitializationDO> getInitializationDataInfo(@Validated(QueryGroup.class) DataInitializationQuery dataInitializationQuery) {
        ProjectDataInitializationDO result = dataInitializationService.getInitializationDataInfo(dataInitializationQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 更新初始化数据: 检查初始化唯一标识是否存在
     *
     * @param dataInitializationDTO 初始化项目数据的入参对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "更新初始化数据: 检查初始化唯一标识是否存在")
    @ResponseBody
    public RestResult<Boolean> updateInitializationData(@RequestBody @Validated(UpdateGroup.class) DataInitializationDTO dataInitializationDTO) {
        Boolean result = dataInitializationService.updateInitializationData(dataInitializationDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除初始化数据: 检查初始化唯一标识是否存在
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除初始化数据: 检查初始化唯一标识是否存在")
    public RestResult<Boolean> deleteInitializationData(@Validated(DeleteGroup.class) DataInitializationQuery dataInitializationQuery) {
        Boolean result = dataInitializationService.deleteInitializationData(dataInitializationQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

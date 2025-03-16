package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.IntegrationFrameworkDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.IntegrationFrameworkDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.IntegrationFrameworkQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.IntegrationService;
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
 * IntegrationController
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "IntegrationController")
@RequestMapping("integration")
@RestController
public class IntegrationController {

    @Autowired
    private IntegrationService integrationService;

    /**
     * add
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "add")
    @ResponseBody
    public RestResult<Boolean> addIntegrationFramework(@RequestBody @Validated(CreateGroup.class) IntegrationFrameworkDTO frameworkDTO) {
        Boolean result = integrationService.addIntegrationFramework(frameworkDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * update
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "update")
    public RestResult<Boolean> updateIntegrationFrameworkStatus(@Validated(UpdateGroup.class) IntegrationFrameworkDTO frameworkDTO) {
        Boolean result = integrationService.updateIntegrationFrameworkStatus(frameworkDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * list
     *
     * @param frameworkQuery 测试框架查询信息
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "list")
    public RestResult<PageResult<IntegrationFrameworkDO>> getIntegrationFrameworks(@Validated(QueryGroup.class) IntegrationFrameworkQuery frameworkQuery) {
        PageResult<IntegrationFrameworkDO> result = integrationService.getIntegrationFrameworks(frameworkQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * delete
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "delete")
    public RestResult<Boolean> deleteIntegrationFramework(@Validated(DeleteGroup.class) IntegrationFrameworkDTO frameworkDTO) {
        Boolean result = integrationService.deleteIntegrationFramework(frameworkDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

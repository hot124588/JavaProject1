package com.feisuanyz.controller;

import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.MaintenanceDTO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.service.MaintenanceService;
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
 * 维护管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "维护管理")
@RequestMapping("maintenance")
@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * upgrade
     *
     * @param maintenanceDTO 维护操作实体类
     * @return
     */
    @RequestMapping(value = "/upgrade", method = RequestMethod.POST)
    @Operation(summary = "upgrade")
    @ResponseBody
    public RestResult<Boolean> upgradeApplication(@RequestBody @Validated(CreateGroup.class) MaintenanceDTO maintenanceDTO) {
        Boolean result = maintenanceService.upgradeApplication(maintenanceDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * backup
     *
     * @param maintenanceDTO 维护操作实体类
     * @return
     */
    @RequestMapping(value = "/backup", method = RequestMethod.POST)
    @Operation(summary = "backup")
    @ResponseBody
    public RestResult<Boolean> backupApplication(@RequestBody @Validated(CreateGroup.class) MaintenanceDTO maintenanceDTO) {
        Boolean result = maintenanceService.backupApplication(maintenanceDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

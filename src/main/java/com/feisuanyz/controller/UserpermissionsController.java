package com.feisuanyz.controller;

import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UserPermissionsDTO;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.UserPermissionsQuery;
import com.feisuanyz.service.UserpermissionsService;
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
 * 用户权限管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Tag(name = "用户权限管理")
@RequestMapping("user/permissions")
@RestController
public class UserpermissionsController {

    @Autowired
    private UserpermissionsService userpermissionsService;

    /**
     * assign
     *
     * @param userPermissionsDTO 用户权限分配入参
     * @return
     */
    @RequestMapping(value = "/assign", method = RequestMethod.PUT)
    @Operation(summary = "assign")
    @ResponseBody
    public RestResult<Boolean> assignRolePermissions(@RequestBody @Validated(CreateGroup.class) UserPermissionsDTO userPermissionsDTO) {
        Boolean result = userpermissionsService.assignRolePermissions(userPermissionsDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * remove
     *
     * @param userPermissionsDTO 用户权限分配入参
     * @return
     */
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @Operation(summary = "remove")
    @ResponseBody
    public RestResult<Boolean> removeRolePermissions(@RequestBody @Validated(DeleteGroup.class) UserPermissionsDTO userPermissionsDTO) {
        Boolean result = userpermissionsService.removeRolePermissions(userPermissionsDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * validate
     *
     * @param userPermissionsQuery 用户权限查询入参
     * @return
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @Operation(summary = "validate")
    public RestResult<Boolean> validateUserPermissions(@Validated(QueryGroup.class) UserPermissionsQuery userPermissionsQuery) {
        Boolean result = userpermissionsService.validateUserPermissions(userPermissionsQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

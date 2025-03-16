package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.DependencyDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.DependencyAddDTO;
import com.feisuanyz.pojo.dto.DependencyDeleteDTO;
import com.feisuanyz.pojo.dto.DependencyUpdateDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.DependencyQuery;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.service.DependencyService;
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
 * 依赖管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:59
 */
@Tag(name = "依赖管理")
@RequestMapping("dependency")
@RestController
public class DependencyController {

    @Autowired
    private DependencyService dependencyService;

    /**
     * add
     *
     * @param dependencyAddDTO 新增依赖库和动态加载依赖库的入参
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "add")
    @ResponseBody
    public RestResult<Boolean> addDependency(@RequestBody @Validated(CreateGroup.class) DependencyAddDTO dependencyAddDTO) {
        Boolean result = dependencyService.addDependency(dependencyAddDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * delete
     *
     * @param dependencyDeleteDTO 删除依赖库的入参
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "delete")
    @ResponseBody
    public RestResult<Boolean> deleteDependency(@RequestBody @Validated(DeleteGroup.class) DependencyDeleteDTO dependencyDeleteDTO) {
        Boolean result = dependencyService.deleteDependency(dependencyDeleteDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * update
     *
     * @param dependencyUpdateDTO 修改依赖库的入参
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "update")
    @ResponseBody
    public RestResult<Boolean> updateDependency(@RequestBody @Validated(UpdateGroup.class) DependencyUpdateDTO dependencyUpdateDTO) {
        Boolean result = dependencyService.updateDependency(dependencyUpdateDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * list
     *
     * @param dependencyQuery 查询依赖库的入参
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "list")
    public RestResult<PageResult<DependencyDO>> listDependencies(@Validated(QueryGroup.class) DependencyQuery dependencyQuery) {
        PageResult<DependencyDO> result = dependencyService.listDependencies(dependencyQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * info
     *
     * @param dependencyQuery 查询依赖库的入参
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "info")
    public RestResult<DependencyDO> getDependencyInfo(@Validated(QueryGroup.class) DependencyQuery dependencyQuery) {
        DependencyDO result = dependencyService.getDependencyInfo(dependencyQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

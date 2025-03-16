package com.feisuanyz.controller;

import com.feisuanyz.pojo.domain.ResourceDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.ResourceAllocationDTO;
import com.feisuanyz.pojo.dto.ResourceReleaseDTO;
import com.feisuanyz.pojo.dto.ResourceUpdateDTO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.ResourceQuery;
import com.feisuanyz.service.ResourceService;
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
 * 资源管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Tag(name = "资源管理")
@RequestMapping("resource")
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * allocate
     *
     * @param allocationDTO 资源分配入参实体类
     * @return
     */
    @RequestMapping(value = "/allocate", method = RequestMethod.POST)
    @Operation(summary = "allocate")
    @ResponseBody
    public RestResult<Boolean> allocateResource(@RequestBody @Validated(CreateGroup.class) ResourceAllocationDTO allocationDTO) {
        Boolean result = resourceService.allocateResource(allocationDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * release
     *
     * @param releaseDTO 资源释放入参实体类
     * @return
     */
    @RequestMapping(value = "/release", method = RequestMethod.PUT)
    @Operation(summary = "release")
    @ResponseBody
    public RestResult<Boolean> releaseResource(@RequestBody @Validated(QueryGroup.class) ResourceReleaseDTO releaseDTO) {
        Boolean result = resourceService.releaseResource(releaseDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * info
     *
     * @param resourceQuery 资源查询入参实体类
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "info")
    public RestResult<PageResult<ResourceDO>> getResourceInfo(@Validated(QueryGroup.class) ResourceQuery resourceQuery) {
        PageResult<ResourceDO> result = resourceService.getResourceInfo(resourceQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * update
     *
     * @param updateDTO 资源更新入参实体类
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "update")
    @ResponseBody
    public RestResult<Boolean> updateResource(@RequestBody @Validated(UpdateGroup.class) ResourceUpdateDTO updateDTO) {
        Boolean result = resourceService.updateResource(updateDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

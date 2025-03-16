package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ResourceMapper;
import com.feisuanyz.pojo.domain.ResourceDO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.ResourceAllocationDTO;
import com.feisuanyz.pojo.dto.ResourceReleaseDTO;
import com.feisuanyz.pojo.dto.ResourceUpdateDTO;
import com.feisuanyz.pojo.query.ResourceQuery;
import com.feisuanyz.service.ResourceService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 资源管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Boolean allocateResource(ResourceAllocationDTO allocationDTO) {
        QueryWrapper<ResourceDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("resource_name", allocationDTO.getResourceName());
        ResourceDO existingResource = resourceMapper.selectOne(queryWrapper);
        if (existingResource != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setResourceName(allocationDTO.getResourceName());
        resourceDO.setResourceType(allocationDTO.getResourceType());
        resourceDO.setAllocationStatus(allocationDTO.getAllocationStatus());
        resourceDO.setCreateBy(allocationDTO.getCreateBy());
        resourceDO.setCreateTime(new Date());
        int result = resourceMapper.insert(resourceDO);
        return result > 0;
    }

    @Override
    public Boolean releaseResource(ResourceReleaseDTO releaseDTO) {
        QueryWrapper<ResourceDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("resource_name", releaseDTO.getResourceName());
        ResourceDO existingResource = resourceMapper.selectOne(queryWrapper);
        if (existingResource == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        existingResource.setAllocationStatus("释放");
        existingResource.setUpdateTime(new Date());
        int result = resourceMapper.updateById(existingResource);
        return result > 0;
    }

    @Override
    public PageResult<ResourceDO> getResourceInfo(ResourceQuery resourceQuery) {
        Page<ResourceDO> page = new Page<>(resourceQuery.getPageIndex(), resourceQuery.getPageSize());
        QueryWrapper<ResourceDO> queryWrapper = Wrappers.query();
        if (resourceQuery.getResourceName() != null) {
            queryWrapper.eq("resource_name", resourceQuery.getResourceName());
        }
        if (resourceQuery.getResourceType() != null) {
            queryWrapper.eq("resource_type", resourceQuery.getResourceType());
        }
        if (resourceQuery.getAllocationStatus() != null) {
            queryWrapper.eq("allocation_status", resourceQuery.getAllocationStatus());
        }
        Page<ResourceDO> resourcePage = resourceMapper.selectPage(page, queryWrapper);
        PageResult<ResourceDO> pageResult = new PageResult<>(resourcePage);
        return pageResult;
    }

    @Override
    public Boolean updateResource(ResourceUpdateDTO updateDTO) {
        ResourceDO resourceDO = resourceMapper.selectById(updateDTO.getId());
        if (resourceDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        resourceDO.setResourceName(updateDTO.getResourceName());
        resourceDO.setResourceType(updateDTO.getResourceType());
        resourceDO.setAllocationStatus(updateDTO.getAllocationStatus());
        resourceDO.setUpdateBy(updateDTO.getUpdateBy());
        resourceDO.setUpdateTime(new Date());
        int result = resourceMapper.updateById(resourceDO);
        return result > 0;
    }
}

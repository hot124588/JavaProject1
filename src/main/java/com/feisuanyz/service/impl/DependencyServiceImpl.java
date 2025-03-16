package com.feisuanyz.service.impl;

import com.feisuanyz.dao.DependencyMapper;
import com.feisuanyz.pojo.domain.DependencyDO;
import com.feisuanyz.pojo.dto.DependencyAddDTO;
import com.feisuanyz.pojo.dto.DependencyDeleteDTO;
import com.feisuanyz.pojo.dto.DependencyUpdateDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.DependencyQuery;
import com.feisuanyz.service.DependencyService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 依赖管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private DependencyMapper dependencyMapper;

    @Override
    public Boolean addDependency(DependencyAddDTO dependencyAddDTO) {
        QueryWrapper<DependencyDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("dependency_name", dependencyAddDTO.getDependencyName()).eq("version", dependencyAddDTO.getVersion());
        DependencyDO existingDependency = dependencyMapper.selectOne(queryWrapper);
        if (existingDependency != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        DependencyDO dependencyDO = new DependencyDO();
        dependencyDO.setDependencyName(dependencyAddDTO.getDependencyName());
        dependencyDO.setVersion(dependencyAddDTO.getVersion());
        dependencyDO.setStatus(dependencyAddDTO.getStatus());
        dependencyDO.setCreateBy("admin");
        dependencyDO.setCreateTime(new Date());
        int result = dependencyMapper.insert(dependencyDO);
        return result > 0;
    }

    @Override
    public Boolean deleteDependency(DependencyDeleteDTO dependencyDeleteDTO) {
        Integer dependencyId = dependencyDeleteDTO.getDependencyId();
        DependencyDO existingDependency = dependencyMapper.selectById(dependencyId);
        if (existingDependency == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = dependencyMapper.deleteById(dependencyId);
        return result > 0;
    }

    @Override
    public Boolean updateDependency(DependencyUpdateDTO dependencyUpdateDTO) {
        Integer dependencyId = dependencyUpdateDTO.getDependencyId();
        DependencyDO existingDependency = dependencyMapper.selectById(dependencyId);
        if (existingDependency == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        existingDependency.setDependencyName(dependencyUpdateDTO.getDependencyName());
        existingDependency.setVersion(dependencyUpdateDTO.getVersion());
        existingDependency.setStatus(dependencyUpdateDTO.getStatus());
        existingDependency.setUpdateBy("admin");
        existingDependency.setUpdateTime(new Date());
        int result = dependencyMapper.updateById(existingDependency);
        return result > 0;
    }

    @Override
    public PageResult<DependencyDO> listDependencies(DependencyQuery dependencyQuery) {
        Page<DependencyDO> page = new Page<>(dependencyQuery.getPageIndex(), dependencyQuery.getPageSize());
        QueryWrapper<DependencyDO> queryWrapper = Wrappers.query();
        if (dependencyQuery.getEnvironmentType() != null) {
            queryWrapper.eq("status", dependencyQuery.getEnvironmentType());
        }
        IPage<DependencyDO> dependencyPage = dependencyMapper.selectPage(page, queryWrapper);
        PageResult<DependencyDO> pageResult = new PageResult<>(dependencyPage.getRecords(), dependencyPage.getTotal(), dependencyQuery.getPageSize(), dependencyQuery.getPageIndex());
        return pageResult;
    }

    @Override
    public DependencyDO getDependencyInfo(DependencyQuery dependencyQuery) {
        Integer dependencyId = dependencyQuery.getDependencyId();
        DependencyDO dependencyDO = dependencyMapper.selectById(dependencyId);
        if (dependencyDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return dependencyDO;
    }
}

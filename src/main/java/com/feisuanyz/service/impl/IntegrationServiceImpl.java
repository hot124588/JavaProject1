package com.feisuanyz.service.impl;

import com.feisuanyz.dao.IntegrationFrameworkMapper;
import com.feisuanyz.pojo.domain.IntegrationFrameworkDO;
import com.feisuanyz.pojo.dto.IntegrationFrameworkDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.IntegrationFrameworkQuery;
import com.feisuanyz.service.IntegrationService;
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

/**
 * IntegrationServiceImpl
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class IntegrationServiceImpl implements IntegrationService {

    @Autowired
    private IntegrationFrameworkMapper integrationFrameworkMapper;

    @Override
    public Boolean addIntegrationFramework(IntegrationFrameworkDTO frameworkDTO) {
        QueryWrapper<IntegrationFrameworkDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("framework_name", frameworkDTO.getFrameworkName());
        queryWrapper.eq("environment_type", frameworkDTO.getEnvironmentType());
        IntegrationFrameworkDO existingFramework = integrationFrameworkMapper.selectOne(queryWrapper);
        if (existingFramework != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        IntegrationFrameworkDO frameworkDO = new IntegrationFrameworkDO();
        frameworkDO.setFrameworkName(frameworkDTO.getFrameworkName());
        frameworkDO.setEnvironmentType(frameworkDTO.getEnvironmentType());
        frameworkDO.setStatus("INTEGRATED");
        int result = integrationFrameworkMapper.insert(frameworkDO);
        return result > 0;
    }

    @Override
    public Boolean updateIntegrationFrameworkStatus(IntegrationFrameworkDTO frameworkDTO) {
        QueryWrapper<IntegrationFrameworkDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("framework_name", frameworkDTO.getFrameworkName());
        queryWrapper.eq("environment_type", frameworkDTO.getEnvironmentType());
        IntegrationFrameworkDO existingFramework = integrationFrameworkMapper.selectOne(queryWrapper);
        if (existingFramework == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        existingFramework.setStatus(frameworkDTO.getStatus());
        int result = integrationFrameworkMapper.updateById(existingFramework);
        return result > 0;
    }

    @Override
    public PageResult<IntegrationFrameworkDO> getIntegrationFrameworks(IntegrationFrameworkQuery frameworkQuery) {
        IPage<IntegrationFrameworkDO> page = new Page<>(frameworkQuery.getPageIndex(), frameworkQuery.getPageSize());
        QueryWrapper<IntegrationFrameworkDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("environment_type", frameworkQuery.getEnvironmentType());
        IPage<IntegrationFrameworkDO> frameworkPage = integrationFrameworkMapper.selectPage(page, queryWrapper);
        PageResult<IntegrationFrameworkDO> pageResult = new PageResult<>(frameworkPage.getRecords(), frameworkPage.getTotal(), frameworkPage.getCurrent(), frameworkPage.getSize());
        return pageResult;
    }

    @Override
    public Boolean deleteIntegrationFramework(IntegrationFrameworkDTO frameworkDTO) {
        QueryWrapper<IntegrationFrameworkDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("framework_name", frameworkDTO.getFrameworkName());
        queryWrapper.eq("environment_type", frameworkDTO.getEnvironmentType());
        IntegrationFrameworkDO existingFramework = integrationFrameworkMapper.selectOne(queryWrapper);
        if (existingFramework == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = integrationFrameworkMapper.delete(queryWrapper);
        return result > 0;
    }
}

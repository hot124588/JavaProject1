package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ApplicationContextMapper;
import com.feisuanyz.dao.ConfigFileMapper;
import com.feisuanyz.dao.EnvironmentVariableMapper;
import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import com.feisuanyz.service.StartService;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feisuanyz.pojo.domain.EnvironmentVariableDO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import java.io.File;
import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.constant.ResultCodeConstant;
import lombok.Data;
import com.feisuanyz.pojo.domain.ConfigFileDO;
import java.util.Date;

/**
 * 启动管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class StartServiceImpl implements StartService {

    @Autowired
    private EnvironmentVariableMapper environmentVariableMapper;

    @Autowired
    private ConfigFileMapper configFileMapper;

    @Autowired
    private ApplicationContextMapper applicationContextMapper;

    @Override
    public Boolean configureVariable(EnvironmentVariableDTO environmentVariableDTO) {
        EnvironmentVariableDO environmentVariableDO = new EnvironmentVariableDO();
        environmentVariableDO.setVariableName(environmentVariableDTO.getVariableName());
        environmentVariableDO.setVariableValue(environmentVariableDTO.getVariableValue());
        environmentVariableDO.setEnvironmentType(environmentVariableDTO.getEnvironmentType());
        environmentVariableDO.setCreateTime(new Date());
        environmentVariableDO.setUpdateTime(new Date());
        QueryWrapper<EnvironmentVariableDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("variable_name", environmentVariableDTO.getVariableName()).eq("environment_type", environmentVariableDTO.getEnvironmentType());
        EnvironmentVariableDO existingVariable = environmentVariableMapper.selectOne(queryWrapper);
        if (existingVariable != null) {
            environmentVariableDO.setId(existingVariable.getId());
            int result = environmentVariableMapper.updateById(environmentVariableDO);
            return result > 0;
        } else {
            int result = environmentVariableMapper.insert(environmentVariableDO);
            return result > 0;
        }
    }

    @Override
    public String loadConfigFile(ConfigFileQuery configFileQuery) {
        QueryWrapper<ConfigFileDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("file_name", configFileQuery.getFileName()).eq("environment_type", configFileQuery.getEnvironmentType());
        ConfigFileDO configFileDO = configFileMapper.selectOne(queryWrapper);
        if (configFileDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return configFileDO.getFileContent();
    }

    @Override
    public Boolean initializeContext(ApplicationContextDTO applicationContextDTO) {
        ApplicationContextDO applicationContextDO = new ApplicationContextDO();
        applicationContextDO.setContextInfo(applicationContextDTO.getContextInfo());
        applicationContextDO.setEnvironmentType(applicationContextDTO.getEnvironmentType());
        applicationContextDO.setCreateTime(new Date());
        applicationContextDO.setUpdateTime(new Date());
        QueryWrapper<ApplicationContextDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("environment_type", applicationContextDTO.getEnvironmentType());
        ApplicationContextDO existingContext = applicationContextMapper.selectOne(queryWrapper);
        if (existingContext != null) {
            applicationContextDO.setId(existingContext.getId());
            int result = applicationContextMapper.updateById(applicationContextDO);
            return result > 0;
        } else {
            int result = applicationContextMapper.insert(applicationContextDO);
            return result > 0;
        }
    }

    @Override
    public Boolean validatePermission(Long userId, String resourceName) {
        // 权限校验逻辑
        // 假设此处为权限校验结果
        boolean hasPermission = false;
        if (!hasPermission) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return true;
    }

    @Override
    public Boolean checkDatasourceSecurity() {
        // 数据源安全性检查逻辑
        // 假设此处为安全性检查结果
        boolean isSecure = false;
        if (!isSecure) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return true;
    }
}

package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ApplicationContextMapper;
import com.feisuanyz.dao.ConfigFileMapper;
import com.feisuanyz.dao.EnvironmentVariableMapper;
import com.feisuanyz.pojo.domain.ApplicationContextDO;
import com.feisuanyz.pojo.domain.ConfigFileDO;
import com.feisuanyz.pojo.domain.EnvironmentVariableDO;
import com.feisuanyz.pojo.dto.ApplicationContextDTO;
import com.feisuanyz.pojo.dto.ConfigFileDTO;
import com.feisuanyz.pojo.dto.EnvironmentVariableDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.ApplicationContextQuery;
import com.feisuanyz.pojo.query.ConfigFileQuery;
import com.feisuanyz.pojo.query.EnvironmentVariableQuery;
import com.feisuanyz.service.EnvironmentService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import java.io.File;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 模块名称:环境适应管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    private EnvironmentVariableMapper environmentVariableMapper;

    @Autowired
    private ConfigFileMapper configFileMapper;

    @Autowired
    private ApplicationContextMapper applicationContextMapper;

    @Override
    public PageResult<EnvironmentVariableDO> getEnvironmentVariables1(EnvironmentVariableQuery environmentVariableQuery) {
        try {
            IPage<EnvironmentVariableDO> page = new Page<>(environmentVariableQuery.getPageIndex(), environmentVariableQuery.getPageSize());
            QueryWrapper<EnvironmentVariableDO> wrapper = new QueryWrapper<>();
            wrapper.eq("environment_type", environmentVariableQuery.getEnvironmentType());
            IPage<EnvironmentVariableDO> variablePage = environmentVariableMapper.selectPage(page, wrapper);
            PageResult<EnvironmentVariableDO> pageResult = new PageResult<>(variablePage.getRecords(), variablePage.getTotal(), variablePage.getSize(), variablePage.getCurrent());
            return pageResult;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean addEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO) {
        try {
            QueryWrapper<EnvironmentVariableDO> wrapper = new QueryWrapper<>();
            wrapper.eq("variable_name", environmentVariableDTO.getVariableName());
            wrapper.eq("environment_type", environmentVariableDTO.getEnvironmentType());
            int count = environmentVariableMapper.selectCount(wrapper);
            if (count > 0) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            EnvironmentVariableDO environmentVariableDO = new EnvironmentVariableDO();
            environmentVariableDO.setVariableName(environmentVariableDTO.getVariableName());
            environmentVariableDO.setVariableValue(environmentVariableDTO.getVariableValue());
            environmentVariableDO.setEnvironmentType(environmentVariableDTO.getEnvironmentType());
            environmentVariableDO.setCreateBy(environmentVariableDTO.getCreateBy());
            environmentVariableDO.setCreateTime(environmentVariableDTO.getCreateTime() != null ? environmentVariableDTO.getCreateTime() : new Date());
            int result = environmentVariableMapper.insert(environmentVariableDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean updateEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO) {
        try {
            EnvironmentVariableDO environmentVariableDO = environmentVariableMapper.selectById(environmentVariableDTO.getId());
            if (environmentVariableDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            environmentVariableDO.setVariableValue(environmentVariableDTO.getVariableValue());
            environmentVariableDO.setUpdateBy(environmentVariableDTO.getUpdateBy());
            environmentVariableDO.setUpdateTime(environmentVariableDTO.getUpdateTime() != null ? environmentVariableDTO.getUpdateTime() : new Date());
            int result = environmentVariableMapper.updateById(environmentVariableDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean deleteEnvironmentVariable(EnvironmentVariableDTO environmentVariableDTO) {
        try {
            EnvironmentVariableDO environmentVariableDO = environmentVariableMapper.selectById(environmentVariableDTO.getId());
            if (environmentVariableDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            int result = environmentVariableMapper.deleteById(environmentVariableDTO.getId());
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public PageResult<ConfigFileDO> getConfigFiles2(ConfigFileQuery configFileQuery) {
        try {
            IPage<ConfigFileDO> page = new Page<>(configFileQuery.getPageIndex(), configFileQuery.getPageSize());
            QueryWrapper<ConfigFileDO> wrapper = new QueryWrapper<>();
            wrapper.eq("environment_type", configFileQuery.getEnvironmentType());
            IPage<ConfigFileDO> filePage = configFileMapper.selectPage(page, wrapper);
            PageResult<ConfigFileDO> pageResult = new PageResult<>(filePage.getRecords(), filePage.getTotal(), filePage.getSize(), filePage.getCurrent());
            return pageResult;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean addConfigFile(ConfigFileDTO configFileDTO) {
        try {
            QueryWrapper<ConfigFileDO> wrapper = new QueryWrapper<>();
            wrapper.eq("file_name", configFileDTO.getFileName());
            wrapper.eq("environment_type", configFileDTO.getEnvironmentType());
            int count = configFileMapper.selectCount(wrapper);
            if (count > 0) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            ConfigFileDO configFileDO = new ConfigFileDO();
            configFileDO.setFileName(configFileDTO.getFileName());
            configFileDO.setFileContent(configFileDTO.getFileContent());
            configFileDO.setEnvironmentType(configFileDTO.getEnvironmentType());
            configFileDO.setCreateBy(configFileDTO.getCreateBy());
            configFileDO.setCreateTime(configFileDTO.getCreateTime() != null ? configFileDTO.getCreateTime() : new Date());
            int result = configFileMapper.insert(configFileDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean updateConfigFile(ConfigFileDTO configFileDTO) {
        try {
            ConfigFileDO configFileDO = configFileMapper.selectById(configFileDTO.getId());
            if (configFileDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            configFileDO.setFileContent(configFileDTO.getFileContent());
            configFileDO.setUpdateBy(configFileDTO.getUpdateBy());
            configFileDO.setUpdateTime(configFileDTO.getUpdateTime() != null ? configFileDTO.getUpdateTime() : new Date());
            int result = configFileMapper.updateById(configFileDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean deleteConfigFile(ConfigFileDTO configFileDTO) {
        try {
            ConfigFileDO configFileDO = configFileMapper.selectById(configFileDTO.getId());
            if (configFileDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            int result = configFileMapper.deleteById(configFileDTO.getId());
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public PageResult<ApplicationContextDO> getApplicationContexts(ApplicationContextQuery applicationContextQuery) {
        try {
            IPage<ApplicationContextDO> page = new Page<>(applicationContextQuery.getPageIndex(), applicationContextQuery.getPageSize());
            QueryWrapper<ApplicationContextDO> wrapper = new QueryWrapper<>();
            wrapper.eq("environment_type", applicationContextQuery.getEnvironmentType());
            IPage<ApplicationContextDO> contextPage = applicationContextMapper.selectPage(page, wrapper);
            PageResult<ApplicationContextDO> pageResult = new PageResult<>(contextPage.getRecords(), contextPage.getTotal(), contextPage.getSize(), contextPage.getCurrent());
            return pageResult;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean addApplicationContext(ApplicationContextDTO applicationContextDTO) {
        try {
            QueryWrapper<ApplicationContextDO> wrapper = new QueryWrapper<>();
            wrapper.eq("environment_type", applicationContextDTO.getEnvironmentType());
            int count = applicationContextMapper.selectCount(wrapper);
            if (count > 0) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            ApplicationContextDO applicationContextDO = new ApplicationContextDO();
            applicationContextDO.setContextInfo(applicationContextDTO.getContextInfo());
            applicationContextDO.setEnvironmentType(applicationContextDTO.getEnvironmentType());
            applicationContextDO.setCreateBy(applicationContextDTO.getCreateBy());
            applicationContextDO.setCreateTime(applicationContextDTO.getCreateTime() != null ? applicationContextDTO.getCreateTime() : new Date());
            int result = applicationContextMapper.insert(applicationContextDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean updateApplicationContext(ApplicationContextDTO applicationContextDTO) {
        try {
            ApplicationContextDO applicationContextDO = applicationContextMapper.selectById(applicationContextDTO.getId());
            if (applicationContextDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            applicationContextDO.setContextInfo(applicationContextDTO.getContextInfo());
            applicationContextDO.setUpdateBy(applicationContextDTO.getUpdateBy());
            applicationContextDO.setUpdateTime(applicationContextDTO.getUpdateTime() != null ? applicationContextDTO.getUpdateTime() : new Date());
            int result = applicationContextMapper.updateById(applicationContextDO);
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public Boolean deleteApplicationContext(ApplicationContextDTO applicationContextDTO) {
        try {
            ApplicationContextDO applicationContextDO = applicationContextMapper.selectById(applicationContextDTO.getId());
            if (applicationContextDO == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            int result = applicationContextMapper.deleteById(applicationContextDTO.getId());
            return result > 0;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }
}

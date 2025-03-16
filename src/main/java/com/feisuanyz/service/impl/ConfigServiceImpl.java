package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ConfigMapper;
import com.feisuanyz.pojo.domain.ConfigDO;
import com.feisuanyz.pojo.dto.ConfigDTO;
import com.feisuanyz.pojo.query.ConfigQuery;
import com.feisuanyz.service.ConfigService;
import java.lang.Boolean;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 配置管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<ConfigDO> getAllConfigs() {
        List<ConfigDO> configList = configMapper.selectList(Wrappers.emptyWrapper());
        return configList;
    }

    @Override
    public ConfigDO getConfigInfo(ConfigQuery configQuery) {
        QueryWrapper<ConfigDO> wrapper = Wrappers.query(new ConfigDO()).eq("config_key", configQuery.getConfigKey());
        ConfigDO configDO = configMapper.selectOne(wrapper);
        if (configDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return configDO;
    }

    @Override
    public Boolean addConfig(ConfigDTO configDTO) {
        QueryWrapper<ConfigDO> wrapper = Wrappers.query(new ConfigDO()).eq("config_key", configDTO.getConfigKey());
        ConfigDO existingConfig = configMapper.selectOne(wrapper);
        if (existingConfig != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ConfigDO configDO = new ConfigDO();
        configDO.setConfigKey(configDTO.getConfigKey());
        configDO.setConfigValue(configDTO.getConfigValue());
        configDO.setDescription(configDTO.getDescription());
        configDO.setCreateTime(new java.util.Date());
        configDO.setCreateBy("admin");
        int result = configMapper.insert(configDO);
        return result > 0;
    }

    @Override
    public Boolean updateConfig(ConfigDTO configDTO) {
        QueryWrapper<ConfigDO> wrapper = Wrappers.query(new ConfigDO()).eq("config_key", configDTO.getConfigKey());
        ConfigDO configDO = configMapper.selectOne(wrapper);
        if (configDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        configDO.setConfigValue(configDTO.getConfigValue());
        configDO.setDescription(configDTO.getDescription());
        configDO.setUpdateTime(new java.util.Date());
        configDO.setUpdateBy("admin");
        int result = configMapper.updateById(configDO);
        return result > 0;
    }

    @Override
    public Boolean deleteConfig(ConfigQuery configQuery) {
        QueryWrapper<ConfigDO> wrapper = Wrappers.query(new ConfigDO()).eq("config_key", configQuery.getConfigKey());
        ConfigDO configDO = configMapper.selectOne(wrapper);
        if (configDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = configMapper.deleteById(configDO.getId());
        return result > 0;
    }
}

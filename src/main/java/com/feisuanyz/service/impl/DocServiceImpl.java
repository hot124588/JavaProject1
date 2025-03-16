package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ConfigMapper;
import com.feisuanyz.pojo.domain.ConfigDO;
import com.feisuanyz.pojo.query.ConfigQuery;
import com.feisuanyz.service.DocService;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feisuanyz.constant.ResultCodeConstant;

/**
 * DocServiceImpl
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class DocServiceImpl implements DocService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public String generateApiDoc(ConfigQuery configQuery) {
        try {
            // 根据环境类型获取配置信息
            // 假设最多有1000个配置项
            IPage<ConfigDO> page = new Page<>(1, 1000);
            QueryWrapper<ConfigDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("environment_type", configQuery.getEnvironmentType());
            IPage<ConfigDO> configPage = configMapper.selectPage(page, queryWrapper);
            // 解析配置信息以生成API文档
            List<ConfigDO> configList = configPage.getRecords();
            String apiDoc = parseConfigToApiDoc(configList);
            return apiDoc;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public String generateInternalDoc(ConfigQuery configQuery) {
        try {
            // 根据环境类型获取配置信息
            // 假设最多有1000个配置项
            IPage<ConfigDO> page = new Page<>(1, 1000);
            QueryWrapper<ConfigDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("environment_type", configQuery.getEnvironmentType());
            IPage<ConfigDO> configPage = configMapper.selectPage(page, queryWrapper);
            // 解析配置信息以生成内部文档
            List<ConfigDO> configList = configPage.getRecords();
            String internalDoc = parseConfigToInternalDoc(configList);
            return internalDoc;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    private String parseConfigToApiDoc(List<ConfigDO> configList) {
        // 实现解析逻辑以生成API文档
        StringBuilder apiDoc = new StringBuilder();
        apiDoc.append("API文档:\n");
        for (ConfigDO configDO : configList) {
            apiDoc.append("配置项键: ").append(configDO.getConfigKey()).append("\n");
            apiDoc.append("配置项值: ").append(configDO.getConfigValue()).append("\n");
            apiDoc.append("描述: ").append(configDO.getDescription()).append("\n\n");
        }
        return apiDoc.toString();
    }

    private String parseConfigToInternalDoc(List<ConfigDO> configList) {
        // 实现解析逻辑以生成内部文档
        StringBuilder internalDoc = new StringBuilder();
        internalDoc.append("内部文档:\n");
        for (ConfigDO configDO : configList) {
            internalDoc.append("配置项键: ").append(configDO.getConfigKey()).append("\n");
            internalDoc.append("配置项值: ").append(configDO.getConfigValue()).append("\n");
            internalDoc.append("描述: ").append(configDO.getDescription()).append("\n\n");
        }
        return internalDoc.toString();
    }
}

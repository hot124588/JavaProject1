package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ConfigDO;
import com.feisuanyz.pojo.dto.ConfigDTO;
import com.feisuanyz.pojo.query.ConfigQuery;
import java.lang.Boolean;
import java.util.List;

/**
 * 配置管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface ConfigService {

    /**
     * 获取所有配置项:查询所有配置项信息
     *
     * @return
     */
    List<ConfigDO> getAllConfigs();

    /**
     * 获取配置项:如果配置项不存在，返回失败信息；查询配置项信息
     *
     * @param configQuery 配置项查询对象
     * @return  配置项DO
     */
    ConfigDO getConfigInfo(ConfigQuery configQuery);

    /**
     * 新增配置项:如果配置项已存在，返回失败信息；将配置项数据保存到数据库
     *
     * @param configDTO 配置项DTO
     * @return
     */
    Boolean addConfig(ConfigDTO configDTO);

    /**
     * 修改配置项:如果配置项不存在，返回失败信息；更新配置项的值和描述
     *
     * @param configDTO 配置项DTO
     * @return
     */
    Boolean updateConfig(ConfigDTO configDTO);

    /**
     * 删除配置项:如果配置项不存在，返回失败信息；删除配置项信息
     *
     * @param configQuery 配置项查询对象
     * @return
     */
    Boolean deleteConfig(ConfigQuery configQuery);
}

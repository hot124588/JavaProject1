package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import org.apache.ibatis.annotations.Param;

/**
 * ProjectDataInitializationMapper
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface ProjectDataInitializationMapper extends BaseMapper<ProjectDataInitializationDO> {

    /**
     * 根据初始化唯一标识查询项目数据初始化信息
     *
     * @Param initializationId: 初始化唯一标识
     * @Return ProjectDataInitializationDO: 查询到的项目数据初始化信息
     */
    public ProjectDataInitializationDO selectByInitializationId(@Param("initializationId") String initializationId);
}

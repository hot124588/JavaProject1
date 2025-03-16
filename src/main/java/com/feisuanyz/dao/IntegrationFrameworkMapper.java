package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.IntegrationFrameworkDO;
import org.apache.ibatis.annotations.Param;

/**
 * IntegrationFrameworkMapper
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface IntegrationFrameworkMapper extends BaseMapper<IntegrationFrameworkDO> {

    /**
     * 根据框架名称和环境类型查询集成的测试框架信息
     *
     * @param frameworkName   测试框架名称
     * @param environmentType 环境类型
     * @return 集成的测试框架信息
     */
    IntegrationFrameworkDO selectByFrameworkNameAndEnvironmentType(@Param("frameworkName") String frameworkName, @Param("environmentType") String environmentType);
}

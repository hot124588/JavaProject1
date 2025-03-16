package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.DependencyDO;
import org.apache.ibatis.annotations.Param;

/**
 * DependencyMapper
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface DependencyMapper extends BaseMapper<DependencyDO> {

    /**
     * 根据依赖库名称和版本查询依赖库信息
     *
     * @param dependencyName 依赖库名称
     * @param version 依赖库版本
     * @return 依赖库信息
     */
    public DependencyDO selectByDependencyNameAndVersion(@Param("dependencyName") String dependencyName, @Param("version") String version);
}

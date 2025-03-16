package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.DependencyDO;
import com.feisuanyz.pojo.dto.DependencyAddDTO;
import com.feisuanyz.pojo.dto.DependencyDeleteDTO;
import com.feisuanyz.pojo.dto.DependencyUpdateDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.DependencyQuery;
import java.lang.Boolean;

/**
 * 依赖管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface DependencyService {

    /**
     * add
     *
     * @param dependencyAddDTO 新增依赖库和动态加载依赖库的入参
     * @return
     */
    Boolean addDependency(DependencyAddDTO dependencyAddDTO);

    /**
     * delete
     *
     * @param dependencyDeleteDTO 删除依赖库的入参
     * @return
     */
    Boolean deleteDependency(DependencyDeleteDTO dependencyDeleteDTO);

    /**
     * update
     *
     * @param dependencyUpdateDTO 修改依赖库的入参
     * @return
     */
    Boolean updateDependency(DependencyUpdateDTO dependencyUpdateDTO);

    /**
     * list
     *
     * @param dependencyQuery 查询依赖库的入参
     * @return
     */
    PageResult<DependencyDO> listDependencies(DependencyQuery dependencyQuery);

    /**
     * info
     *
     * @param dependencyQuery 查询依赖库的入参
     * @return  依赖库信息实体
     */
    DependencyDO getDependencyInfo(DependencyQuery dependencyQuery);
}

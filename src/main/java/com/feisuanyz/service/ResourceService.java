package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ResourceDO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.dto.ResourceAllocationDTO;
import com.feisuanyz.pojo.dto.ResourceReleaseDTO;
import com.feisuanyz.pojo.dto.ResourceUpdateDTO;
import com.feisuanyz.pojo.query.ResourceQuery;
import java.lang.Boolean;

/**
 * 资源管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface ResourceService {

    /**
     * allocate
     *
     * @param allocationDTO 资源分配入参实体类
     * @return
     */
    Boolean allocateResource(ResourceAllocationDTO allocationDTO);

    /**
     * release
     *
     * @param releaseDTO 资源释放入参实体类
     * @return
     */
    Boolean releaseResource(ResourceReleaseDTO releaseDTO);

    /**
     * info
     *
     * @param resourceQuery 资源查询入参实体类
     * @return
     */
    PageResult<ResourceDO> getResourceInfo(ResourceQuery resourceQuery);

    /**
     * update
     *
     * @param updateDTO 资源更新入参实体类
     * @return
     */
    Boolean updateResource(ResourceUpdateDTO updateDTO);
}

package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.IntegrationFrameworkDO;
import com.feisuanyz.pojo.dto.IntegrationFrameworkDTO;
import com.feisuanyz.pojo.dto.PageResult;
import com.feisuanyz.pojo.query.IntegrationFrameworkQuery;
import java.lang.Boolean;

/**
 * IntegrationService
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface IntegrationService {

    /**
     * add
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    Boolean addIntegrationFramework(IntegrationFrameworkDTO frameworkDTO);

    /**
     * update
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    Boolean updateIntegrationFrameworkStatus(IntegrationFrameworkDTO frameworkDTO);

    /**
     * list
     *
     * @param frameworkQuery 测试框架查询信息
     * @return
     */
    PageResult<IntegrationFrameworkDO> getIntegrationFrameworks(IntegrationFrameworkQuery frameworkQuery);

    /**
     * delete
     *
     * @param frameworkDTO 测试框架集成信息DTO
     * @return
     */
    Boolean deleteIntegrationFramework(IntegrationFrameworkDTO frameworkDTO);
}

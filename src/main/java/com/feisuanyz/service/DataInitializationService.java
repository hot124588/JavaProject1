package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.dto.DataInitializationDTO;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import java.lang.Boolean;

/**
 * 数据初始化管理
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface DataInitializationService {

    /**
     * 初始化项目数据: 检查初始化唯一标识是否已存在
     *
     * @param dataInitializationDTO 初始化项目数据的入参对象
     * @return
     */
    Boolean initializeProjectData(DataInitializationDTO dataInitializationDTO);

    /**
     * 获取初始化数据详情: 根据初始化唯一标识查询数据库
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return  项目数据初始化信息
     */
    ProjectDataInitializationDO getInitializationDataInfo(DataInitializationQuery dataInitializationQuery);

    /**
     * 更新初始化数据: 检查初始化唯一标识是否存在
     *
     * @param dataInitializationDTO 初始化项目数据的入参对象
     * @return
     */
    Boolean updateInitializationData(DataInitializationDTO dataInitializationDTO);

    /**
     * 删除初始化数据: 检查初始化唯一标识是否存在
     *
     * @param dataInitializationQuery 数据初始化信息查询条件
     * @return
     */
    Boolean deleteInitializationData(DataInitializationQuery dataInitializationQuery);
}

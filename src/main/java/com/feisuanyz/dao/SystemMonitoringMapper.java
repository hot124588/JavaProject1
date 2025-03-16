package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.SystemMonitoringDO;

/**
 * 系统监控信息Mapper接口
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface SystemMonitoringMapper extends BaseMapper<SystemMonitoringDO> {
    // 由于继承了BaseMapper，所以优先使用BaseMapper上提供的方法实现（推荐）
    // 没有自定义方法
}

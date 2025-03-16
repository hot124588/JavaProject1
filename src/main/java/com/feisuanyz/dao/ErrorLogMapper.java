package com.feisuanyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feisuanyz.pojo.domain.ErrorLogDO;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 错误日志Mapper接口
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
public interface ErrorLogMapper extends BaseMapper<ErrorLogDO> {

    /**
     * 根据条件查询错误日志
     *
     * @Param queryWrapper 查询条件
     * @Return 分页查询结果
     */
    IPage<ErrorLogDO> selectPage(IPage<ErrorLogDO> page, @Param("ew") QueryWrapper<ErrorLogDO> queryWrapper);
}

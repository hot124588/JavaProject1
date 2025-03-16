package com.feisuanyz.service.impl;

import com.feisuanyz.dao.ProjectDataInitializationMapper;
import com.feisuanyz.pojo.domain.ProjectDataInitializationDO;
import com.feisuanyz.pojo.dto.DataInitializationDTO;
import com.feisuanyz.pojo.query.DataInitializationQuery;
import com.feisuanyz.service.DataInitializationService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import lombok.Data;
import java.util.Date;

/**
 * 数据初始化管理的实现
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Service
public class DataInitializationServiceImpl implements DataInitializationService {

    @Autowired
    private ProjectDataInitializationMapper projectDataInitializationMapper;

    @Override
    public Boolean initializeProjectData(DataInitializationDTO dataInitializationDTO) {
        QueryWrapper<ProjectDataInitializationDO> wrapper = new QueryWrapper<>();
        wrapper.eq("initialization_id", dataInitializationDTO.getInitializationId());
        ProjectDataInitializationDO existingData = projectDataInitializationMapper.selectOne(wrapper);
        if (existingData != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProjectDataInitializationDO newData = new ProjectDataInitializationDO();
        BeanUtils.copyProperties(dataInitializationDTO, newData);
        newData.setInitializationTime(new Date());
        newData.setCreateTime(new Date());
        newData.setStatus("active");
        int result = projectDataInitializationMapper.insert(newData);
        return result > 0;
    }

    @Override
    public ProjectDataInitializationDO getInitializationDataInfo(DataInitializationQuery dataInitializationQuery) {
        QueryWrapper<ProjectDataInitializationDO> wrapper = new QueryWrapper<>();
        wrapper.eq("initialization_id", dataInitializationQuery.getInitializationId());
        ProjectDataInitializationDO data = projectDataInitializationMapper.selectOne(wrapper);
        if (data == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return data;
    }

    @Override
    public Boolean updateInitializationData(DataInitializationDTO dataInitializationDTO) {
        QueryWrapper<ProjectDataInitializationDO> wrapper = new QueryWrapper<>();
        wrapper.eq("initialization_id", dataInitializationDTO.getInitializationId());
        ProjectDataInitializationDO existingData = projectDataInitializationMapper.selectOne(wrapper);
        if (existingData == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProjectDataInitializationDO updatedData = new ProjectDataInitializationDO();
        BeanUtils.copyProperties(dataInitializationDTO, updatedData);
        updatedData.setUpdateTime(new Date());
        int result = projectDataInitializationMapper.update(updatedData, wrapper);
        return result > 0;
    }

    @Override
    public Boolean deleteInitializationData(DataInitializationQuery dataInitializationQuery) {
        QueryWrapper<ProjectDataInitializationDO> wrapper = new QueryWrapper<>();
        wrapper.eq("initialization_id", dataInitializationQuery.getInitializationId());
        ProjectDataInitializationDO existingData = projectDataInitializationMapper.selectOne(wrapper);
        if (existingData == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        int result = projectDataInitializationMapper.delete(wrapper);
        return result > 0;
    }
}

package com.feisuanyz.service.impl;

import com.feisuanyz.dao.PasswordResetMapper;
import com.feisuanyz.dao.UserMapper;
import com.feisuanyz.pojo.dto.PasswordResetDTO;
import com.feisuanyz.pojo.dto.ResetPasswordDTO;
import com.feisuanyz.service.PasswordResetService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import java.util.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feisuanyz.pojo.domain.UserDO;
import com.feisuanyz.pojo.domain.PasswordResetDO;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 密码重置管理的实现
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordResetMapper passwordResetMapper;

    @Override
    @Transactional
    public Boolean requestPasswordReset(PasswordResetDTO passwordResetDTO) {
        UserDO userDO = userMapper.selectById(passwordResetDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (!userDO.getEmail().equals(passwordResetDTO.getEmail()) && !userDO.getPhone().equals(passwordResetDTO.getPhone())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        String resetToken = UUID.randomUUID().toString();
        // 1小时后过期
        Date tokenExpiration = new Date(new Date().getTime() + 3600000);
        PasswordResetDO passwordResetDO = new PasswordResetDO();
        passwordResetDO.setUserId(userDO.getId());
        passwordResetDO.setEmail(userDO.getEmail());
        passwordResetDO.setPhone(userDO.getPhone());
        passwordResetDO.setResetToken(resetToken);
        passwordResetDO.setTokenExpiration(tokenExpiration);
        passwordResetDO.setCreateBy(userDO.getId());
        passwordResetDO.setCreateTime(new Date());
        passwordResetDO.setUpdateBy(userDO.getId());
        passwordResetDO.setUpdateTime(new Date());
        passwordResetMapper.insert(passwordResetDO);
        return true;
    }

    @Override
    @Transactional
    public Boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
        QueryWrapper<PasswordResetDO> wrapper = Wrappers.<PasswordResetDO>query().eq("reset_token", resetPasswordDTO.getResetToken());
        PasswordResetDO passwordResetDO = passwordResetMapper.selectOne(wrapper);
        if (passwordResetDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (passwordResetDO.getTokenExpiration().before(new Date())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = userMapper.selectById(passwordResetDO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 示例密码哈希
        String passwordHash = UUID.randomUUID().toString();
        userDO.setPasswordHash(passwordHash);
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        passwordResetMapper.deleteById(passwordResetDO.getResetId());
        return true;
    }

    @Override
    public Boolean validateResetToken(PasswordResetDTO passwordResetDTO) {
        QueryWrapper<PasswordResetDO> wrapper = Wrappers.<PasswordResetDO>query().eq("reset_token", passwordResetDTO.getResetToken());
        PasswordResetDO passwordResetDO = passwordResetMapper.selectOne(wrapper);
        if (passwordResetDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (passwordResetDO.getTokenExpiration().before(new Date())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return true;
    }
}

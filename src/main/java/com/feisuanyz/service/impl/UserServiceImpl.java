package com.feisuanyz.service.impl;

import com.feisuanyz.dao.UserMapper;
import com.feisuanyz.pojo.domain.UserDO;
import com.feisuanyz.pojo.dto.UserDTO;
import com.feisuanyz.pojo.dto.UserLoginDTO;
import com.feisuanyz.pojo.query.UserQuery;
import com.feisuanyz.service.UserService;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.feisuanyz.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.feisuanyz.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 用户注册与登录管理的实现
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Boolean registerUser(UserDTO userDTO) {
        QueryWrapper<UserDO> usernameWrapper = Wrappers.query();
        usernameWrapper.eq("username", userDTO.getUsername());
        if (userMapper.selectCount(usernameWrapper) > 0) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> emailWrapper = Wrappers.query();
        emailWrapper.eq("email", userDTO.getEmail());
        if (userMapper.selectCount(emailWrapper) > 0) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(userDTO.getUsername());
        userDO.setPasswordHash(generatePasswordHash(userDTO.getPassword()));
        userDO.setEmail(userDTO.getEmail());
        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());
        int result = userMapper.insert(userDO);
        return result > 0;
    }

    @Override
    public Boolean loginUser(UserLoginDTO userLoginDTO) {
        QueryWrapper<UserDO> wrapper = Wrappers.query();
        wrapper.eq("username", userLoginDTO.getUsernameOrEmail()).or().eq("email", userLoginDTO.getUsernameOrEmail());
        UserDO userDO = userMapper.selectOne(wrapper);
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (!userDO.getPasswordHash().equals(generatePasswordHash(userLoginDTO.getPassword()))) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO loginRecord = new UserDO();
        loginRecord.setId(userDO.getId());
        loginRecord.setLoginTime(new Date());
        int result = userMapper.updateById(loginRecord);
        return result > 0;
    }

    @Override
    public UserDO userInfo(UserQuery userQuery) {
        UserDO userDO = userMapper.selectById(userQuery.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return userDO;
    }

    @Override
    @Transactional
    public Boolean updateUsername(UserDTO userDTO) {
        QueryWrapper<UserDO> wrapper = Wrappers.query();
        wrapper.eq("username", userDTO.getNewUsername());
        if (userMapper.selectCount(wrapper) > 0) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setId(userDTO.getUserId());
        userDO.setUsername(userDTO.getNewUsername());
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    @Transactional
    public Boolean updatePassword(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setId(userDTO.getUserId());
        userDO.setPasswordHash(generatePasswordHash(userDTO.getNewPassword()));
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateEmail(UserDTO userDTO) {
        QueryWrapper<UserDO> wrapper = Wrappers.query();
        wrapper.eq("email", userDTO.getNewEmail());
        if (userMapper.selectCount(wrapper) > 0) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setId(userDTO.getUserId());
        userDO.setEmail(userDTO.getNewEmail());
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    public Boolean updateUsername1(UserDTO userDTO) {
        UserDO userDO = userMapper.selectById(userDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> wrapper = Wrappers.query();
        wrapper.eq("username", userDTO.getNewUsername());
        if (userMapper.selectOne(wrapper) != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000002, ResultCodeConstant.CODE_000002_MSG);
        }
        userDO.setUsername(userDTO.getNewUsername());
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    public Boolean updatePassword1(UserDTO userDTO) {
        UserDO userDO = userMapper.selectById(userDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (!userDO.getPasswordHash().equals(userDTO.getOldPassword())) {
            throw new BusinessException(ResultCodeConstant.CODE_000003, ResultCodeConstant.CODE_000003_MSG);
        }
        userDO.setPasswordHash(userDTO.getNewPassword());
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    public Boolean updateEmail1(UserDTO userDTO) {
        UserDO userDO = userMapper.selectById(userDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> wrapper = Wrappers.query();
        wrapper.eq("email", userDTO.getNewEmail());
        if (userMapper.selectOne(wrapper) != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000004, ResultCodeConstant.CODE_000004_MSG);
        }
        userDO.setEmail(userDTO.getNewEmail());
        userDO.setUpdateTime(new Date());
        userMapper.updateById(userDO);
        return true;
    }

    @Override
    public UserDO userInfo1(UserQuery userQuery) {
        UserDO userDO = userMapper.selectById(userQuery.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return userDO;
    }

    @Override
    public Boolean addUser(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setUsername(userDTO.getUsername());
        userDO.setPasswordHash(userDTO.getPasswordHash());
        userDO.setEmail(userDTO.getEmail());
        userDO.setCreateTime(new Date());
        userMapper.insert(userDO);
        return true;
    }

    @Override
    public Boolean deleteUser(UserDTO userDTO) {
        userMapper.deleteById(userDTO.getUserId());
        return true;
    }

    private String generatePasswordHash(String password) {
        // 模拟生成密码哈希的过程
        return "hashed_" + password;
    }
}

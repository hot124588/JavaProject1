package com.feisuanyz.service;

import com.feisuanyz.pojo.domain.UserDO;
import com.feisuanyz.pojo.dto.UserDTO;
import com.feisuanyz.pojo.dto.UserLoginDTO;
import com.feisuanyz.pojo.query.UserQuery;
import java.lang.Boolean;

/**
 * 用户注册与登录管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface UserService {

    /**
     * 用户注册:验证用户名是否唯一、验证邮箱是否唯一、验证输入参数格式、生成密码哈希、保存用户信息到数据库
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean registerUser(UserDTO userDTO);

    /**
     * 用户登录:验证用户名或邮箱是否存在、验证密码是否正确、记录登录信息到数据库
     *
     * @param userLoginDTO 用户登录数据传输对象
     * @return
     */
    Boolean loginUser(UserLoginDTO userLoginDTO);

    /**
     * 查询用户信息:验证用户ID是否存在、从数据库获取用户信息
     *
     * @param userQuery 用户查询数据传输对象
     * @return  用户数据对象
     */
    UserDO userInfo(UserQuery userQuery);

    /**
     * 修改用户名:验证新用户名是否唯一、更新用户名
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updateUsername(UserDTO userDTO);

    /**
     * 修改密码:生成新密码哈希、更新密码
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updatePassword(UserDTO userDTO);

    /**
     * 修改邮箱:验证新邮箱是否唯一、更新邮箱
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updateEmail(UserDTO userDTO);

    /**
     * 修改用户名:如果用户信息不存在，返回失败信息；如果新用户名已存在，返回失败信息；否则更新用户名
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updateUsername1(UserDTO userDTO);

    /**
     * 修改密码:如果用户信息不存在，返回失败信息；如果旧密码不匹配，返回失败信息；否则更新密码
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updatePassword1(UserDTO userDTO);

    /**
     * 修改邮箱:如果用户信息不存在，返回失败信息；如果新邮箱已存在，返回失败信息；否则更新邮箱
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean updateEmail1(UserDTO userDTO);

    /**
     * 查询用户信息:如果用户信息不存在，返回失败信息；否则获取用户信息
     *
     * @param userQuery 用户查询数据传输对象
     * @return  用户数据对象
     */
    UserDO userInfo1(UserQuery userQuery);

    /**
     * 添加用户:添加新用户
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean addUser(UserDTO userDTO);

    /**
     * 删除用户:删除用户信息
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    Boolean deleteUser(UserDTO userDTO);
}

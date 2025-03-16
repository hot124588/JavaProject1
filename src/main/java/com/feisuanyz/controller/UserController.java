package com.feisuanyz.controller;

import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.domain.UserDO;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.DeleteGroup;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.pojo.dto.UserDTO;
import com.feisuanyz.pojo.dto.UserLoginDTO;
import com.feisuanyz.pojo.query.QueryGroup;
import com.feisuanyz.pojo.query.UserQuery;
import com.feisuanyz.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册与登录管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Tag(name = "用户注册与登录管理")
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册:验证用户名是否唯一、验证邮箱是否唯一、验证输入参数格式、生成密码哈希、保存用户信息到数据库
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "用户注册:验证用户名是否唯一、验证邮箱是否唯一、验证输入参数格式、生成密码哈希、保存用户信息到数据库")
    @ResponseBody
    public RestResult<Boolean> registerUser(@RequestBody @Validated(CreateGroup.class) UserDTO userDTO) {
        Boolean result = userService.registerUser(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 用户登录:验证用户名或邮箱是否存在、验证密码是否正确、记录登录信息到数据库
     *
     * @param userLoginDTO 用户登录数据传输对象
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "用户登录:验证用户名或邮箱是否存在、验证密码是否正确、记录登录信息到数据库")
    @ResponseBody
    public RestResult<Boolean> loginUser(@RequestBody @Validated UserLoginDTO userLoginDTO) {
        Boolean result = userService.loginUser(userLoginDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询用户信息:验证用户ID是否存在、从数据库获取用户信息
     *
     * @param userQuery 用户查询数据传输对象
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "查询用户信息:验证用户ID是否存在、从数据库获取用户信息")
    public RestResult<UserDO> userInfo(@Validated(QueryGroup.class) UserQuery userQuery) {
        UserDO result = userService.userInfo(userQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改用户名:验证新用户名是否唯一、更新用户名
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/updateUsername", method = RequestMethod.PUT)
    @Operation(summary = "修改用户名:验证新用户名是否唯一、更新用户名")
    @ResponseBody
    public RestResult<Boolean> updateUsername(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updateUsername(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改密码:生成新密码哈希、更新密码
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    @Operation(summary = "修改密码:生成新密码哈希、更新密码")
    @ResponseBody
    public RestResult<Boolean> updatePassword(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updatePassword(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改邮箱:验证新邮箱是否唯一、更新邮箱
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/updateEmail", method = RequestMethod.PUT)
    @Operation(summary = "修改邮箱:验证新邮箱是否唯一、更新邮箱")
    @ResponseBody
    public RestResult<Boolean> updateEmail(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updateEmail(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改用户名:如果用户信息不存在，返回失败信息；如果新用户名已存在，返回失败信息；否则更新用户名
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/update/username", method = RequestMethod.PUT)
    @Operation(summary = "修改用户名:如果用户信息不存在，返回失败信息；如果新用户名已存在，返回失败信息；否则更新用户名")
    @ResponseBody
    public RestResult<Boolean> updateUsername1(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updateUsername1(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改密码:如果用户信息不存在，返回失败信息；如果旧密码不匹配，返回失败信息；否则更新密码
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/update/password", method = RequestMethod.PUT)
    @Operation(summary = "修改密码:如果用户信息不存在，返回失败信息；如果旧密码不匹配，返回失败信息；否则更新密码")
    @ResponseBody
    public RestResult<Boolean> updatePassword1(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updatePassword1(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改邮箱:如果用户信息不存在，返回失败信息；如果新邮箱已存在，返回失败信息；否则更新邮箱
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/update/email", method = RequestMethod.PUT)
    @Operation(summary = "修改邮箱:如果用户信息不存在，返回失败信息；如果新邮箱已存在，返回失败信息；否则更新邮箱")
    @ResponseBody
    public RestResult<Boolean> updateEmail1(@RequestBody @Validated(UpdateGroup.class) UserDTO userDTO) {
        Boolean result = userService.updateEmail1(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询用户信息:如果用户信息不存在，返回失败信息；否则获取用户信息
     *
     * @param userQuery 用户查询数据传输对象
     * @return
     */
    @RequestMapping(value = "/info1", method = RequestMethod.GET)
    @Operation(summary = "查询用户信息:如果用户信息不存在，返回失败信息；否则获取用户信息")
    public RestResult<UserDO> userInfo1(@Validated(QueryGroup.class) UserQuery userQuery) {
        UserDO result = userService.userInfo1(userQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 添加用户:添加新用户
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "添加用户:添加新用户")
    @ResponseBody
    public RestResult<Boolean> addUser(@RequestBody @Validated(CreateGroup.class) UserDTO userDTO) {
        Boolean result = userService.addUser(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除用户:删除用户信息
     *
     * @param userDTO 用户数据传输对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除用户:删除用户信息")
    @ResponseBody
    public RestResult<Boolean> deleteUser(@RequestBody @Validated(DeleteGroup.class) UserDTO userDTO) {
        Boolean result = userService.deleteUser(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

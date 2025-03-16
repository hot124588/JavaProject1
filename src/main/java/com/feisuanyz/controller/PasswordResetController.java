package com.feisuanyz.controller;

import com.feisuanyz.constant.ResultCodeConstant;
import com.feisuanyz.pojo.dto.CreateGroup;
import com.feisuanyz.pojo.dto.PasswordResetDTO;
import com.feisuanyz.pojo.dto.ResetPasswordDTO;
import com.feisuanyz.pojo.dto.RestResult;
import com.feisuanyz.pojo.dto.UpdateGroup;
import com.feisuanyz.service.PasswordResetService;
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
 * 密码重置管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Tag(name = "密码重置管理")
@RequestMapping("passwordReset")
@RestController
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    /**
     * 请求密码重置
     *
     * @param passwordResetDTO 密码重置请求入参
     * @return
     */
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @Operation(summary = "请求密码重置")
    @ResponseBody
    public RestResult<Boolean> requestPasswordReset(@RequestBody @Validated(CreateGroup.class) PasswordResetDTO passwordResetDTO) {
        Boolean result = passwordResetService.requestPasswordReset(passwordResetDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 重置密码
     *
     * @param resetPasswordDTO 重置密码入参
     * @return
     */
    @RequestMapping(value = "/reset", method = RequestMethod.PUT)
    @Operation(summary = "重置密码")
    public RestResult<Boolean> resetPassword(@Validated(UpdateGroup.class) ResetPasswordDTO resetPasswordDTO) {
        Boolean result = passwordResetService.resetPassword(resetPasswordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 验证重置令牌有效性
     *
     * @param passwordResetDTO 密码重置请求入参
     * @return
     */
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @Operation(summary = "验证重置令牌有效性")
    @ResponseBody
    public RestResult<Boolean> validateResetToken(@RequestBody @Validated(UpdateGroup.class) PasswordResetDTO passwordResetDTO) {
        Boolean result = passwordResetService.validateResetToken(passwordResetDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}

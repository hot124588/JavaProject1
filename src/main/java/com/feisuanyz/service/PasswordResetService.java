package com.feisuanyz.service;

import com.feisuanyz.pojo.dto.PasswordResetDTO;
import com.feisuanyz.pojo.dto.ResetPasswordDTO;
import java.lang.Boolean;

/**
 * 密码重置管理
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
public interface PasswordResetService {

    /**
     * 请求密码重置
     *
     * @param passwordResetDTO 密码重置请求入参
     * @return
     */
    Boolean requestPasswordReset(PasswordResetDTO passwordResetDTO);

    /**
     * 重置密码
     *
     * @param resetPasswordDTO 重置密码入参
     * @return
     */
    Boolean resetPassword(ResetPasswordDTO resetPasswordDTO);

    /**
     * 验证重置令牌有效性
     *
     * @param passwordResetDTO 密码重置请求入参
     * @return
     */
    Boolean validateResetToken(PasswordResetDTO passwordResetDTO);
}

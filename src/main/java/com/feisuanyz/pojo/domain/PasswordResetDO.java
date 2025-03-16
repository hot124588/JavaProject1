package com.feisuanyz.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

/**
 * 密码重置信息实体
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("password_reset")
public class PasswordResetDO {

    @TableId(type = IdType.AUTO)
    private Integer resetId;

    private Integer userId;

    private String email;

    private String phone;

    private String resetToken;

    private Date tokenExpiration;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;
}

package com.feisuanyz.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户数据对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_info")
public class UserDO {

    // 用户ID:用户唯一标识
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户ID:用户唯一标识")
    private Integer id;

    // 用户名:用户名
    @TableField("username")
    @Schema(description = "用户名:用户名")
    private String username;

    // 密码哈希:密码哈希
    @TableField("password_hash")
    @Schema(description = "密码哈希:密码哈希")
    private String passwordHash;

    // 邮箱:邮箱
    @TableField("email")
    @Schema(description = "邮箱:邮箱")
    private String email;

    // 创建人:创建人
    @TableField("create_by")
    @Schema(description = "创建人:创建人")
    private Integer createBy;

    // 创建时间:创建时间
    @TableField("create_time")
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    // 修改人:修改人
    @TableField("update_by")
    @Schema(description = "修改人:修改人")
    private Integer updateBy;

    // 修改时间:修改时间
    @TableField("update_time")
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;

    // 登录时间:登录时间
    @TableField("login_time")
    @Schema(description = "登录时间:登录时间")
    private Date loginTime;

    // 登出时间:登出时间
    @TableField("logout_time")
    @Schema(description = "登出时间:登出时间")
    private Date logoutTime;

    /**
     * 用户ID:用户ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户ID:用户ID")
    private Integer userId;
}

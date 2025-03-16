package com.feisuanyz.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户权限数据对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_permissions")
public class UserPermissionsDO {

    /**
     * 权限ID:自增主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "权限ID:自增主键")
    private Integer permissionId;

    /**
     * 用户ID:必填
     */
    @Schema(description = "用户ID:必填")
    private Integer userId;

    /**
     * 角色:必填
     */
    @Schema(description = "角色:必填")
    private String role;

    /**
     * 权限列表:可选
     */
    @Schema(description = "权限列表:可选")
    private String permissions;

    /**
     * 创建人:可选
     */
    @Schema(description = "创建人:可选")
    private Integer createBy;

    /**
     * 创建时间:默认当前时间
     */
    @Schema(description = "创建时间:默认当前时间")
    private Date createTime;

    /**
     * 修改人:可选
     */
    @Schema(description = "修改人:可选")
    private Integer updateBy;

    /**
     * 修改时间:默认当前时间，更新时自动更新
     */
    @Schema(description = "修改时间:默认当前时间，更新时自动更新")
    private Date updateTime;
}

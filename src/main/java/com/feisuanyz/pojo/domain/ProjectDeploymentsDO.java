package com.feisuanyz.pojo.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 项目部署信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@TableName("project_deployments")
public class ProjectDeploymentsDO {

    /**
     * 主键ID:主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    /**
     * 部署唯一标识:部署唯一标识
     */
    @Schema(description = "部署唯一标识:部署唯一标识")
    private String deploymentId;

    /**
     * 服务器环境:服务器环境
     */
    @Schema(description = "服务器环境:服务器环境")
    private String serverEnvironment;

    /**
     * 部署时间:部署时间
     */
    @Schema(description = "部署时间:部署时间")
    private Date deploymentTime;

    /**
     * 部署状态:部署状态
     */
    @Schema(description = "部署状态:部署状态")
    private String status;

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private String createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private String updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;
}

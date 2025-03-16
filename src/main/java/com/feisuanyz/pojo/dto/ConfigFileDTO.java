package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 接口名称:添加配置文件信息、更新配置文件信息、删除配置文件信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ConfigFileDTO {

    /**
     * 主键ID
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "主键ID不能为空")
    @Schema(description = "主键ID")
    private Integer id;

    /**
     * 配置文件名称
     */
    @NotBlank(groups = { CreateGroup.class }, message = "配置文件名称不能为空")
    @Schema(description = "配置文件名称")
    private String fileName;

    /**
     * 配置文件内容
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "配置文件内容不能为空")
    @Schema(description = "配置文件内容")
    private String fileContent;

    /**
     * 环境类型，如开发、测试、生产
     */
    @NotBlank(groups = { CreateGroup.class }, message = "环境类型不能为空")
    @Schema(description = "环境类型，如开发、测试、生产")
    private String environmentType;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}

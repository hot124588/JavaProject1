package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 维护操作实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class MaintenanceDTO {

    /**
     * 版本号:版本号，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "版本号不能为空")
    @Schema(description = "版本号:版本号，必填")
    private String version;

    /**
     * 备份名称:备份名称，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "备份名称不能为空")
    @Schema(description = "备份名称:备份名称，必填")
    private String backupName;

    /**
     * 维护唯一标识:维护唯一标识，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "维护唯一标识不能为空")
    @Schema(description = "维护唯一标识:维护唯一标识，必填")
    private String maintenanceId;
}

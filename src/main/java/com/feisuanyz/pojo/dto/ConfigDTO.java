package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 配置项DTO
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ConfigDTO {

    /**
     * 配置项键:必填
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "配置项键不能为空")
    @Schema(description = "配置项键:必填")
    private String configKey;

    /**
     * 配置项值:必填
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "配置项值不能为空")
    @Schema(description = "配置项值:必填")
    private String configValue;

    /**
     * 配置项描述
     */
    @Schema(description = "配置项描述")
    private String description;
}

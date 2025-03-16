package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 初始化项目数据的入参对象
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class DataInitializationDTO {

    /**
     * 初始化唯一标识: 初始化唯一标识，必填
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "初始化唯一标识不能为空")
    @Schema(description = "初始化唯一标识: 初始化唯一标识，必填")
    private String initializationId;

    /**
     * 初始化数据信息: 初始化数据信息，必填
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "初始化数据信息不能为空")
    @Schema(description = "初始化数据信息: 初始化数据信息，必填")
    private String dataInfo;
}

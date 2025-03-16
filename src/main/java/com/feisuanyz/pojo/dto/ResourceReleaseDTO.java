package com.feisuanyz.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.Size;
import com.feisuanyz.pojo.query.QueryGroup;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 资源释放入参实体类
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
public class ResourceReleaseDTO {

    /**
     * 资源名称:资源名称，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "资源名称不能为空")
    @Size(max = 255, message = "资源名称长度不能超过255")
    @Schema(description = "资源名称:资源名称，必填")
    private String resourceName;
}

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
 * 项目配置文件信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@TableName("project_config_files")
public class ProjectConfigFilesDO {

    // 主键ID:主键ID
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    // 配置文件名称:配置文件名称
    @Schema(description = "配置文件名称:配置文件名称")
    private String fileName;

    // 配置文件内容:配置文件内容
    @Schema(description = "配置文件内容:配置文件内容")
    private String fileContent;

    // 环境类型:环境类型，如开发、测试、生产
    @Schema(description = "环境类型:环境类型，如开发、测试、生产")
    private String environmentType;

    // 创建人:创建人
    @Schema(description = "创建人:创建人")
    private String createBy;

    // 创建时间:创建时间
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    // 修改人:修改人
    @Schema(description = "修改人:修改人")
    private String updateBy;

    // 修改时间:修改时间
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;
}

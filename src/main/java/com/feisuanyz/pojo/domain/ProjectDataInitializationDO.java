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
 * 项目数据初始化信息
 *
 * @author 95978
 * @date 2025-03-16 12:07:58
 */
@Data
@TableName("project_data_initialization")
public class ProjectDataInitializationDO {

    // 主键ID:主键ID
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID:主键ID")
    private Integer id;

    // 初始化唯一标识:初始化唯一标识
    @Schema(description = "初始化唯一标识:初始化唯一标识")
    private String initializationId;

    // 初始化数据信息:初始化数据信息
    @Schema(description = "初始化数据信息:初始化数据信息")
    private String dataInfo;

    // 初始化时间:初始化时间
    @Schema(description = "初始化时间:初始化时间")
    private Date initializationTime;

    // 初始化状态:初始化状态
    @Schema(description = "初始化状态:初始化状态")
    private String status;

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

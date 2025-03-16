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
 * 用户操作日志实体对象
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_activity_log")
public class UserActivityLogDO {

    /**
     * 日志ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "日志ID")
    private Integer logId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 活动描述
     */
    @Schema(description = "活动描述")
    private String activityDescription;

    /**
     * 活动时间
     */
    @Schema(description = "活动时间")
    private Date activityTime;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}

package com.ops.langchain.domain;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 大模型提供商信息表 实体类。
 *
 * @author Cleaner
 * @since 2025-09-16
 */
@Data
@Builder
@Table("model_provider")
public class ModelProviderDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 模型编号
     */
    private String modelSn;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 简介
     */
    private String description;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}

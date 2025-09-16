package com.ops.langchain.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ops.langchain.domain.ModelProviderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 大模型提供商信息表 映射层。
 *
 * @author Cleaner
 * @since 2025-09-16
 */
@Mapper
public interface ModelProviderMapper extends BaseMapper<ModelProviderDO> {

}

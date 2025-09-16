package com.ops.langchain.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ops.langchain.domain.ModelProviderDO;
import com.ops.langchain.mapper.ModelProviderMapper;
import com.ops.langchain.service.ModelProviderService;
import org.springframework.stereotype.Service;

/**
 * 大模型提供商信息表 服务层实现。
 *
 * @author Cleaner
 * @since 2025-09-16
 */
@Service
public class ModelProviderServiceImpl extends ServiceImpl<ModelProviderMapper, ModelProviderDO> implements ModelProviderService {

}

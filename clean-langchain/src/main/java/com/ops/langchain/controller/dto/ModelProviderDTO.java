package com.ops.langchain.controller.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author:Cleaner
 * Date: 2025/9/15 17:20
 **/
@Data
public class ModelProviderDTO implements Serializable {

    private String modelName;

    private String modelKey;
}

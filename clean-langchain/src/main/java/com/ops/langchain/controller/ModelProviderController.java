package com.ops.langchain.controller;

import com.mybatisflex.core.paginate.Page;
import com.ops.langchain.domain.ModelProviderDO;
import com.ops.langchain.service.ModelProviderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 大模型提供商信息表 控制层。
 *
 * @author Cleaner
 * @since 2025-09-16
 */
@RestController
@RequestMapping("/model/provider")
public class ModelProviderController {

    @Resource
    private ModelProviderService modelProviderService;

    /**
     * 保存大模型提供商信息表。
     *
     * @param modelProviderDO 大模型提供商信息表
     * @return {@code true} 保存成功，{@code false} 保存失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody ModelProviderDO modelProviderDO) {
        return modelProviderService.save(modelProviderDO);
    }

    /**
     * 根据主键删除大模型提供商信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return modelProviderService.removeById(id);
    }

    /**
     * 根据主键更新大模型提供商信息表。
     *
     * @param modelProviderDO 大模型提供商信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody ModelProviderDO modelProviderDO) {
        return modelProviderService.updateById(modelProviderDO);
    }

    /**
     * 查询所有大模型提供商信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<ModelProviderDO> list() {
        return modelProviderService.list();
    }

    /**
     * 根据主键获取大模型提供商信息表。
     *
     * @param id 大模型提供商信息表主键
     * @return 大模型提供商信息表详情
     */
    @GetMapping("getInfo/{id}")
    public ModelProviderDO getInfo(@PathVariable Long id) {
        return modelProviderService.getById(id);
    }

    /**
     * 分页查询大模型提供商信息表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<ModelProviderDO> page(Page<ModelProviderDO> page) {
        return modelProviderService.page(page);
    }

}

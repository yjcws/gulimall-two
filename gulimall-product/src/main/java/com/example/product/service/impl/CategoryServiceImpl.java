package com.example.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.product.dao.CategoryDao;
import com.example.product.entity.CategoryEntity;
import com.example.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> findWithtree() {
        List<CategoryEntity> list = super.baseMapper.selectList(null);
        List<CategoryEntity> CategoryEntityList = list.stream().filter(e -> {
            return e.getParentCid() == 0;
        }).map(meun-> {
             meun.setChildren(findChildtree(meun, list));
            return meun;
        }).sorted((menu, menu2) -> {
            return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return CategoryEntityList;
    }

    private List<CategoryEntity> findChildtree(CategoryEntity meun, List<CategoryEntity> list) {
        List<CategoryEntity> collect = list.stream().filter(e -> {
            return e.getParentCid().equals(meun.getCatId());
        }).map(menu->{
            menu.setChildren(findChildtree(menu,list));
            return menu;
            //return menu.getSort()
        }).sorted((menu,menu1)->{
            return (menu.getSort() == null ? 0 : menu.getSort())-(menu1.getSort() == null ? 0 : menu1.getSort());
        }).collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removeBatchByids(Long[] catIds) {
        baseMapper.deleteBatchIds(Arrays.asList(catIds));
    }

    /**
     * 找到catelogId的完整路径
     * [父/子/孙]
     * @param catelogId
     * @return
     */
    //[2,29,20]
    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();

        //递归查询是否还有父节点
        List<Long> parentPath = findParentPath(catelogId, paths);

        //进行一个逆序排列
        Collections.reverse(parentPath);

        return (Long[]) parentPath.toArray(new Long[parentPath.size()]);
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {

        //1、收集当前节点id
        paths.add(catelogId);

        //根据当前分类id查询信息
        CategoryEntity byId = this.getById(catelogId);
        //如果当前不是父分类
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }

        return paths;
    }

}
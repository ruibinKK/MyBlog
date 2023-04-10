package com.ruibin.dao;

import com.ruibin.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    //新增保存分类
    int saveType(Type type);

    //根据id查询分类
    Type getType(Long id);

    //查询所有分类
    List<Type> getAllType();


    //根据分类名称来查询
    Type getTypeByName(String name);

    //编辑修改分类
    int updateType(Type type);

    //删除分类
    void deleteType(Long id);

    //查询分类和该分类下博客数目
    List<Type> getAllTypeAndBlog();
}

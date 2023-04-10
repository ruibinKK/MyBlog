package com.ruibin.service.Impl;

import com.ruibin.dao.TypeMapper;
import com.ruibin.pojo.Type;
import com.ruibin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeMapper.getAllTypeAndBlog();
    }
}

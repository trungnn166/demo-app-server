package com.dsvn.reactjs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
@Component
public class ModelMapperService<E, R> {
    @Autowired
    protected ModelMapper modelMapper;

    @SuppressWarnings("unchecked")
    public Class<E> getTypeClassEntity() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<E>) paramType.getActualTypeArguments()[0];
    }

    public E convertRequestToEntity(R request) {
        return modelMapper.map(request, getTypeClassEntity());
    }

}
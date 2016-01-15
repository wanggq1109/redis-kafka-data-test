package com.powerlong.dao;

import com.powerlong.model.USER;

public interface USERMapper {
    int deleteByPrimaryKey(Long id);

    int insert(USER record);

    int insertSelective(USER record);

    USER selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(USER record);

    int updateByPrimaryKey(USER record);
}
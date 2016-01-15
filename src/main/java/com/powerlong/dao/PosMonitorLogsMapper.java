package com.powerlong.dao;

import com.powerlong.model.PosMonitorLogs;

public interface PosMonitorLogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PosMonitorLogs record);

    int insertSelective(PosMonitorLogs record);

    PosMonitorLogs selectByPrimaryKey(Long id);

    PosMonitorLogs selectByCptId(String cptId);

    int updateByPrimaryKeySelective(PosMonitorLogs record);

    int updateByPrimaryKey(PosMonitorLogs record);
}
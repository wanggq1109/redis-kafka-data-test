package com.eci.data;

import org.springframework.util.Assert;

/**
 * Created by wgq on 15/11/20.
 */
public class DynamicDataSourceHolder {

    /**
     * 本地环境线程
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源类型
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        Assert.notNull(dataSourceType, "数据源不能为空...");
        contextHolder.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     * @return
     */
    public static String getDataSourceType() {
        return (String) contextHolder.get();
    }

    /**
     * 清除数据源类型
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }




}

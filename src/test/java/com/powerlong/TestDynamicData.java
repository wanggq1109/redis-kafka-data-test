package com.powerlong;

import com.eci.data.DynamicDataSourceGlobal;
import com.eci.data.DynamicDataSourceHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by wgq on 15/11/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-db.xml"})
public class TestDynamicData extends AbstractJUnit4SpringContextTests {

    @Autowired
    private JdbcTemplate jdbcTemplateDynamic;


    @Test
    public void testDynamicData() {
        String sql = "SELECT * FROM ECI.user ";
        //数据源120.24.54.227
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.DATA_SOURCE_227);
        System.out.println("------------>切换数据源到227");
        //
        List<Map<String, Object>> retList2 = jdbcTemplateDynamic.queryForList(sql);
        for(Map<String, Object> entityMap : retList2) {
            System.out.println("-------查询结果:"+entityMap);
        }

        //数据源121.41.92.58
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.DATA_SOURCE_58);
        System.out.println("------------>切换数据源到58");
        //
        List<Map<String, Object>> retList1 = jdbcTemplateDynamic.queryForList(sql);
        for(Map<String, Object> entityMap : retList1) {
            System.out.println("-------查询结果:"+entityMap);
        }
    }
}

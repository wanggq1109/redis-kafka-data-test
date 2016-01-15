package com.eci;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @Project : spring-data-redis-demo
 * @Package : com.sondon.mayi.spring_redis.test
 * @Class : SpringRedis.java
 * @Blog：http://blog.csdn.net/caiwenfeng_for_23
 * @Description : {}
 */
public class SpringRedis {

    @Test
    public void testSpringRedis() {
        ConfigurableApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("spring.xml");
            StringRedisTemplate stringRedisTemplate = ctx.getBean("stringRedisTemplate", StringRedisTemplate.class);

            // String读写
            stringRedisTemplate.delete("myStr");
            stringRedisTemplate.opsForValue().set("myStr", "http://www.baidu.com/");
            System.out.println(stringRedisTemplate.opsForValue().get("myStr"));
            System.out.println("---------------");

            // List读写
            stringRedisTemplate.delete("myList");
            stringRedisTemplate.opsForList().rightPush("myList", "E");
            stringRedisTemplate.opsForList().rightPush("myList", "C");
            stringRedisTemplate.opsForList().leftPush("myList", "I");
            List<String> listCache = stringRedisTemplate.opsForList().range(
                    "myList", 0, -1);
            for (String s : listCache) {
                System.out.println(s);
            }
            System.out.println("---------------");

            // Set读写
            stringRedisTemplate.delete("mySet");
            stringRedisTemplate.opsForSet().add("mySet", "A");
            stringRedisTemplate.opsForSet().add("mySet", "B");
            stringRedisTemplate.opsForSet().add("mySet", "C");
            Set<String> setCache = stringRedisTemplate.opsForSet().members("mySet");
            for (String s : setCache) {
                System.out.println(s);
            }
            System.out.println("---------------");

            // Hash读写
            stringRedisTemplate.delete("myHash");
            stringRedisTemplate.opsForHash().put("myHash", "PEK", "北京");
            stringRedisTemplate.opsForHash().put("myHash", "SHA", "上海虹桥");
            stringRedisTemplate.opsForHash().put("myHash", "PVG", "浦东");
            Map<Object, Object> hashCache = stringRedisTemplate.opsForHash()
                    .entries("myHash");
            for (Map.Entry<Object, Object> entry : hashCache.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

            System.out.println("---------------");
        } finally {
            if (ctx != null && ctx.isActive()) {
                ctx.close();
            }
        }

    }

}

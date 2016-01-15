package com.eci.kafka;

import com.alibaba.fastjson.JSONObject;
import com.eci.kafka.consumer.MsgHandler;
import com.eci.kafka.model.TestMsg;
import com.eci.kafka.support.Topic;
import com.eci.kafka.support.TopicHelper;
import org.apache.log4j.Logger;

/**
 * Created by wgq on 15/11/25.
 */
public class TestMsgHandler implements MsgHandler<TestMsg> {

    private static final Logger logger = Logger.getLogger(TestMsgHandler.class);

    @Override
    public Topic getTopic() {
        return TopicHelper.TEST_TEST;
    }

    @Override
    public void execute(TestMsg testMsg) {


        logger.info("收到的消息是：=========>"+JSONObject.toJSON(testMsg));


    }
}

package com.eci;

import com.eci.kafka.KafkaLocator;
import com.eci.kafka.model.TestMsg;
import com.eci.kafka.producter.MsgSender;
import com.eci.kafka.support.TopicHelper;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by wgq on 15/11/25.
 */
public class TestKafkaSendMessage {

    private static MsgSender<TestMsg> eciMessageSender = KafkaLocator.buildSender(TopicHelper.TEST_TEST);

    private static final Logger logger = Logger.getLogger(TestKafkaSendMessage.class);

   @Test
    public void testName() throws Exception {

        TestMsg msg  = new TestMsg();

        msg.setName("eci2");
        msg.setContent("welcome eci2");
        eciMessageSender.sendMessage(msg);





    }
}

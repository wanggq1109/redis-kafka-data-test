package com.eci.mq;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by wgq on 16/1/6.
 */
public class ActivemqMessageReceiverListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {

        System.out.println("收到一条消息");
        System.out.println("消息内容是：" + message.getText());
        MessageProducer producer = session.createProducer(destination);
        TextMessage replyMsg = session.createTextMessage();
        replyMsg.setJMSCorrelationID(replyMsg.getJMSCorrelationID());
        replyMsg.setText("ConsumerSessionAwareMessageListener已经接收到消息。。。。");
        producer.send(replyMsg);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}

package com.jiany.coupon.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 *  Kafka相关的的服务接口的定义
 * @author lenovo
 */
public interface IKafkaService {

    /**
     * 消费优惠券 Kafka 消息
     * @param record {@link ConsumerRecord}
     * */
    void consumeCouponKafkaMessage(ConsumerRecord<?, ?> record);
}

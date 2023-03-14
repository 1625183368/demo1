//package com.example.kafka.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaProducer {
//
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;
//
//    @GetMapping("/kafka/normal/{message}")
//    public void sendMessage1(@PathVariable("message") String normalMessage) {
//        // topic   --->   partition   -->  offset
//
//
//        //回调方法中监控消息是否发送成功 或 失败时做补偿处理
//        // success->SendResult<String, Object> result
//        // failure->Throwable ex
//        kafkaTemplate.send("topic1", normalMessage).addCallback(success ->{
//            //topic
//            String topic = success.getRecordMetadata().topic();
//            //分区
//            int partition = success.getRecordMetadata().partition();
//
//            long offset = success.getRecordMetadata().offset();
//
//            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
//
//        },failure ->{
//            System.out.println("消息发送失败"+failure.getMessage());
//        });
//    }
//
//}

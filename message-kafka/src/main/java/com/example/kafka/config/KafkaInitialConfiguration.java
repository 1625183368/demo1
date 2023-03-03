package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {
    @Bean
    public NewTopic initialTopic(){
        return new NewTopic("test-topic",8,(short) 2);
    }


    @Bean
    public NewTopic updateTopic(){
        return new NewTopic("test-topic",10,(short) 2);
    }
}

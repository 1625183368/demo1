//package com.example.xiaoheihe.config.mq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitConfig {
//    @Value("${mq.routingKey}")
//    private String routingKey;
//    @Value("${mq.directExchange}")
//    private String directExchange;
//
//    @Bean
//    public Queue queue1(){
//        //四个参数分别是队列名称，是否要持久化，是否排他的，是否自动删除
//        return new Queue("queue1",true,false,false);
//    }
////    @Bean
////    public Queue queueDelay(){
////        return new Queue("delay",true,false,false);
////    }
//    @Bean
//    public DirectExchange directExchange1(){
//        //定义direct交换机，参数分别为交换机名称，是否持久化，是否自动删除
//        return new DirectExchange(directExchange,true,false);
//    }
////    @Bean
////    public Exchange delayExchange1(){
////        //定义延迟交换机，方便实现延迟队列。前提是需要rabbitmq服务端安装一个插件，以便支持延迟交换机类型
////        Map<String, Object> args = new HashMap<>(2);
////        args.put("x-delayed-type", "direct");
////        return new CustomExchange("delayExchange1", "x-delayed-message", true, false, args);
////    }
//    @Bean
//    public Binding bindingQueue1(@Qualifier("queue1") Queue queue, DirectExchange directExchange1){
//        //把队列和交换机进行一个绑定。这里的routingKey使用的是队列名
//        return BindingBuilder.bind(queue).to(directExchange1).with(routingKey);
//    }
////    @Bean
////    public Binding bindingQueueDelay(Queue queueDelay, Exchange delayExchange1){
////        //其中的“delay”是routingKey
////        return BindingBuilder.bind(queueDelay).to(delayExchange1).with("delay").noargs();
////    }
//
//}

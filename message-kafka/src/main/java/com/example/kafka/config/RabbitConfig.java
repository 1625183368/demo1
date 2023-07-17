package com.example.kafka.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${mq.routingKey}")
    private String routingKey;
    @Value("${mq.directExchange}")
    private String directExchange;

    @Bean
    public Queue queue1(){
        //四个参数分别是队列名称，是否要持久化，是否排他的，是否自动删除
        return new Queue("queue1",true,false,false);
    }
//    @Bean
//    public Queue queueDelay(){
//        return new Queue("delay",true,false,false);
//    }
    @Bean
    public DirectExchange directExchange1(){
        //定义direct交换机，参数分别为交换机名称，是否持久化，是否自动删除
        return new DirectExchange(directExchange,true,false);
    }
//    @Bean
//    public Exchange delayExchange1(){
//        //定义延迟交换机，方便实现延迟队列。前提是需要rabbitmq服务端安装一个插件，以便支持延迟交换机类型
//        Map<String, Object> args = new HashMap<>(2);
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange("delayExchange1", "x-delayed-message", true, false, args);
//    }
    @Bean
    public Binding bindingQueue1(@Qualifier("queue1") Queue queue, @Qualifier("directExchange1") DirectExchange directExchange1){
        //把队列和交换机进行一个绑定。这里的routingKey使用的是队列名
        return BindingBuilder.bind(queue).to(directExchange1).with(routingKey);
    }
//    @Bean
//    public Binding bindingQueueDelay(Queue queueDelay, Exchange delayExchange1){
//        //其中的“delay”是routingKey
//        return BindingBuilder.bind(queueDelay).to(delayExchange1).with("delay").noargs();
//    }





    /**
     * 配置回调函数
     * */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("ConfirmCallback:     " + "相关数据：" + correlationData);
            System.out.println("ConfirmCallback:     " + "确认情况：" + ack);
            System.out.println("ConfirmCallback:     " + "原因：" + cause);
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("ReturnCallback:     " + "消息：" + message);
            System.out.println("ReturnCallback:     " + "回应码：" + replyCode);
            System.out.println("ReturnCallback:     " + "回应信息：" + replyText);
            System.out.println("ReturnCallback:     " + "交换机：" + exchange);
            System.out.println("ReturnCallback:     " + "路由键：" + routingKey);
        });

        return rabbitTemplate;
    }
}

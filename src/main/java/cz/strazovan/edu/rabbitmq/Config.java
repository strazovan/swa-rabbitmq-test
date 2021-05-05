package cz.strazovan.edu.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FanoutExchange direct() {
        // fanout exchange means that all messages sent to this exchange will be sent to all bound queues
        return new FanoutExchange("rengars_events_exchange");
    }


    @Bean(name = "statisticsQueue")
    public Queue statisticsEventsQueue() {
        // statistics own queue
        return new Queue("statistics_events_queue");
    }

    @Bean(name = "notificationsQueue")
    public Queue notificationsEventsQueue() {
        // statistics own queue
        return new Queue("notifications_events_queue");
    }


    @Bean
    public Binding binding(FanoutExchange exchange,
                           @Qualifier("statisticsQueue") Queue statisticsEventsQueue) {
        return BindingBuilder.bind(statisticsEventsQueue)
                .to(exchange);
    }

    @Bean
    public Binding notificationsBinding(FanoutExchange exchange,
                                        @Qualifier("notificationsQueue") Queue notificationsEventsQueue) {
        return BindingBuilder.bind(notificationsEventsQueue)
                .to(exchange);
    }

    @Bean
    public StatisticsReceiver statisticsReceiver() {
        return new StatisticsReceiver();
    }

    @Bean
    public NotificationsReceiver notificationsReceiver() {
        return new NotificationsReceiver();
    }

    @Bean
    public MarketplaceService sender() {
        return new MarketplaceService();
    }
}

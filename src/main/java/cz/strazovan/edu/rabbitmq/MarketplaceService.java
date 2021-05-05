package cz.strazovan.edu.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class MarketplaceService {

    //language=JSON
    private static final String MESSAGE = "{\n" +
            "  \"event_type\": \"OFFER_CREATED\",\n" +
            "  \"payload\": {\n" +
            "    \"name\": \"cool offer\",\n" +
            "    \"company\": \"cool company\",\n" +
            "    \"created\": \"2021-05-05T17:45:00Z\"\n" +
            "  }\n" +
            "}";
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange exchange;


    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        template.convertAndSend(exchange.getName(), "", MESSAGE);
        System.out.println("[Marketplace] Sent an event.");
    }
}

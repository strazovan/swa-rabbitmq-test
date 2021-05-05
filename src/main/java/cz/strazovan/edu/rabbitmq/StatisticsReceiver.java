package cz.strazovan.edu.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class StatisticsReceiver {

    @RabbitListener(queues = "#{statisticsQueue.name}")
    public void receive(String in) {
        System.out.println("[Statistics] " + in);
    }


}

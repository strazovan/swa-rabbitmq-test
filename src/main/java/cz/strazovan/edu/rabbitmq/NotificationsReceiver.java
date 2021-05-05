package cz.strazovan.edu.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class NotificationsReceiver {

    @RabbitListener(queues = "#{notificationsQueue.name}")
    public void receive(String in) {
        System.out.println("[Notifications] " + in);
    }

}

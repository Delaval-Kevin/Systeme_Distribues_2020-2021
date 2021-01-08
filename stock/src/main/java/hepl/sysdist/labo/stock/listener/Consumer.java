package hepl.sysdist.labo.stock.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer
{

    @JmsListener(destination = "stock.queue")
    public void consume(String message){
        System.out.println(message);
    }

}

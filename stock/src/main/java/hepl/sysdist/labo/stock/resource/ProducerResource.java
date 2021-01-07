package hepl.sysdist.labo.stock.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.util.HashMap;

@RestController
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{article}/publish")
    public void publish(@PathVariable("article") int article){
        jmsTemplate.convertAndSend(queue, "test");
    }
}

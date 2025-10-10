package br.com.nildoSantos.infrastructure.messaging.component;

import br.com.nildoSantos.domain.entities.ClienteEntity;
import br.com.nildoSantos.domain.services.MailHogService;
import br.com.nildoSantos.infrastructure.messaging.RabbitMQConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Consumer {

    @Autowired
    private MailHogService mailHog;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recebeMensagem(ClienteEntity cliente){
        try{
            mailHog.envioDeEmail(cliente.getEmail(), cliente.getNome(), "Entrou na fila.");
        }catch (Exception e){
           System.out.println("Errou ao enviar pra fila: "+ e.getMessage());
        }
    }
}

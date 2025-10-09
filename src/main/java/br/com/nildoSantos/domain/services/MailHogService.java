package br.com.nildoSantos.domain.services;

import br.com.nildoSantos.domain.interfaces.MailHog;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Data
public class MailHogService implements MailHog {


    private final JavaMailSender mailSender;

    public MailHogService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void envioDeEmail(String to, String subject, String body) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(mimeMessage);

            System.out.println("Envio de email com sucesso! destinatario: "+ to);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

package br.com.nildoSantos.domain.interfaces;

public interface MailHog {
    void envioDeEmail(String to, String subject, String body);
}

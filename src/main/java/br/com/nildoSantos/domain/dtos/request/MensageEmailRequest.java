package br.com.nildoSantos.domain.dtos.request;

import lombok.Data;

@Data
public class MensageEmailRequest {
    private String to;
    private String subject;
    private String body;
}

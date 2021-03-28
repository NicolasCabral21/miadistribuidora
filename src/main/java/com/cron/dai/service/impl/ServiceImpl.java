package com.cron.dai.service.impl;

import com.cron.dai.model.Result;
import com.cron.dai.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.Properties;

@Slf4j
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void getDai() throws MessagingException {
        log.info("init getDai method");

        String url = "https://be.buenbit.com/api/market/tickers/";

        Result result = restTemplate.getForObject(url, Result.class);

        BigDecimal sellingPrice = BigDecimal.valueOf(Double.parseDouble(result.getObject().getDaiars().getSelling_price()));
        if(sellingPrice.compareTo(BigDecimal.valueOf(148)) <= 0){
            sendEmail(sellingPrice);
        }
    }

    void sendEmail(BigDecimal quotation) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nicolas.julian.cabral", "46627593");
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("nicolas.julian.cabral@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nicolas_cabral21@hotmail.com"));

        message.setSubject("Nueva cotizacion de DAI");
        String body = String.format("Compra: %s", quotation);
        message.setContent(body, "text/html; charset=utf-8");
        message.setText(body);
        Transport.send(message);
        log.info("email was sent");
    }
}

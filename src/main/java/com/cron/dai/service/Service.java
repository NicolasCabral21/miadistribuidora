package com.cron.dai.service;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Service {
    void getDai() throws IOException, MessagingException;
}

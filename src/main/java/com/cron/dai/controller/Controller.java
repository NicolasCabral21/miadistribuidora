package com.cron.dai.controller;

import com.cron.dai.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@EnableScheduling
@RestController
@RequestMapping("/cron")
public class Controller {

	@Autowired
	private Service service;

	@Scheduled(cron = "0 0 0/2 1/1 * ?")
	@GetMapping("/dai")
	public ResponseEntity<String> getDai() throws IOException, MessagingException {
		service.getDai();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

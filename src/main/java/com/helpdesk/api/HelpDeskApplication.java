package com.helpdesk.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpDeskApplication {

	private static final Logger log = LoggerFactory.getLogger(HelpDeskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
		log.info("Help Desk API iniciado com sucesso.");
	}

}

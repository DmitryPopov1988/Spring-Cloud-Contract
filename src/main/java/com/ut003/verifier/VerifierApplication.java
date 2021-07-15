package com.ut003.verifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class VerifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifierApplication.class, args);
	}

}

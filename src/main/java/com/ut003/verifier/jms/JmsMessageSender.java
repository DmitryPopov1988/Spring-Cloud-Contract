package com.ut003.verifier.jms;

import static java.lang.System.lineSeparator;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JmsMessageSender {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(String ut003) {
        jmsTemplate.send("GAS.AFMS", session -> session.createTextMessage(ut003));

        log.info("JMS Message was sent to the queue with next payload: " + lineSeparator() + ut003);
    }

}

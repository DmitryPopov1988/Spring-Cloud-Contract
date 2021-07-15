package com.ut003.verifier;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.verifier.converter.YamlContract;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Primary
@Component
public class JmsMessageVerifier implements MessageVerifier {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Object receive(String destination, long timeout, TimeUnit timeUnit) {
        return receiveMessage(destination);
    }

    @Override
    public Object receive(String destination) {
        return receiveMessage(destination);
    }

    @Override
    public void send(Object message, String destination) {
        sendMessage((String) message, destination);
    }

    @Override
    public void send(Object payload, Map headers, String destination) {
        sendMessage((String) payload, destination);

    }

    @Override
    public Object receive(String destination, long timeout, TimeUnit timeUnit, @Nullable YamlContract contract) {
        return receiveMessage(destination);
    }

    @Override
    public Object receive(String destination, YamlContract contract) {
        return receiveMessage(destination);
    }

    @Override
    public void send(Object message, String destination, @Nullable YamlContract contract) {
        sendMessage((String) message, destination);

    }

    @Override
    public void send(Object payload, Map headers, String destination, @Nullable YamlContract contract) {
        sendMessage((String) payload, destination);
    }

    private void sendMessage(String message, String destination) {
        jmsTemplate.send(destination, session -> session.createTextMessage(message));
    }

    @SneakyThrows
    private Object receiveMessage(String queueName) {
        return jmsTemplate.receive(queueName);
    }

}

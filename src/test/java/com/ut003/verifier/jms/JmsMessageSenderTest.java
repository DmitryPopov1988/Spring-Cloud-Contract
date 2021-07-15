package com.ut003.verifier.jms;

import static java.nio.file.Files.readAllBytes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.ResourceUtils.getFile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import lombok.SneakyThrows;

@SpringBootTest
class JmsMessageSenderTest {

    private static final String UT003_FLOW = readMessageFromFile();
    private static final String GAS_AFMS = "GAS.AFMS";

    @Autowired
    private JmsMessageSender jmsMessageSender;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    @SneakyThrows
    void sendMessage() {
        jmsMessageSender.sendMessage(UT003_FLOW);

        String messageFromQ = (String) jmsTemplate.receiveAndConvert(GAS_AFMS);

        assertThat(messageFromQ).isEqualTo(UT003_FLOW);
    }

    @SneakyThrows
    private static String readMessageFromFile() {
        return new String(readAllBytes(getFile("classpath:contracts/UT003.xml").toPath()));
    }

}
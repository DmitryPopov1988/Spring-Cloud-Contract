package com.ut003.verifier;

import static java.nio.file.Files.readAllBytes;
import static org.springframework.util.ResourceUtils.getFile;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ut003.verifier.jms.JmsMessageSender;

import lombok.SneakyThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
public class ContractBaseClass {

    private static final String UT003_FLOW_MESSAGE = readMessageFromFile();

    @Autowired
    private JmsMessageSender jmsMessageSender;

    @SneakyThrows
    private static String readMessageFromFile() {
        return new String(readAllBytes(getFile("classpath:contracts/UT003.xml").toPath()));
    }

    public void sendMessage() {
        jmsMessageSender.sendMessage(UT003_FLOW_MESSAGE);
    }

}

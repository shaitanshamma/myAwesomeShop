package ru.shaitanshamma.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mail.MailSendingMessageHandler;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;


@Component
public class MailSendingConfig {
    //
//    @Value("smtp.gmail.com")
//    private String smptHost;
//
//    @Value("587")
//    private Integer smtpPort;
//
//    @Bean
//    public JavaMailSenderImpl mailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        mailSender.setHost(smptHost);
//        mailSender.setPort(587);
//        return mailSender;
//    }
//
//    @Bean
//    public MessageChannel smtpChannel() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    public IntegrationFlow sendMailFlow() {
//        return IntegrationFlows.from("smtpChannel")
//                .handle(Mail.outboundAdapter("smtp.gmail.com")
//                                .port(587)
//                                .credentials("name", "pass")
//                                .javaMailProperties(p -> {
//                                    p.put("mail.debug", "true");
//                                    p.put("mail.smtp.ssl.trust", "*");
//                                    p.put("mail.smtp.starttls.enable", "true");
//                                }),
//                        e -> e.id("sendMailEndpoint")).get();
//
//    }
//
//    @ServiceActivator(inputChannel = "smtpChannel", outputChannel = "nullChannel")
//    public MessageHandler mailsSenderMessagingHandler(Message<MailMessage> message) {
//
//        MailSendingMessageHandler mailSendingMessageHandler = new MailSendingMessageHandler(mailSender());
//        mailSendingMessageHandler.handleMessage(message);
//
//        return mailSendingMessageHandler;
//    }
    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}

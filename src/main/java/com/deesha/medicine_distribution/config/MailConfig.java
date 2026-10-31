// package com.deesha.medicine_distribution.config;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.JavaMailSenderImpl;

// import java.util.Properties;

// @Configuration
// public class MailConfig {

//     @Value("${spring.mail.host:smtp.gmail.com}")
//     private String host;

//    @Value("${spring.mail.port:587}")
//     private int port;

//     @Value("${spring.mail.username:}")
//     private String username;

//      @Value("${spring.mail.password:}")
//     private String password;


//     @Bean
//     public JavaMailSender javaMailSender() {

//         // Remove spaces that Google adds when it shows the App Password
//         String cleanUser = username.trim();
//         String cleanPass = password.replaceAll("\\s", "");

//         // Check what was loaded (the password itself is never printed)
//         System.out.println("MAIL USER = [" + cleanUser + "]");
//         System.out.println("MAIL PASS LENGTH = " + cleanPass.length() + " (should be 8)");

//         JavaMailSenderImpl sender = new JavaMailSenderImpl();
//         sender.setHost(host);
//         sender.setPort(port);
//         sender.setUsername(cleanUser);
//         sender.setPassword(cleanPass);

//         Properties props = sender.getJavaMailProperties();
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.smtp.connectiontimeout", "5000");
//         props.put("mail.smtp.timeout", "5000");
//         props.put("mail.smtp.writetimeout", "5000");

//         return sender;
//     }
// }






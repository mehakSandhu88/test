
package com.rbc.ipdEmerald.stub.config;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory; 
import org.springframework.jms.config.JmsListenerContainerFactory;

@configuration

public class MQConfiguration {

    @Bean 
    public JmsListenerContainerFactory ipdApprovalContainerFactory(
            @Qualifier("cachingJmsConnectionFactory") ConnectionFactory connectionFactory) { 
        DefaultJmsListenerContainerFactory factory = new Default JmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return factory;

}

}


package org.shop.config;

import org.shop.annotation.InjectRandomIntBeanPostProcessor;
import org.shop.annotation.InjectRandomIntTestClass;
import org.shop.aspects.LoggingAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataInitializerConfig.class,
        FactoryConfig.class,
        RepositoryConfig.class,
        ServiceConfig.class,
        LoggingAspect.class,
        InjectRandomIntTestClass.class,
        InjectRandomIntBeanPostProcessor.class})
public class AllConfig {

}

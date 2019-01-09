package org.shop.config;

import org.shop.repository.UserRepository;
import org.shop.repository.factory.UserRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class FactoryConfig {

    @Bean
    public UserRepositoryFactory userRepositoryFactory() {
        return new UserRepositoryFactory();
    }

    @Bean
    public UserRepository userRepository() {
        return userRepositoryFactory().createUserRepository();
    }

}
package org.shop.config;

import org.shop.repository.*;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class RepositoryConfig {

    @Autowired
    private Environment env;

    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        OrderMapRepository orderRepository = new OrderMapRepository();
        orderRepository.setSequence(env.getProperty("initialSequence", long.class));
        return orderRepository;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

//    @Bean(name = "UserRepository")
//    public UserRepository userRepository() {
//        return new UserRepositoryFactory();     // как-то по-другому наверное должно быть
//    }
}


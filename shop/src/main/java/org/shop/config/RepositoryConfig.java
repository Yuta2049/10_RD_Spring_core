package org.shop.config;

import org.shop.repository.*;
import org.shop.repository.map.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean(name = "ItemRepository")
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean(name = "OrderRepository")
    public OrderRepository orderRepository() {
        return new OrderMapRepository();
    }

    @Bean(name = "ProductRepository")
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean(name = "ProposalRepository")
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean(name = "SellerRepository")
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

//    @Bean(name = "UserRepository")
//    public UserRepository userRepository() {
//        return new UserRepositoryFactory();     // как-то по-другому наверное должно быть
//    }
}


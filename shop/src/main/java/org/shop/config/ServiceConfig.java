package org.shop.config;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class ServiceConfig {

    private @Autowired
    ItemRepository itemRepository;
    private @Autowired ProductRepository productRepository;
    private @Autowired ProposalRepository proposalRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository);
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public ProposalService proposalService() {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}

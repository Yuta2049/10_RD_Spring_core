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

    private @Autowired ItemRepository itemRepository;
    private @Autowired ProductRepository productRepository;
    private @Autowired ProposalRepository proposalRepository;

    @Bean(name = "ItemService")
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository);
    }

    @Bean(name = "OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean(name = "ProductService")
    public ProductService productService() {
        return new ProductServiceImpl(productRepository);
    }

    @Bean(name = "ProposalService")
    public ProposalService proposalService() {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean(name = "SellerService")
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean(name = "UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

}

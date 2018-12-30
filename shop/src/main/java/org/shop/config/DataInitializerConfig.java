package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializerConfig {

    private ProductService productService;
    private UserService userService;

    @Bean(name = "DataInitializer")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean(name = "ProductInitializer")
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService);
    }

    @Bean(name = "ProposalInitializer")
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean(name = "SellerInitializer")
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean(name = "UserInitializer")
    public UserInitializer userInitializer() {
        return new UserInitializer(userService);
    }

}

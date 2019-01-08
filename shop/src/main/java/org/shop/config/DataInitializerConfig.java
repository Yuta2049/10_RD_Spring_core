package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@ComponentScan("org.shop")
public class DataInitializerConfig {

    private ProductService productService;
    private UserService userService;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService);
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public Map<Long, String> sellerNames() {
        Map<Long, String> sellerNames = new HashMap<>();
        sellerNames.put(1L, "Amazon");
        sellerNames.put(2L, "Samsung");
        return sellerNames;
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer() {
        return new UserInitializer(userService);
    }

    @Bean//(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

}



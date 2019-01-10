package org.shop.config;

import com.sun.javafx.util.Logging;
import org.shop.*;
import org.shop.annotation.InjectRandomIntTestClass;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.aspects.LoggingAspect;
import org.shop.common.Sellers;
import org.shop.data.Product;
import org.shop.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataInitializerConfig {

    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean
    @Qualifier("proposalInitializer")
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public Map<Long, String> sellerNames() {
        Map<Long, String> sellerNames = new HashMap<>();
        sellerNames.put(1L, Sellers.AMAZON);
        sellerNames.put(2L, Sellers.SAMSUNG);
        return sellerNames;
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }
}



package org.shop.config;

import com.sun.javafx.util.Logging;
import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.aspects.LoggingAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
//@ComponentScan({"org.shop, org.shop.config"})
//@EnableAspectJAutoProxy
public class DataInitializerConfig {

//    @Autowired
//    private LoggingAspect loggingAspect;
//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }

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
        sellerNames.put(1L, "Amazon");
        sellerNames.put(2L, "Samsung");
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



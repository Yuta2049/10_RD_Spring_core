package org.shop;


import org.shop.config.DataInitializerConfig;
import org.shop.config.RepositoryConfig;
import org.shop.config.ServiceConfig;
import org.shop.repository.factory.UserRepositoryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
@SpringBootApplication
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext

        //ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfig.class, ServiceConfig.class, DataInitializerConfig.class, UserRepositoryFactory.class);
        SpringApplication.run(ShopLauncher.class, args);




    }
}

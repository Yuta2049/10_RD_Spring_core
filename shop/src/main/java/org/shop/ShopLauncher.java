package org.shop;


import org.shop.api.ProductService;
import org.shop.config.DataInitializerConfig;
import org.shop.config.RepositoryConfig;
import org.shop.config.ServiceConfig;
import org.shop.data.Seller;
import org.shop.repository.factory.UserRepositoryFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.swing.*;
import javax.xml.crypto.Data;

/**
 * The ShopLauncher class.
 */
//@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan({"org.shop"})
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext

        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfig.class, ServiceConfig.class, DataInitializerConfig.class, UserRepositoryFactory.class);
        //ApplicationContext context = SpringApplication.run(ShopLauncher.class, args);

//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }


        // ProductInitializer
        ProductService productService = context.getBean(ProductService.class);
        productService.getProducts().forEach(System.out::println);




        SellerInitializer sellerInitializer = context.getBean(SellerInitializer.class);
        System.out.println(sellerInitializer.toString());

        DataInitializer dataInitializer = context.getBean(DataInitializer.class);

        System.out.println(dataInitializer.toString());

        dataInitializer.initData();


    }
}

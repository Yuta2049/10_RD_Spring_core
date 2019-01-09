package org.shop;


import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
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

        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfig.class, ServiceConfig.class, DataInitializerConfig.class, UserRepositoryFactory.class);

        System.out.println("Users:");
        UserService userService = context.getBean(UserService.class);
        userService.getUsers().forEach(System.out::println);

        ProductService productService = context.getBean(ProductService.class);
        System.out.println("Products:");
        productService.getProducts().forEach(System.out::println);

        SellerService sellerService = context.getBean(SellerService.class);
        System.out.println("Sellers:");
        sellerService.getSellers().forEach(System.out::println);

        System.out.println("Proposals:");
        ProposalService proposalService = context.getBean(ProposalService.class);
        sellerService.getSellers().forEach(x->proposalService.getProposalsBySeller(x).forEach(System.out::println));


    }
}

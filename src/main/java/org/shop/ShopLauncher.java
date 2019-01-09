package org.shop;

import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.aspects.LoggingAspect;
import org.shop.config.DataInitializerConfig;
import org.shop.config.FactoryConfig;
import org.shop.config.RepositoryConfig;
import org.shop.config.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import javax.xml.crypto.Data;

/**
 * The ShopLauncher class.
 */
@ComponentScan({"org.shop"})
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        //ApplicationContext context = new AnnotationConfigApplicationContext(DataInitializerConfig.class, FactoryConfig.class, RepositoryConfig.class, ServiceConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(DataInitializerConfig.class, FactoryConfig.class, RepositoryConfig.class, ServiceConfig.class, LoggingAspect.class);

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


        DataInitializer dataInitializer = context.getBean(DataInitializer.class);
        dataInitializer.initData();

    }
}

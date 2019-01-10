package org.shop;

import org.shop.annotation.InjectRandomIntBeanPostProcessor;
import org.shop.annotation.InjectRandomIntTestClass;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.aspects.LoggingAspect;
import org.shop.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import javax.xml.crypto.Data;

/**
 * The ShopLauncher class.
 */
//@ComponentScan({"org.shop"})
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AllConfig.class);

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

        InjectRandomIntTestClass injectRandomIntTestClass = context.getBean(InjectRandomIntTestClass.class);
        System.out.println(injectRandomIntTestClass.toString());
    }
}

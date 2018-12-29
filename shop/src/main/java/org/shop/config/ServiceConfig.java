package org.shop.config;

import org.shop.api.ItemService;
import org.shop.api.impl.ItemServiceImpl;
import org.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({RepositoryConfig.class})
public class ServiceConfig {

    private @Autowired ItemRepository itemRepository;

    @Bean(name = "ItemRepository")
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository);
    }

}

package org.shop.config;

import org.shop.repository.ItemRepository;
import org.shop.repository.map.ItemMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean(name = "ItemRepository")
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }
}


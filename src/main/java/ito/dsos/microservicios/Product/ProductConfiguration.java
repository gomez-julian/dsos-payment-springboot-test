package ito.dsos.microservicios.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class ProductConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ProductConfiguration.class);

    /*
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new ProductEntity("Nito", 13.0)));
            log.info("Preloading " + repository.save(new ProductEntity("Coca cola", 12.0)));
        };
    }
     */
}

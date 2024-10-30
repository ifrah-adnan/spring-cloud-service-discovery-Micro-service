package ma.adnan.inventoryservice.config;

import ma.adnan.inventoryservice.entities.Product;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
config.exposeIdsFor(Product.class) ;   }
}

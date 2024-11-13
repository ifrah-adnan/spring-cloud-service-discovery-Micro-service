package ma.adnan.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(int x ,int y) {


}

package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cuibin
 * @date 2020-07-31 14:29
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class AlibabaNacosMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosMain9002.class,args);
    }
}

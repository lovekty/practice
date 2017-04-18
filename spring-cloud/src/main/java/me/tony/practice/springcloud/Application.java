package me.tony.practice.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tony on 2017/3/10.
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class Application {

    @Autowired
    RestTemplate rest;
    @Value("${spring.application.name:testZookeeperApp}")
    private String appName;
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discovery;
    @Autowired
    private Environment env;
//    @Autowired
//    private AppClient appClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        new SpringApplicationBuilder().sources(Application.class).properties("application.yml", "bootstrap.yml").run(args);
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return this.loadBalancer.choose(this.appName);
    }

    @RequestMapping("/hi")
    public String hi() {
        return "Hello World! from " + this.discovery.getLocalServiceInstance();
    }

//    @RequestMapping("/self")
//    public String self() {
//        return this.appClient.hi();
//    }

    @RequestMapping("/myenv")
    public String env(@RequestParam("prop") String prop) {
        return new RelaxedPropertyResolver(this.env).getProperty(prop, "Not Found");
    }

    public String rt() {
        return this.rest.getForObject("http://" + this.appName + "/hi", String.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

//    @FeignClient("${spring.application.name:testZookeeperApp}")
//    interface AppClient {
//        @RequestMapping(path = "/hi", method = RequestMethod.GET)
//        String hi();
//    }
}

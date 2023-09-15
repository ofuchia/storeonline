package edu.tcu.cs.storeonline;

import edu.tcu.cs.storeonline.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreonlineApplication.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}

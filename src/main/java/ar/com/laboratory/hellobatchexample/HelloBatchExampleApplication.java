package ar.com.laboratory.hellobatchexample;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
@AllArgsConstructor
public class HelloBatchExampleApplication {



    public static void main(String[] args) {
        SpringApplication.run(HelloBatchExampleApplication.class, args);
    }




}

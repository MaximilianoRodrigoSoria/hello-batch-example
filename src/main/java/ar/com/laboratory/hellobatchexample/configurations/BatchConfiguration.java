package ar.com.laboratory.hellobatchexample.configurations;


import ar.com.laboratory.hellobatchexample.listeners.HelloJobExecutionListener;
import ar.com.laboratory.hellobatchexample.processor.InMemoryProcessor;
import ar.com.laboratory.hellobatchexample.readers.InMemoryReader;
import ar.com.laboratory.hellobatchexample.tasklests.HelloTasklet;
import ar.com.laboratory.hellobatchexample.writers.InMemoryWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Slf4j
@Component
public class BatchConfiguration {

    private JobBuilderFactory jobs;

    private StepBuilderFactory steps;

    private HelloJobExecutionListener helloJobExecutionListener;

    private InMemoryProcessor inMemeItemProcessor;

    private InMemoryReader reader;

    private InMemoryWriter inMemeItemWriter;

    @Bean
    public Step step1(){
        return steps.get("step")
                .<String, String>chunk(1)
                .reader(new ListItemReader<>(Arrays.asList("Maximiliano", "Rodrigo", "Soria")))
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    @Bean
    public Step step2(){
        return steps.get("step2")
                .tasklet(new HelloTasklet())
                .listener(helloJobExecutionListener)
                .build();
    }

    @Bean
    public Job helloWordJob(){
        return jobs.get("helloWorldJob")
                .listener(helloJobExecutionListener)
                .start(step1())
                .next(step2())
                .next(step3())
                .build();
    }

    @Bean
    public Step step3(){
        return steps.get("step3").
                <Integer,Integer>chunk(2)
                .reader(reader)
                .processor(inMemeItemProcessor)
                .writer(inMemeItemWriter)
                .build();
    }

}

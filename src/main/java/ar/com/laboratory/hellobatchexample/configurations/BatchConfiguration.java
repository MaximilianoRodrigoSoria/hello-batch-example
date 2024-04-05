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
    private HelloJobExecutionListener helloJobExecutionListener;
    private Step readNumberStep;
    private Step helloWorldStep;

    @Bean
    public Job initialJob(){
        return jobs.get("helloWorldJob")
                .listener(helloJobExecutionListener)
                .start(helloWorldStep)
                .next(readNumberStep)
                .build();
    }



}
